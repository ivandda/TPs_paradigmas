import Point
import City
import Quality
import Link
import Tunel
p1 = newP 0 0
p2 = newP 3 4
p3 = newP (-3) 4
p4 = newP (-80) 30
p5 = newP (-200) (-75)

city1 = newC "Buenos Aires" p1
city2 = newC "Cordoba" p2
city3 = newC "Mendoza" p3
city4 = newC "Salta" p4
city5 = newC "Rosario" p5

q1 = newQ "A" 10 0.001
q2 = newQ "B" 7 0.0005
q3 = newQ "C" 4 0.000001
q4 = newQ "D" 2 0.0000009
q5 = newQ "A" (-10) 0.001 --Error errNumNegativo
q6 = newQ "A" (-10) (-0.001)--Error errNumNegativo
q7 = newQ "A" 10 (-0.001)--Error errNumNegativo

link1 = newL city1 city2 q1
link2 = newL city1 city1 q1 -- invalido: no se puedan linkear dos ciudades iguales
link3 = newL city2 city3 q1

tPoint = [
      difP p1 p2 == 5,
      difP p1 p3 == 5,
      difP p4 p5 == 159.4522,
      difP p3 p5 == 212.24985,
      True]

tCity = [   
      nameC city1 == "Buenos Aires",
      nameC city2 == "Cordoba",
      nameC city3 == "Mendoza",
      nameC city4 == "Salta",
      nameC city5 == "Rosario",

      distanceC city1 city2 == 5,
      distanceC city2 city1 == 5,
      distanceC city1 city3 == 5,
      distanceC city4 city5 == 159.4522,
      distanceC city3 city5 == 212.24985,

      True]

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

tLinks = [
      link1 == newL city1 city2 q1,

      connectsL city1 link1 == True,
      connectsL city2 link1 == True,
      connectsL city3 link1 == False,

      linksL city1 city2 link1 == True,
      linksL city2 city1 link1 == True,
      linksL city3 city1 link1 == False,

      capacityL link1 == 10,

      delayL link1 == 0.001/5,
      True]


t = newT [link1, link3]
a = connectsT city1 city2 t

t1 = newT [link1]
b = connectsT city1 city2 t1