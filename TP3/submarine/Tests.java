package submarine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import submarine.depth.DeepLevel;
import submarine.depth.DepthManager;
import submarine.depth.FirstLevelSubmerged;
import submarine.depth.Surface;
import submarine.orientation.EastOrientationManager;
import submarine.orientation.NorthOrientationManager;
import submarine.orientation.OrientationManager;
import submarine.orientation.WestOrientationManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static submarine.depth.DeepLevel.release_capsule_error;
import static submarine.depth.Surface.cannot_go_up_from_surface_level_error;

public class Tests {
    private Submarine nemo;
    private OrientationManager east;
    private OrientationManager west;
    private OrientationManager north;
    private OrientationManager south;
    private DepthManager surface;
    private DepthManager firstLevelSubmerged;
    private DepthManager deepLevel;

    private Submarine newNemo() {
        return new Submarine();
    }

    private Submarine newNemoWith(OrientationManager orientationManager, int xCoord, int yCoord, DepthManager depthManager) {
        return new Submarine(orientationManager, new XYPositionManager(xCoord, yCoord), depthManager);
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message,
                assertThrows(Exception.class, executable)
                        .getMessage());
    }

    @BeforeEach
    public void setUp() {
        nemo = newNemo();
        east = new EastOrientationManager();
        west = new WestOrientationManager();
        north = new NorthOrientationManager();
        south = new NorthOrientationManager();
        surface = new Surface();
        firstLevelSubmerged = new FirstLevelSubmerged();
        deepLevel = new DeepLevel();
    }


    @Test
    public void NemoStartsInDesiredPosWithDefaultConstructor() {
        assertEquals("Orientation: north X: 0 Y: 0 Z: 0", newNemo().getAllCoordsAndOrientation());
    }

    @Test
    public void NemoStartsInDesiredPosWithCustomConstructor() {
        assertEquals("Orientation: north X: 0 Y: 0 Z: 0", newNemoWith(north, 0, 0, surface).getAllCoordsAndOrientation());
    }

    @Test
    public void NemoStartsInDesiredPosWithCustomConstructor2() {
        assertEquals("Orientation: east X: 3 Y: 5 Z: 0", newNemoWith(east, 3, 5, surface).getAllCoordsAndOrientation());
    }

    @Test
    public void NemoPositionDoesNotChangeWhenReceivingEmptyInstructions() {
        nemo.executeInstructions("");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }


    @Test
    public void NemoGoesForwardWhenReceivingGoForwardInstruction() {
        nemo.executeInstructions("f");
        assertEquals("Orientation: north X: 1 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    public void NemoTurnsLeftWhenReceivingTurnLeftInstruction() {
        nemo.executeInstructions("l");
        assertEquals("Orientation: west X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    public void NemoTurnsRightWhenReceivingTurnRightInstruction() {
        nemo.executeInstructions("r");
        assertEquals("Orientation: east X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    public void NemoGoesDownWhenReceivingGoDownInstruction() {
        nemo.executeInstructions("d");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 1", nemo.getAllCoordsAndOrientation());
    }

    @Test
    public void NemoGoesUpWhenReceivingGoUpInstruction() {
        newNemoWith(north, 0, 0, firstLevelSubmerged)
                .executeInstructions("u");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    void NemoGoesForwardManyTimesWhenReceivingManyGoForwardInstructions() {
        nemo.executeInstructions("fff");
        assertEquals("Orientation: north X: 3 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    void NemoTurnsLeftManyTimesWhenReceivingManyTurnLeftInstructions() {
        nemo.executeInstructions("ll");
        assertEquals("Orientation: south X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    void NemoTurnsRightManyTimesWhenReceivingManyTurnRightInstructions() {
        nemo.executeInstructions("rr");
        assertEquals("Orientation: south X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    void NemogoesDownManyTimesWhenReceivingManyGoDownInstructions() {
        nemo.executeInstructions("ddddddd");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 7", nemo.getAllCoordsAndOrientation());
    }

    @Test
    void NemoGoesDownAndThenUpWhenReceivingGoDownAndGoUpInstructions() {
        nemo.executeInstructions("dudududdddddu");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 5", nemo.getAllCoordsAndOrientation());
    }

    @Test
    void NemoReturnsToSurfaceCorrectlyWhenReceivingGoDownAndGoUpInstructions() {
        nemo.executeInstructions("ddduduuu");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    void exceptionWhenNemoGoesUpOnSurface() {
        assertThrowsLike(() -> nemo.executeInstructions("u"), cannot_go_up_from_surface_level_error);
    }

    @Test
    public void noEffectWhenReceivingReleaseCapsuleInstructionInACorrectPositionSurface() {
        nemo.executeInstructions("m");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    public void noEffectWhenReceivingReleaseCapsuleInstructionInACorrectPositionFirstLevelSubmerged() {
        nemo.executeInstructions("dm");
    }

    @Test
    public void noEffectWhenReceivingReleaseCapsuleInstructionInACorrectPositionAscendingIncorrectPosition() {
        nemo.executeInstructions("ddddddduuuuuum");
    }

    @Test
    public void ExeptionWhenReceivingReleaseCapsuleInstructionInAnIncorrectPosition() {
        nemo.executeInstructions("dd");
        assertThrowsLike(() -> nemo.executeInstructions("m"), release_capsule_error);
    }

    @Test
    public void canReleaseManyCapsulesInDifferentMomentsAfterOtherCommands() {
        nemo.executeInstructions("mmmdmmmflrum");
    }

    @Test
    public void NemoCanRecognizeCapitalizedInstructions() {
        nemo.executeInstructions("DUDUDUMRRRR");
        assertEquals("Orientation: north X: 0 Y: 0 Z: 0", nemo.getAllCoordsAndOrientation());
    }

    @Test
    public void NemoCanFilterNotValidInstructions() {
        nemo.executeInstructions("1d@u#fZr!f*d&m|   (ㆆ _ ㆆ)    |");
        assertEquals("Orientation: east X: 1 Y: 1 Z: 1", nemo.getAllCoordsAndOrientation());
    }

}
