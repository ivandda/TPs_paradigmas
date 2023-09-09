module Errors
   where
----------------------Mensajes----------------------
errNumNegativo :: String
errNumNegativo = "Value cannot be nagative"
errEqCitCoords :: String
errEqCitCoords = "Invalid operation between two cities on the same coords"
errAddCityToOccupiedSpace :: String
errAddCityToOccupiedSpace = "City cannot be added to an occupied space by other city"
errCitiesNotInRegion :: String
errCitiesNotInRegion = "Cities are the same or not available in the region, they cannot be linked"
errCitiesAreTheSame :: String
errCitiesAreTheSame = "Cant create tunel, extreme cities are the same"
errNoTunel :: String
errNoTunel = "There is no available tunel"
errNoLink :: String
errNoLink = "There is no available link"
errTunelExists :: String
errTunelExists = "Cant create tunel, a tunel already exists"
errCapacity :: String
errCapacity = "No capacity in link to create tunel"


isNeg x = x <= 0
