package linea;

public class Main {

    public static void main(String[] args) {

        Linea linea1 = new Linea(20, 20, 'b');

        System.out.println(linea1.show());
        linea1.playRedAt(1);
        System.out.println(linea1.show());
        linea1.playBlueAt(1);
        System.out.println(linea1.show());
        linea1.playRedAt(2);
        System.out.println(linea1.show());
        linea1.playBlueAt(2);
//        System.out.println((linea1.gameState.getClass()));
//        linea1.playRedAt(3);
//        linea1.playBlueAt(2);
//        linea1.playRedAt(3);
//        linea1.playBlueAt(2);
//        linea1.playRedAt(1);
//        linea1.playBlueAt(2);
//        linea1.playRedAt(1);
//        linea1.playRedAt(1);

//        linea1.playBlueAt(0);



        System.out.println(linea1.show());

//        System.out.println(linea1.checkHorizontalWin('R'));
//        System.out.println(linea1.checkHorizontalWin('B'));
////        System.out.println(linea1.finished());
//        System.out.println(linea1.checkVerticalWin('R'));
////        System.out.println(linea1.finished());
//        System.out.println(linea1.checkVerticalWin('B'));


    }
}

