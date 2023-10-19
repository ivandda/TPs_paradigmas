package submarino3;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World!");

        Nemo nemo = new Nemo();
        nemo.instructionsManager.executeInstructions("@f@r@f@r@f@r@f@", nemo);
        System.out.println(nemo.xyPositionManager.getX());
        System.out.println(nemo.xyPositionManager.getY());
        System.out.println(nemo.orientationManager.getOrientationName());

    }
}
