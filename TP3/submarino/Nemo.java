package submarino;

import submarino.States.State;
import submarino.States.Surface;
import submarino.commands.Command;
import submarino.instructionsInterpreter.InstructionsInterpreter;

import java.util.ArrayList;

public class Nemo {
    private State state;

    public Nemo(Position inputPosition) {
        state = new Surface(inputPosition, null);
        state.position = inputPosition;
    }

    public Nemo executeCommands(String instructions) {
        ArrayList<Command> commands = receiveAndValidateInstructions(instructions);
        commands.forEach(command -> state = state.executeCommand(command));
        return this;
    }

    private ArrayList<Command> receiveAndValidateInstructions(String instructions) {
        return (new InstructionsInterpreter(instructions).getValidatedCommands());
    }

}
