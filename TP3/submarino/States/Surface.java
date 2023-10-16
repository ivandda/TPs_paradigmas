package submarino.States;

import submarino.Position;
import submarino.commands.Command;

public class Surface extends State{

    public Surface(Position position, State previousLinkedStates) {
        super(position, previousLinkedStates);
    }

    @Override
    public State executeCommand(Command command) {
        return command.executeMeAsSurface(this);
    }

}
