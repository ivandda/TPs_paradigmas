package submarino.States;

import submarino.Position;
import submarino.commands.Command;

public class OneSubmerged extends State {
    public OneSubmerged(Position position, State previousLinkedStates) {
        super(position, previousLinkedStates);
    }

    @Override
    public State executeCommand(Command command) {
        return command.executeMeAsOneSubmerged(this);
    }
}
