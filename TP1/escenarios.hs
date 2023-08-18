import Point
import City
import Quality
import Link

a = newP 1 1
b = newP 2 2

dist = difP a b

cityA = newC "A" a
cityB = newC "B" b
cityC = newC "A" a

distAB = distanceC cityA cityB