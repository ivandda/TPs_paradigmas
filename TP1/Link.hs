module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import Errors
import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city1 city2 quality
      | distanceC city1 city2 == 0 = error errEqCitCoords
      | otherwise = Lin city1 city2 quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin cityA cityB _)
      | (city == cityA) || (city == cityB) = True
      | otherwise = False

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 link
      | connectsL city1 link && connectsL city2 link = True
      | otherwise = False

capacityL :: Link -> Int
capacityL (Lin _ _ quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin city1 city2 quality) = distanceC city1 city2 / delayQ quality
