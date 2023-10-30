## Instrucciones

Para compilar el código ejecutar fuera del paquete linea lo siguiente:
```
javac linea/Linea.java linea/Game.java
```
Para correr el juego ejecutar los siguiente:
```
java linea.Game
```

## Enunciado

- La fecha de entrega es Domingo 12 de noviembre, 23:59 hs
- La entrega debe hacerse en el repositorio informado por cada grupo incluyendo los fuentes que implementan el TP y sus correspondientes tests.

---

Se nos pide desarrollar la lógica de juego del '4 en línea'. (https://www.epasatiempos.es/juego-4-en-raya.php)
El espacio de juego se define al iniciar, junto con la variante de triunfo.
La variante de triunfo puede ser,
- 'A' solo 4 en línea verticales u horizontales.
- 'B' solo 4 en línea diagonales
- 'C' 4 en línea en cualquier orientación.


Inician el juego las Rojas y alternan los turnos a partir de ahí
  El juego puede terminar por triunfo o por empate. Una vez terminado no se puede seguir colocando fichas

Es requisito cumplir con todos los criterios vistos a lo largo de la cursada.

Se ofrece una pequeña interfaz de línea de comandos para correr por consola:
Debe respetarse el protocolo definido para Linea, el constructor y los mensajes playBlueAt, playRedAt, finished y show.

```
package linea;



public class Game {

public static void main( String[] args) throws Exception {

    System.out.println( "Dimensiones?");

    Linea game = new Linea( prompt( "Base? " ), prompt( "Altura? " ), 'C' );

    

    System.out.println( game.show() );

    

    while ( !game.finished() ) {

      game.playRedkAt( prompt( "Negras? " ) );

      System.out.println( game.show() );

      

      if ( !game.finished() ) {

        game.playBlueAt( prompt( "Blancas? " ) );

        System.out.println( game.show() );

      }

    }



}



private static int prompt( String message ) {

    System.out.print( message );

    return Integer.parseInt( System.console().readLine() );

}

}
 

```

## Notas

- No hay clases para tablero, ficha y jugador
  - Son cosas que nombramos mucho en el juego, pero no tienen que existir como entidades en el código
- Ver que pasa si se llena el tablero y nadie gana (condición de empate)
- Fallar si:
  - Un jugador juega y no es su turno
  - Se ponen mas fichas de las que se puede en una columna
    - Decidir si solo se lanza una excepcion o si se le permite volver a elegir
