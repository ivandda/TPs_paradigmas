module Region --( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import City
import Link
import Tunel
import Quality
import Errors

data Region = Reg [City] [Link] [Tunel] deriving (Show)

isCoordAvailable:: City -> Region -> Bool
isCoordAvailable city1 (Reg cities _ _) = foldl (\acc city2 -> (distanceC city1 city2 /= 0) && acc) True cities


newR :: Region --Se arranca con la region vacia
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) city
      | isCoordAvailable city (Reg cities links tunels)  = Reg (city:cities) links tunels
      | otherwise = error errAddCityToOccupiedSpace

areCitiesInRegion :: City -> City -> Region -> Bool
areCitiesInRegion city1 city2 (Reg cities links tunels) = city1 /= city2 && city1 `elem` cities && city2 `elem` cities

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality
      | areCitiesInRegion city1 city2 (Reg cities links tunels) = Reg cities (newL city1 city2 quality:links) tunels
      | otherwise = error errCitiesNotInRegion

nUsesOfLinkInRegion :: Link -> Region -> Int
nUsesOfLinkInRegion link (Reg cities links []) = 0
nUsesOfLinkInRegion link (Reg cities links (tunel:tunels))
      |usesT link tunel = 1 + nUsesOfLinkInRegion link (Reg cities links tunels)
      |otherwise = nUsesOfLinkInRegion link (Reg cities links tunels)

nCapacityAvailable :: Link -> Region -> Int
nCapacityAvailable link region = capacityL link - nUsesOfLinkInRegion link region

isCapacityAvailable :: Link -> Region -> Bool
isCapacityAvailable link region = nCapacityAvailable link region > 0

isCapacityAvailableMultiple :: [Link] -> Region -> Bool
isCapacityAvailableMultiple link region = foldl(\acc x -> acc && isCapacityAvailable x region) True link

isThereAlreadyATunel :: [Tunel] -> City -> City -> Bool
isThereAlreadyATunel [] city1 city2 = False
isThereAlreadyATunel (tunel:tunels) city1 city2 
      = connectsT city1 city2 tunel || isThereAlreadyATunel tunels city1 city2

 
addTunel :: Region -> [Tunel] -> Region
addTunel (Reg cities links tunels) tunel= Reg cities links (tunel ++ tunels)

isPosibleToCreateTunel :: Region -> [City] -> Bool
isPosibleToCreateTunel (Reg rCities links tunels) cities
      | isThereAlreadyATunel tunels cityA cityB = error errTunelExists
      | not (areCitiesInRegion cityA cityB (Reg rCities links tunels)) = error errCitiesNotInRegion
      | not (isCapacityAvailableMultiple links (Reg rCities links tunels)) = error errCapacity
      where cityA = head cities
            cityB = last cities

-- tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
-- tunelR (Reg cities links tunels) cities
--       |isPosibleToCreateTunel = --linksL
--       |otherwise = error "no se puede crear el tunel"

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links (tunel:tunels)) city1 city2
      | not (areCitiesInRegion city1 city2 (Reg cities links (tunel:tunels))) = error errCitiesNotInRegion
      | tunels == [] = connectsT city1 city2 tunel
      | otherwise = connectsT city1 city2 tunel || connectedR (Reg cities links tunels) city1 city2

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ [] _) _ _ = False
linkedR (Reg cities (link:links) tunels) city1 city2 
      |not (areCitiesInRegion city1 city2 (Reg cities (link:links) tunels)) = error errCitiesNotInRegion
      |otherwise = linksL city1 city2 link || linkedR (Reg cities links tunels) city1 city2 


tunnelBetweenCities :: Region -> City -> City -> Tunel
tunnelBetweenCities (Reg cities links []) city1 city2 = error errNoTunel
tunnelBetweenCities (Reg cities links (tunel:tunels)) city1 city2
      |connectsT city1 city2 tunel = tunel
      |otherwise = tunnelBetweenCities (Reg cities links tunels) city1 city2

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR region city1 city2
      |not (areCitiesInRegion city1 city2 region) = error errCitiesNotInRegion
      |otherwise = delayT (tunnelBetweenCities region city1 city2)

linkBetweenCities :: Region -> City -> City -> Link
linkBetweenCities (Reg cities [] tunels) city1 city2 = error errNoLink
linkBetweenCities (Reg cities (link:links) tunels) city1 city2
      |linksL city1 city2 link = link
      |otherwise = linkBetweenCities (Reg cities links tunels) city1 city2

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR region city1 city2
      |not (areCitiesInRegion city1 city2 region) = error errCitiesNotInRegion
      |otherwise = nCapacityAvailable (linkBetweenCities region city1 city2) region

-- -- Si tengo un Tunel AC en el link ABC, AB no estan conectados por el tunel, pero 
--       --AC si estan conectados con el tunel. No puedo salir en el medio del tunel

-- --El delay del tunel es la suma del delay de todos los enlaces (en tiempo?)

-- -- Chequear escenario donde se crea un link nuevo en donde ya existe un link

--Los test son escenarios

--dos qualities no pueden tener el mimso nombre (Str) 
--tampoco diferente nombre e iguales cap y delay




-- usesOfLinkInTunel :: Link -> Tunel -> Int
-- usesOfLinkInTunel link tunel= foldl (\acc linkThatIsUsedByT -> acc + (if usesT link linkThatIsUsedByT then 1 else 0)) 0 tunel

-- usesOfLinkInTunel2 :: Link -> Tunel -> Int
-- usesOfLinkInTunel2 link (Tun links) = foldl (\acc x -> if usesT link (Tun links) then 1 else 0 + acc) 0 links

-- getAvailableCapacity :: Link -> Region -> Int
-- getAvailableCapacity link (Reg _ _ tunels) = (capacityL link) - ()

-- isThereLink :: City -> City -> Region
-- isthereLink city1 city2 (Reg cities links tunels) = foldl (\acc city2 -> (distanceC city1 city2 /= 0) && acc) True cities
-- isLinkAvailable :: []


-- necessaryLinksForTunel :: City -> City -> [Link] -> [Link] -> [Link]
-- necessaryLinksForTunel city1 city2 [] _ = error "no links available"
-- necessaryLinksForTunel city1 city2  (link:availableLinks) necessaryLinks
--       | linksL city1 city2 link = link : necessaryLinks
--       | otherwise = necessaryLinksForTunel city1 city2 availableLinks necessaryLinks


-- necessaryLinksForTunel2 :: Region -> [City] -> [Links] -> [Links]
-- necessaryLinksForTunel2 (Reg cities availableLinks tunels) (city1:city2:[]) necessaryLinks = necessaryLinksForTunel city1 city2 availableLinks necessaryLinks
-- necessaryLinksForTunel2 (Reg cities availableLinks tunels) (city1:cities) necessaryLinks =