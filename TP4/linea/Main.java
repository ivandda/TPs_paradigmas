package linea;

public class Main {

    public static void main(String[] args) {
//        Linea linea1 = new Linea(5, 5, 'A');
//        System.out.println(linea1.show());
//        linea1.playRedkAt(1);
//        linea1.playRedkAt(1);
//        linea1.playRedkAt(1);
//        linea1.playRedkAt(1);
//        linea1.playRedkAt(1);
//        System.out.println(linea1.show());
//        linea1.playBlueAt(1);
//        linea1.playBlueAt(2);
//        linea1.playBlueAt(3);
//        linea1.playBlueAt(4);
//        System.out.println(linea1.show());
//
//
//        System.out.println(linea1.checkHorizontalWin('R'));
//        System.out.println(linea1.checkHorizontalWin('B'));
////        System.out.println(linea1.finished());
//        System.out.println(linea1.checkVerticalWin('R'));
////        System.out.println(linea1.finished());
//        System.out.println(linea1.checkVerticalWin('B'));

        Linea linea1 = new Linea(3, 10, 'A');

        System.out.println(linea1.show());
        linea1.playRedAt(1);
        linea1.playBlueAt(2);
        linea1.playRedAt(1);
        linea1.playBlueAt(2);
        linea1.playRedAt(3);
        linea1.playBlueAt(2);
        linea1.playRedAt(3);
        linea1.playBlueAt(2);
        linea1.playRedAt(1);
//        linea1.playBlueAt(2);
//        linea1.playRedkAt(1);
//        linea1.playRedkAt(1);

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

