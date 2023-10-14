package submarino;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args){

        String instructions = "";
        InstructionsInterpreter instructionsInterpreter = new InstructionsInterpreter(instructions);
        System.out.println(instructionsInterpreter.getValidatedCommands());
        System.out.println(instructionsInterpreter.getValidatedCommands().size());

    }
}
