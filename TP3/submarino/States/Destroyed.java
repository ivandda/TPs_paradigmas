package submarino.States;

import submarino.Position;
import submarino.commands.Command;

public class Destroyed extends State{


    public Destroyed(Position position, State previousLinkedStates) {
        super(position, previousLinkedStates);
    }

    @Override
    public State executeCommand(Command command) {
        return command.ExecuteMeAsDestroyed(this);
    }
}
