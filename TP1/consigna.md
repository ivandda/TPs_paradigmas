# Consignas
## Telco

Es una compañia que se dedica a comunicar las ciudades que se susbcriben a su servicio.
Primero las ingresa al mapa de la región. 
Luego establece vínculos / link entre ellas de cierta calidad y capacidad.
Finalmente establece canales / tunel que conectan distintas ciudades ocupando una unidad de 
     capacidad por cada enlace / vinculo / link recorrido.



## Definiciones y expectativas del tp.

- Entrega: El trabajo debe estar en el repo informado el domingo 27 de Agosto a las 23:59hs
- Cada módulo debe estar en un archivo separado.
- Deben entregar todas las expresiones usadas en el desarrollo del trabajo,
- Se sugiere entregar un archivo .hs extra desde donde se carguen todos los módulos 
         y se puedan correr las expresiones de desarrollo.
- Esperamos que no haya código repetido y haya un aprovechamiento inteligente del código.
- En las expresiones de test o desarrollo deben verse las decisiones tomadas 
         durante el desarrollo, por ejemplo  (y es solo un ejemplo), al agregar 
         a la región una ciudad con el mismo nombre deben decidirse por
 a) da error, b) no hace nada, c) la segunda reemplaza a la primera d) otro
y expresarlo en los test
- los nombres de las funciones deben ser buenos nombres asociados a las semantica de la función
- seguir las pautas dadas en clase



## Para sostener este modelo se cuenta con las siguientes entidades:

module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
difP :: Point -> Point -> Float  -- distancia absoluta

### City

module City ( City, newC, nameC, distanceC )
   where

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float

### Quality

module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal

### link

module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
capacityL :: Link -> Int
delayL :: Link -> Float     -- la demora que sufre una conexion en este canal

### Tunel

module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel

### Region

module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

data Region = Reg [City] [Link] [Tunel]
newR :: Region
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades