//package submarino3;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import submarino3.commands.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class InstructionsInterpreterTests {
//
//    public InstructionsManager II() {
//        return new InstructionsManager();
//    }
//
//    @Test
//    public void test00OneValidInstructionReturnsOneCommand() {
//        assertEquals(II().getCommands("f").size(), 1);
//    }
//
//    @Test
//    public void test01MoreThanOneValidInstructionReturnsMoreThanOneCommand() {
//        assertEquals(II().getCommands("ffff").size(), 4);
//    }
//
//    @Test
//    public void test02MoreThanOneValidInstructionReturnsMoreThanOneCommand() {
//        assertEquals(II().getCommands("@f@f@f@f@").size(), 4);
//    }
//
//    @Test
//    public void test() {
//        ArrayList<Command> commands = new ArrayList<>(Arrays.asList(new GoDown()));
//        System.out.println(II().getCommands("@f@l@r@u@d@m"));
////        System.out.println(new ArrayList<>().add(GoDown.class));
////        System.out.println(GoDown.class);
////        assertEquals(II().getCommands("d"), GoDown.class);
//    }
//
//    @Test
//    public void test02DInstructionReturnsGoDownCommand() {
//        ArrayList<Command> commands = new ArrayList<>(Arrays.asList(new GoDown()));
////        System.out.println(II().getCommands("d"));
////        System.out.println(new ArrayList<>().add(GoDown.class));
////        System.out.println(GoDown.class);
//        assertEquals(II().getCommands("d"), GoDown.class);
//    }
//
//    @Test
//    public void test03UInstructionReturnsGoUpCommand() {
//        assertEquals(II().getCommands("u"), GoUp.class);
//    }
//
//    @Test
//    public void test04FInstructionReturnsGoForwardCommand() {
//        assertEquals(II().getCommands("f"), GoForward.class);
//    }
//
//    @Test
//    public void test05RInstructionReturnsTurnRightCommand() {
//        assertEquals(II().getCommands("r"), TurnRight.class);
//    }
//
//    @Test
//    public void test06LInstructionReturnsTurnLeftCommand() {
//        assertEquals(II().getCommands("l"), TurnLeft.class);
//    }
////
////
////    @Test
////    public void test07IICanValidateMultipleInstructions() {
////        assertEquals(II("dfru").getValidatedCommands().size(), 4);
////    }
////
////    @Test
////    public void test08IICanValidateMultipleInstructionsCorrectly() {
////        assertEquals(II("dufrlm").getCommands(), GoDown.class);
////        assertEquals(II("dufrlm").getValidatedCommands().get(1).getClass(), GoUp.class);
////        assertEquals(II("dufrlm").getValidatedCommands().get(2).getClass(), GoForward.class);
////        assertEquals(II("dufrlm").getValidatedCommands().get(3).getClass(), TurnRight.class);
////        assertEquals(II("dufrlm").getValidatedCommands().get(4).getClass(), TurnLeft.class);
////        assertEquals(II("dufrlm").getValidatedCommands().get(5).getClass(), ReleaseCapsule.class);
////    }
////
////    @Test
////    public void test09IICanValidateMultipleInstructionsCorrectly() {
////        assertEquals(II("dfru").getCommands(), GoDown.class);
////        assertEquals(II("dfru").getValidatedCommands().get(1).getClass(), GoForward.class);
////        assertEquals(II("dfru").getValidatedCommands().get(2).getClass(), TurnRight.class);
////        assertEquals(II("dfru").getValidatedCommands().get(3).getClass(), GoUp.class);
////    }
////
////    @Test
////    public void test10IICanValidateMultipleInstructionsCorrectly() {
////        assertEquals(II("lrfud").getCommands(), TurnLeft.class);
////        assertEquals(II("lrfud").getValidatedCommands().get(1).getClass(), TurnRight.class);
////        assertEquals(II("lrfud").getValidatedCommands().get(2).getClass(), GoForward.class);
////        assertEquals(II("lrfud").getValidatedCommands().get(3).getClass(), GoUp.class);
////        assertEquals(II("lrfud").getValidatedCommands().get(4).getClass(), GoDown.class);
////
////
////    }
////
////    @Test
////    public void test11IICanValidateMultipleInstructionsCorrectly() {
////        assertEquals(II("llrrffuudd").getCommands(), TurnLeft.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(1).getClass(), TurnLeft.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(2).getClass(), TurnRight.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(3).getClass(), TurnRight.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(4).getClass(), GoForward.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(5).getClass(), GoForward.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(6).getClass(), GoUp.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(7).getClass(), GoUp.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(8).getClass(), GoDown.class);
////        assertEquals(II("llrrffuudd").getValidatedCommands().get(9).getClass(), GoDown.class);
////    }
////
////
//}
