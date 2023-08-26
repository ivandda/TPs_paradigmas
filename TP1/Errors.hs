module Errors
   where
----------------------Mensajes----------------------
errNumNegativo = "Value cannot be nagative"
errEqCitCoords = "Invalid operation between two cities on the same coords"
errAddCityToOccupiedSpace = "City cannot be added to an occupied space by other city"
errCitiesNotInRegion = "Cities are the same or not available in the region, they cannot be linked"



----------------------Funciones----------------------
-- isInt x = x == fromInteger (round x)
isNeg x = x <= 0
