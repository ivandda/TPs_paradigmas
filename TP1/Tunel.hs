module Tunel --( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

isFirst :: City -> [Link] -> Bool
isFirst city links = connectsL city (head links) && not (connectsL city (head (tail links)))

isLast :: City -> [Link] -> Bool
isLast city links = connectsL city (last links) && not (connectsL city (last (init links)))

connectsT :: City -> City -> Tunel -> Bool
connectsT city1 city2 (Tun links)
      | length links == 1 = linksL city1 city2 (head links)
      | otherwise = (isFirst city1 links && isLast city2 links) || (isFirst city2 links && isLast city1 links)




usesT :: Link -> Tunel -> Bool -- indica si este túnel atraviesa ese link
usesT link (Tun links) = link `elem` links

delayT :: Tunel -> Float
delayT (Tun links) = foldl (\acc x -> delayL x + acc) 0 links