package submarino.commands;

import org.junit.jupiter.api.Test;
import submarino.InstructionsInterpreter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsInterpreterTests {

    public InstructionsInterpreter II(String instructions) {
        return new InstructionsInterpreter(instructions);
    }

    @Test
    public void test00OneValidInstructionReturnsOneCommand() {
        assertEquals(II("d").getValidatedCommands().size(), 1);
    }

    @Test
    public void test01MoreThanOneValidInstructionReturnsMoreThanOneCommand() {
        assertEquals(II("dfru").getValidatedCommands().size(), 4);
    }

    @Test
    public void test02DInstructionReturnsGoDownCommand() {
        assertEquals(II("d").getValidatedCommands().get(0).getClass(), GoDown.class);
    }

    @Test
    public void test03UInstructionReturnsGoUpCommand() {
        assertEquals(II("u").getValidatedCommands().get(0).getClass(), GoUp.class);
    }

    @Test
    public void test04FInstructionReturnsGoForwardCommand() {
        assertEquals(II("f").getValidatedCommands().get(0).getClass(), GoForward.class);
    }

    @Test
    public void test05RInstructionReturnsTurnRightCommand() {
        assertEquals(II("r").getValidatedCommands().get(0).getClass(), TurnRight.class);
    }

    @Test
    public void test06LInstructionReturnsTurnLeftCommand() {
        assertEquals(II("l").getValidatedCommands().get(0).getClass(), TurnLeft.class);
    }


    @Test
    public void test07IICanValidateMultipleInstructions() {
        assertEquals(II("dfru").getValidatedCommands().size(), 4);
    }

    @Test
    public void test08IICanValidateMultipleInstructionsCorrectly() {
        assertEquals(II("dufrlm").getValidatedCommands().get(0).getClass(), GoDown.class);
        assertEquals(II("dufrlm").getValidatedCommands().get(1).getClass(), GoUp.class);
        assertEquals(II("dufrlm").getValidatedCommands().get(2).getClass(), GoForward.class);
        assertEquals(II("dufrlm").getValidatedCommands().get(3).getClass(), TurnRight.class);
        assertEquals(II("dufrlm").getValidatedCommands().get(4).getClass(), TurnLeft.class);
        assertEquals(II("dufrlm").getValidatedCommands().get(5).getClass(), ReleaseCapsule.class);
    }

    @Test
    public void test09IICanValidateMultipleInstructionsCorrectly() {
        assertEquals(II("dfru").getValidatedCommands().get(0).getClass(), GoDown.class);
        assertEquals(II("dfru").getValidatedCommands().get(1).getClass(), GoForward.class);
        assertEquals(II("dfru").getValidatedCommands().get(2).getClass(), TurnRight.class);
        assertEquals(II("dfru").getValidatedCommands().get(3).getClass(), GoUp.class);
    }

    @Test
    public void test10IICanValidateMultipleInstructionsCorrectly() {
        assertEquals(II("lrfud").getValidatedCommands().get(0).getClass(), TurnLeft.class);
        assertEquals(II("lrfud").getValidatedCommands().get(1).getClass(), TurnRight.class);
        assertEquals(II("lrfud").getValidatedCommands().get(2).getClass(), GoForward.class);
        assertEquals(II("lrfud").getValidatedCommands().get(3).getClass(), GoUp.class);
        assertEquals(II("lrfud").getValidatedCommands().get(4).getClass(), GoDown.class);


    }

    @Test
    public void test11IICanValidateMultipleInstructionsCorrectly() {
        assertEquals(II("llrrffuudd").getValidatedCommands().get(0).getClass(), TurnLeft.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(1).getClass(), TurnLeft.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(2).getClass(), TurnRight.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(3).getClass(), TurnRight.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(4).getClass(), GoForward.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(5).getClass(), GoForward.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(6).getClass(), GoUp.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(7).getClass(), GoUp.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(8).getClass(), GoDown.class);
        assertEquals(II("llrrffuudd").getValidatedCommands().get(9).getClass(), GoDown.class);
    }


}
