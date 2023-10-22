package submarine;

public class Main {
    public static void main(String[] args) {
        Nemo nemo = new Nemo();
        nemo.executeInstructions("ffffrrffdfffllfulrrdudddduuum");
//        System.out.println(nemo.depthManager.getClass());
        System.out.println(nemo.xyPositionManager.getXCoord());
        System.out.println(nemo.xyPositionManager.getYCoord());
        System.out.println(nemo.orientationManager.getOrientationName());
        System.out.println(nemo.depthManager.getZCoord());

//        Nemo nemo2 = new Nemo(99,99,"EAST");
//        nemo.instructionsManager.executeInstructions("ddu@@@@@uduffmmmMMMMMDUMRRFF", nemo);
//        System.out.println(nemo.xyPositionManager.getX());
//        System.out.println(nemo.xyPositionManager.getY());
//        System.out.println(nemo.orientationManager.getOrientationName());
//        System.out.println(nemo.depthManager.getZ());
    }
}
