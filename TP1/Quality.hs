module Quality (Quality, newQ, capacityQ, delayQ)
   where

import Errors

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ name capacity quality
  | isNeg capacity || isNeg quality = error errNumNegativo
  | otherwise = Qua name capacity quality

capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua _ capacity _) = capacity

delayQ :: Quality -> Float -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua _ _ delay) = delay
