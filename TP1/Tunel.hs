module Tunel ( Tunel, newT, connectsT)--, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

-- { Un Tunel es la conexión lógica que podemos establecer entre dos puntos, también es bidireccional}
newT :: [Link] -> Tunel
newT = Tun

-- func :: City -> City -> (City)

connectsT :: City -> City -> Tunel -> Bool 
   -- inidca si este tunel conceta estas dos ciudades distintas
   -- { dadas dos ciudades esta función da si si las ciudades son los extremos del túnel }
connectsT city1 city2 (Tun links)
      |length links == 1 = linksL city1 city2 (head links)
      |otherwise =  False




--usesT :: Link -> Tunel -> Bool  
   -- indica si este tunel atraviesa ese link
   --{ Un túnel recorre una serie de uno o más links, esta función indica si el link consultado es parte de esa serie }
--delayT :: Tunel -> Float 
   -- la demora que sufre una conexion en este tunel
   --{ esta demora es en unidades de tiempo, cuanto demora la información en recorrer el túnel}