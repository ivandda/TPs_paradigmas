package submarino.States;

import submarino.Position;
import submarino.commands.Command;

public abstract class State {
    public Position position;
    public State previousLinkedStates;

    public State(Position position, State previousLinkedStates) {
        this.position = position;
        this.previousLinkedStates = previousLinkedStates;
    }

    public abstract State executeCommand(Command command);
}
