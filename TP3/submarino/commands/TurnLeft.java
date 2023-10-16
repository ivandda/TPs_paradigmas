package submarino.commands;

import submarino.Position;
import submarino.States.*;

public class TurnLeft extends Command{


    @Override
    public State ExecuteMeAsDestroyed(Destroyed destroyed) {
        return null;
    }

    @Override
    public State executeMeAsOneSubmerged(OneSubmerged oneSubmerged) {
        return null;
    }

    @Override
    public State executeMeAsSurface(Surface surface) {
        return null;
    }

    @Override
    public State ExecuteMeAsFullySubmerged(FullySubmerged fullySubmerged) {
        return null;
    }
}
