package submarino.States;

import submarino.Position;
import submarino.commands.Command;

public class FullySubmerged extends State{


    public FullySubmerged(Position position, State previousLinkedStates) {
        super(position, previousLinkedStates);
    }

    @Override
    public State executeCommand(Command command) {
        return command.ExecuteMeAsFullySubmerged(this);
    }
}
