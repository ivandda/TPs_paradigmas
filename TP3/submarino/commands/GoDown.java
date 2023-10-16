package submarino.commands;

import submarino.Position;
import submarino.States.*;

public class GoDown extends Command {
    @Override
    public State executeMeAsSurface(Surface surface) {
        return new OneSubmerged(new Position(surface.position.getX(), surface.position.getY(), surface.position.getZ() - 1), surface);
    }

    @Override
    public State executeMeAsOneSubmerged(OneSubmerged oneSubmerged) {
        return null;
    }

    @Override
    public State ExecuteMeAsFullySubmerged(FullySubmerged fullySubmerged) {
        return null;
    }

    @Override
    public State ExecuteMeAsDestroyed(Destroyed destroyed) {
        return null;
    }
}
