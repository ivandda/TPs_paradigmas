module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR )
      where

import City
import Link
import Tunel
import Quality
import Errors

data Region = Reg [City] [Link] [Tunel] deriving (Show)

newR :: Region -- se arranca con la region vacia
newR = Reg [] [] []


isCoordAvailable:: Region -> City -> Bool
isCoordAvailable (Reg rCities _ _) city1 = foldl (\acc city2 -> (distanceC city1 city2 /= 0) && acc) True rCities

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg rCities rLinks rTunels) city
      | isCoordAvailable (Reg rCities rLinks rTunels) city = Reg (city:rCities) rLinks rTunels
      | otherwise = error errAddCityToOccupiedSpace


areExtremesInRegion :: Region -> City -> City -> Bool
areExtremesInRegion (Reg rCities _ _) city1 city2 = city1 /= city2 && city1 `elem` rCities && city2 `elem` rCities

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality
      | areExtremesInRegion (Reg cities links tunels) city1 city2 = Reg cities (newL city1 city2 quality:links) tunels
      | otherwise = error errCitiesNotInRegion


nUsesOfLinkInRegion :: Region -> Link -> Int
nUsesOfLinkInRegion (Reg cities links []) link = 0
nUsesOfLinkInRegion (Reg cities links (tunel:tunels)) link
      | usesT link tunel = 1 + nUsesOfLinkInRegion (Reg cities links tunels) link
      | otherwise = nUsesOfLinkInRegion (Reg cities links tunels) link

nCapacityAvailable :: Region -> Link -> Int
nCapacityAvailable region link = capacityL link - nUsesOfLinkInRegion region link

linksAvailable :: Region -> City -> City -> [Link]
linksAvailable (Reg _ rLinks _) cityX cityY = filter (linksL cityX cityY) rLinks

bestLinkAvailable :: Region -> City -> City -> Link
bestLinkAvailable (Reg rCities rLinks rTunels) cityX cityY
      | not (linkedR (Reg rCities rLinks rTunels) cityX cityY) = error errNoLink
      | otherwise = foldr1 (\linkX linkY -> if nCapacityAvailable (Reg rCities rLinks rTunels) linkX >= nCapacityAvailable (Reg rCities rLinks rTunels) linkY then linkX else linkY) (linksAvailable (Reg rCities rLinks rTunels) cityX cityY)

linksForTunel :: Region -> [City] -> [Link]
linksForTunel region cities = [ if nCapacityAvailable region (bestLinkAvailable region cityX cityY) > 0 then bestLinkAvailable region cityX cityY else error errCapacity | (cityX, cityY) <- zip <*> tail $ cities]
createTunel :: Region -> [City] -> Tunel
createTunel region cities = newT (linksForTunel region cities)

areCitiesInRegion :: [City] -> [City] -> Bool
areCitiesInRegion rCities citiesToLink =
      case citiesToLink of
            [] -> True
            c : cs -> (c `elem` rCities) && (rCities `areCitiesInRegion` cs)

isThereAlreadyATunel :: [Tunel] -> City -> City -> Bool
isThereAlreadyATunel tunels firstCity lastCity = foldr ((||) . connectsT firstCity lastCity) False tunels

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg rCities rLinks rTunels) citiesToLink
      | not (areCitiesInRegion rCities citiesToLink) = error errCitiesNotInRegion
      | isThereAlreadyATunel rTunels firstCity lastCity = error errTunelExists
      | otherwise = Reg rCities rLinks (createTunel (Reg rCities rLinks rTunels) citiesToLink : rTunels)
      where firstCity = head citiesToLink
            lastCity = last citiesToLink


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links (tunel:tunels)) city1 city2
      | not (areExtremesInRegion (Reg cities links (tunel:tunels)) city1 city2) = False --error errCitiesNotInRegion
      | tunels == [] = connectsT city1 city2 tunel
      | otherwise = connectsT city1 city2 tunel || connectedR (Reg cities links tunels) city1 city2


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ [] _) _ _ = False
linkedR (Reg cities (link:links) tunels) city1 city2
      | not (areExtremesInRegion (Reg cities (link:links) tunels) city1 city2) = error errCitiesNotInRegion
      | otherwise = linksL city1 city2 link || linkedR (Reg cities links tunels) city1 city2


tunnelBetweenCities :: Region -> City -> City -> Tunel
tunnelBetweenCities (Reg cities links []) city1 city2 = error errNoTunel
tunnelBetweenCities (Reg cities links (tunel:tunels)) city1 city2
      | connectsT city1 city2 tunel = tunel
      | otherwise = tunnelBetweenCities (Reg cities links tunels) city1 city2

areTwoCitiesInRegion :: Region -> City -> City -> Bool
areTwoCitiesInRegion (Reg cities links tunels) city1 city2 = city1 /= city2 && city1 `elem` cities && city2 `elem` cities

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR region city1 city2
      | not (areTwoCitiesInRegion region city1 city2) = error errCitiesNotInRegion
      | otherwise = delayT (tunnelBetweenCities region city1 city2)


linkBetweenCities :: Region -> City -> City -> Link
linkBetweenCities (Reg cities [] tunels) city1 city2 = error errNoLink
linkBetweenCities (Reg cities (link:links) tunels) city1 city2
      | linksL city1 city2 link = link
      | otherwise = linkBetweenCities (Reg cities links tunels) city1 city2


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR region city1 city2
      | not (areTwoCitiesInRegion region city1 city2) = error errCitiesNotInRegion
      | otherwise = nCapacityAvailable region (bestLinkAvailable region city1 city2)