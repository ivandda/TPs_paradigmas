module Errors
   where
----------------------Mensajes----------------------
errNumEntero = "El valor solo puede ser entero"
errNumNegativo = "El valor solo puede ser positivo"
errNumNegativoYEntero = "El valor solo puede ser entero positivo"
errEqCit = "Operacion invalida ente dos ciudades iguales"



----------------------Funciones----------------------
-- isInt x = x == fromInteger (round x)
isNeg x = x <= 0
