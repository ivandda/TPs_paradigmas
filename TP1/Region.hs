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
-- foundR (Reg (city:cities) links tunels) city1 = Reg (city1:city:cities) links tunels
foundR (Reg cities links tunels) city
      | isCoordAvailable city (Reg cities links tunels)  = Reg (city:cities) links tunels
      | otherwise = error errAddCityToOccupiedSpace

areCitiesInRegion :: City -> City -> Region -> Bool
areCitiesInRegion city1 city2 (Reg cities links tunels) = city1 `elem` cities && city2 `elem` cities

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality
      | areCitiesInRegion city1 city2 (Reg cities links tunels) = Reg cities (newL city1 city2 quality:links) tunels
      | otherwise = error errCitiesNotInRegion

-- usesOfLinkInTunel :: Link -> Tunel -> Int
-- usesOfLinkInTunel link tunel= foldl (\acc linkThatIsUsedByT -> acc + (if usesT link linkThatIsUsedByT then 1 else 0)) 0 tunel

-- usesOfLinkInTunel2 :: Link -> Tunel -> Int
-- usesOfLinkInTunel2 link (Tun links) = foldl (\acc x -> if usesT link (Tun links) then 1 else 0 + acc) 0 links

-- getAvailableCapacity :: Link -> Region -> Int
-- getAvailableCapacity link (Reg _ _ tunels) = (capacityL link) - ()

-- isThereLink :: City -> City -> Region
-- isthereLink city1 city2 (Reg cities links tunels) = foldl (\acc city2 -> (distanceC city1 city2 /= 0) && acc) True cities
-- isLinkAvailable :: []

-- tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
-- tunelR (Reg cities links tunels) cities = 

-- connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
-- linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
-- delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
-- availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

-- -- Si tengo un Tunel AC en el link ABC, AB no estan conectados por el tunel, pero 
--       --AC si estan conectados con el tunel. No puedo salir en el medio del tunel

-- --El delay del tunel es la suma del delay de todos los enlaces (en tiempo?)

-- -- Chequear escenario donde se crea un link nuevo en donde ya existe un link

--Los test son escenarios