package submarine;

public class Main {
    public static void main(String[] args) {
        Nemo nemo = new Nemo();
        nemo.instructionsManager.executeInstructions("@f@r@f@r@f@r@dddduuummmmummm", nemo);
        System.out.println(nemo.xyPositionManager.getX());
        System.out.println(nemo.xyPositionManager.getY());
        System.out.println(nemo.orientationManager.getOrientationName());
        System.out.println(nemo.depthManager.getZ());

        Nemo nemo2 = new Nemo(99,99,"EAST");
        nemo.instructionsManager.executeInstructions("ddu@@@@@uduffmmmMMMMMDUMRRFF", nemo);
        System.out.println(nemo.xyPositionManager.getX());
        System.out.println(nemo.xyPositionManager.getY());
        System.out.println(nemo.orientationManager.getOrientationName());
        System.out.println(nemo.depthManager.getZ());
    }
}
