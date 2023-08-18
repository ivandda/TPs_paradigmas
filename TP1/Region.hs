module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

data Region = Reg [City] [Link] [Tunel]
newR :: Region --Se arranca con la region vacia
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

-- Si tengo un Tunel AC en el link ABC, AB no estan conectados por el tunel, pero 
      --AC si estan conectados con el tunel. No puedo salir en el medio del tunel

--El delay del tunel es la suma del delay de todos los enlaces (en tiempo?)

-- Chequear escenario donde se crea un link nuevo en donde ya existe un link

-- Los test son escenarios 