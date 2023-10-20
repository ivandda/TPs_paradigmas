package submarino.States;

import submarino.Position;
import submarino.commands.Command;

public abstract class State {
//    private Position position;
//    private State previousLinkedState;

    public Position position;
    public State previousLinkedState;
    public State(Position position, State previousLinkedStates) {
        this.position = position;
        this.previousLinkedState = previousLinkedStates;
    }

    public abstract State executeCommand(Command command);

    public Position getPosition() {return position;}

    public State getPreviousLinkedState() {return previousLinkedState;}
}
