package submarine.orientation;

import submarine.XYPositionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class OrientationManager {
    String orientationName;
    private static ArrayList<OrientationManager> orientationManagers = new ArrayList<>(
            Arrays.asList(
                    new NorthOrientationManager(),
                    new SouthOrientationManager(),
                    new EastOrientationManager(),
                    new WestOrientationManager()
            ));

    public boolean applies(String identifier) {
        return Objects.equals(orientationName, identifier);
    }

    public abstract XYPositionManager moveForwardAsOrientation(XYPositionManager xyPositionManager);

    public abstract OrientationManager turnRightAsOrientation(OrientationManager orientationManager);

    public abstract OrientationManager turnLeftAsOrientation(OrientationManager orientationManager);

    public OrientationManager getOrientationManagerByName(String orientationName) {
        return orientationManagers.stream()
                .filter(orientationManager -> orientationManager.applies(orientationName.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid orientation name"));
    }
    public String getOrientationName() {return this.orientationName;}
}
