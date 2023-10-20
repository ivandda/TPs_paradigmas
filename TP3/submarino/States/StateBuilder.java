package submarino.States;

import submarino.Position;

public class StateBuilder {
    private State previousLinkedState;
    private Position position;


    public StateBuilder setPreviousLinkedState(State state) {
        this.previousLinkedState = state;
        return this;
    }

    public StateBuilder setPosition(int Xcoord, int Ycoord, int Zcoord) {
        this.position = new Position(Xcoord, Ycoord, Zcoord);
        return this;
    }

    public State buildAsSurface() {
        return new Surface(position, previousLinkedState);
    }

    public State buildAsOneSubmerged() {
        return new OneSubmerged(position, previousLinkedState);
    }

    public State buildAsFullySubmerged() {
        return new FullySubmerged(position, previousLinkedState);
    }

    public State buildAsDestroyed() {
        return new Destroyed(position, previousLinkedState);
    }
}
