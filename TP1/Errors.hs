module Errors
   where
----------------------Mensajes----------------------
errNumNegativo = "El valor solo puede ser positivo"
errEqCit = "Operacion invalida ente dos ciudades iguales"
errAddCityToOccupiedSpace = "City cannot be added to an occupied space by other city"
errCitiesNotInRegion = "Cities are not available in the region, they cannot be linked"



----------------------Funciones----------------------
-- isInt x = x == fromInteger (round x)
isNeg x = x <= 0
