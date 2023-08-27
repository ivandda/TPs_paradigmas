module Errors
   where
----------------------Mensajes----------------------
errNumNegativo = "Value cannot be nagative"
errEqCitCoords = "Invalid operation between two cities on the same coords"
errAddCityToOccupiedSpace = "City cannot be added to an occupied space by other city"
errCitiesNotInRegion = "Cities are the same or not available in the region, they cannot be linked"
errNoTunel = "There is no available tunel"
errNoLink = "There is no available link"
errTunelExists = "Cant create tunel, a tunel already exists"
errCapacity = "No capacity in link to create tunel"



----------------------Funciones----------------------
-- isInt x = x == fromInteger (round x)
isNeg x = x <= 0
