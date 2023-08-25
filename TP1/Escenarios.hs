import Point
import City
import Quality
import Link
import Tunel
import Region
p1 = newP 0 0
p2 = newP 3 4
p3 = newP (-3) 4
p4 = newP (-80) 30
p5 = newP (-200) (-75)


tPoint = [
      difP p1 p2 == 5,
      difP p1 p3 == 5,
      difP p4 p5 == 159.4522,
      difP p3 p5 == 212.24985,
      True]

city1 = newC "Buenos Aires" p1
city2 = newC "Cordoba" p2
city3 = newC "Mendoza" p3
city4 = newC "Salta" p4
city5 = newC "Rosario" p5
city6 = newC "La Plata" p1
city7 = newC "Buenos Aires" p1

tCity = [   
      nameC city1 == "Buenos Aires",
      nameC city2 == "Cordoba",
      nameC city3 == "Mendoza",
      nameC city4 == "Salta",
      nameC city5 == "Rosario",

      distanceC city1 city2 == 5,
      distanceC city2 city1 == 5,
      distanceC city1 city3 == 5,
      distanceC city2 city3 == 6,
      distanceC city4 city5 == 159.4522,
      distanceC city3 city5 == 212.24985,

      True]

q1 = newQ "A" 10 0.001
q2 = newQ "B" 7 0.0005
q3 = newQ "C" 4 0.000001
q4 = newQ "D" 2 0.0000009
q5 = newQ "A" (-10) 0.001 --Error errNumNegativo
q6 = newQ "A" (-10) (-0.001)--Error errNumNegativo
q7 = newQ "A" 10 (-0.001)--Error errNumNegativo
q8 = newQ "A" 10 7

tQuiality = [
      capacityQ q1 == 10,
      capacityQ q2 == 7,
      capacityQ q3 == 4,
      capacityQ q4 == 2,

      delayQ q1 == 0.001,
      delayQ q2 == 0.0005,
      delayQ q3 == 0.000001,
      delayQ q4 == 0.0000009,

      True]


linkN = newL city1 city1 q1 -- invalido: no se puedan linkear dos ciudades iguales
link1 = newL city1 city2 q1
link2 = newL city2 city3 q1
link3 = newL city4 city3 q1
link4 = newL city2 city1 q1
link5 = newL city3 city5 q2

tLinks = [
      link1 == newL city1 city2 q1,

      connectsL city1 link1 == True,
      connectsL city2 link1 == True,
      connectsL city3 link1 == False,

      linksL city1 city2 link1 == True,
      linksL city2 city1 link1 == True,
      linksL city3 city1 link1 == False,

      capacityL link1 == 10,

      delayL link1 == 5/0.001,
      True]


tunnel1 = newT [link1]
tunnel2 = newT [link1, link2, link3]
tunnel3 = newT [link4, link2, link3]
tunnel4 = newT [link4, link2]
tunnel5 = newT [link2]
tunnel6 = newT [link5]
tunnel7 = newT [link1, link2, link5]
tunnel8 = newT [link1, link2, link5, link2]


tTunnels = [
            connectsT city1 city2 tunnel1 == True,
            connectsT city1 city4 tunnel2 == True,
            connectsT city1 city4 tunnel3 == True,
            connectsT city1 city3 tunnel4 == True,

            connectsT city2 city1 tunnel1 == True,
            connectsT city1 city3 tunnel2 == False,
            connectsT city2 city4 tunnel3 == False,

            usesT link1 tunnel1 == True,
            usesT link2 tunnel1 == False,
            (usesT link1 tunnel2) && (usesT link2 tunnel2) && (usesT link3 tunnel2) == True,

            delayT tunnel1 == 5/0.001,
            delayT tunnel4 == 11000,
            delayT tunnel7 == delayT tunnel4 + delayT tunnel6,

            True]

region1 = newR
region2 = foundR region1 city1
region3 = foundR region2 city2
region4 = foundR region3 city2 -- err errAddCityToOccupiedSpace
region5 = foundR region3 city6 -- err errAddCityToOccupiedSpace
region6 = foundR region2 city7 -- err errAddCityToOccupiedSpace

tRegion = [
      isCoordAvailable city1 region1,
      isCoordAvailable city1 region2 == False,
      isCoordAvailable city1 region3 == False,
      isCoordAvailable city2 region3 == False,
      isCoordAvailable city3 region3,
      True]