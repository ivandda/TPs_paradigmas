import Point
import City
import Quality
import Link
import Tunel
import Region


p1 = newP 0 0
p2 = newP 0 9
p3 = newP 4 6
p4 = newP 8 9
p5 = newP 15 9
p6 = newP 6 9
p7 = newP 0 1


tPoint = [
      difP p1 p2 == 9,
      difP p2 p3 == 5,
      difP p3 p4 == 5,
      difP p4 p5 == 7,
      difP p5 p6 == 9,
      difP p6 p7 == 10,
      True]

city1 = newC "Buenos Aires" p1
city2 = newC "Cordoba" p2
city3 = newC "Mendoza" p3
city4 = newC "Salta" p4
city5 = newC "Rosario" p5

errCity1 = newC "La Plata" p1
errCity2 = newC "Aires Buenos" p1

tCity = [   
      nameC city1 == "Buenos Aires",
      nameC city2 == "Cordoba",
      nameC city3 == "Mendoza",
      nameC city4 == "Salta",
      nameC city5 == "Rosario",

      distanceC city1 city2 == 9,
      distanceC city2 city3 == 5,
      distanceC city3 city4 == 5,
      distanceC city4 city5 == 7,

      distanceC city2 city1 == 9,
      distanceC city2 city4 == 8,
      distanceC city2 city5 == 15,

      True]

errorQ1 = newQ "A" (-10) 0.001 --Error errNumNegativo
errorQ2 = newQ "A" (-10) (-0.001)--Error errNumNegativo
errorQ3 = newQ "A" 10 (-0.001)--Error errNumNegativo

q1 = newQ "A" 10 2
q2 = newQ "B" 7 4
q3 = newQ "C" 4 10
q4 = newQ "D" 2 20
q5 = newQ "A" 1 0.5

tQuality = [
      capacityQ q1 == 10,
      capacityQ q2 == 7,
      capacityQ q3 == 4,
      capacityQ q4 == 2,
      capacityQ q5 == 1,

      delayQ q1 == 2,
      delayQ q2 == 4,
      delayQ q3 == 10,
      delayQ q4 == 20,

      True]


errorLink1 = newL city1 city1 q1 -- Error errEqCitCoords
errorLink2 = newL errCity1 errCity2 q2 -- Error errEqCitCoords

link1 = newL city1 city2 q1
link2 = newL city2 city3 q1
link3 = newL city4 city5 q1
link4 = newL city2 city4 q4
link5 = newL city2 city5 q5

link1Bis = newL city2 city1 q1
link3Bis = newL city5 city4 q1

tLinks = [
      connectsL city1 link1 == True,
      connectsL city2 link1 == True,
      connectsL city3 link1 == False,

      linksL city1 city2 link1 == True,
      linksL city2 city1 link1 == True,
      linksL city3 city1 link1 == False,

      capacityL link1 == 10,
      capacityL link4 == 2,
      capacityL link5 == 1,

      delayL link1 == 4.5, --9/2
      delayL link2 == 2.5, --5/2
      delayL link3 == 3.5, --7/2
      delayL link4 == 0.4, --8/20
      delayL link5 == 30,--15/0.5
      True]


tunnel1 = newT [link1] -- c1-c2
tunnel2 = newT [link1, link2] -- c1-c2 | c2 -c3 
tunnel3 = newT [link1, link2, link3]-- c1-c2 | c2 -c3 | c4 -c5 
tunnel4 = newT [link1, link4]-- c1-c2 | c2-c4
tunnel5 = newT [link1, link5]-- c1-c2 | c2-c5
tunnel6 = newT [link1Bis, link2, link3Bis]-- c2-c1 | c2 -c3 | c5 -c4
tunnel7 = newT [link1, link2, link5]


tTunnels = [
            connectsT city1 city2 tunnel1 == True,
            connectsT city1 city3 tunnel2 == True,
            connectsT city1 city5 tunnel3 == True,
            connectsT city1 city4 tunnel4 == True,

            connectsT city1 city5 tunnel6 == True,

            usesT link1 tunnel1 == True,
            usesT link2 tunnel1 == False,
            (usesT link1 tunnel3) && (usesT link2 tunnel3) && (usesT link3 tunnel3) == True,

            delayT tunnel1 == 4.5,
            delayT tunnel2 == 4.5 + 2.5,
            delayT tunnel3 == 4.5 + 2.5 +3.5,
            delayT tunnel5 == 4.5 + 30,
            delayT tunnel3 == delayT tunnel6,

            True]

regionA1 = newR
regionA2 = foundR regionA1 city1

errorRegionCoords1 = foundR regionA2 city1 -- err errAddCityToOccupiedSpace
errorRegionCoords2 = foundR regionA2 errCity1 -- err errAddCityToOccupiedSpace
errorRegionCoords3 = foundR regionA2 errCity2 -- err errAddCityToOccupiedSpace

regionA3 = foundR regionA2 city2
regionA4 = foundR regionA3 city3
regionA5 = foundR regionA4 city4
regionA6 = foundR regionA5 city5

errorRegionLinkCities4 = linkR regionA6 errCity1 city2 q1 -- err errCitiesNotInRegion
errorRegionLinkCities5 = linkR regionA6 errCity1 errCity2 q1 -- err errCitiesNotInRegion
errorRegionLinkCities6 = linkR regionA6 city1 city1 q1 -- err errCitiesNotInRegion
regionA7  = linkR regionA6 city1 city2 q1
regionA8  = linkR regionA7 city2 city3 q1
regionA9  = linkR regionA8 city3 city4 q1

regionA10  = linkR regionA9 city4 city5 q1
regionA11 = linkR regionA10 city5 city1 q5

regionB1 = tunelR regionA10 [city1, city2, city3, city4, city5]
regionB2 = tunelR regionA10 [city5, city4, city3, city2, city1]
regionB3 = tunelR regionA10 [city5, city4, city3, city2, city1, city2, city3, city4]
regionB4 = tunelR regionA11 [city1, city5]
errorRegionTunel7 = tunelR regionB4 [city1, city5] -- Exception: Cant create tunel, a tunel already exists
errorRegionTunel8 = tunelR regionB4 [city1, city5, city4] -- Exception: No capacity in link to create tunel
errorRegionTunel9 = tunelR regionB4 [city1, city3] -- Exception: There is no available link
errorRegionTunel10 = tunelR regionA3 [city1, city5] --  Cities are the same or not available in the region, they cannot be linked
errorRegionTunel11 = tunelR regionA10 [city5, city4, city3, city2, city1, city2, city3, city4, city5] --errorRegionTunel10

tRegion = [
      connectedR regionB1 city1 city5 == True,
      connectedR regionB1 city1 errCity2 == False,
      connectedR regionB4 city4 city2 == False,
      connectedR regionB4 city3 city4 == False,

      linkedR regionB1 city1 city2 == True,
      linkedR regionB1 city1 city5 == False,

      delayR regionB1 city1 city5 == 13.0,
      delayR regionB1 city5 city1 == 13.0,
      delayR regionB3 city5 city4 == 22.5,
      
      availableCapacityForR regionB1 city1 city2 == 9,
      availableCapacityForR regionB4 city1 city5 == 0,
      availableCapacityForR regionB4 city1 city5 == 0,
             
      True]
      