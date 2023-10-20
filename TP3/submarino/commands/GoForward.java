package submarino.commands;

import submarino.Position;
import submarino.States.*;

public class GoForward extends Command {
    @Override
    public State executeMeAsSurface(Surface surface) {
        return new StateBuilder().setPreviousLinkedState(surface)
                                 .setPosition(surface.getPosition().getX() + 1,
                                              surface.getPosition().getY(),
                                              surface.getPosition().getZ())
                                 .buildAsSurface();
    }

    @Override
    public State executeMeAsOneSubmerged(OneSubmerged oneSubmerged) {
        return new StateBuilder().setPreviousLinkedState(oneSubmerged)
                                 .setPosition(oneSubmerged.getPosition().getX() + 1,
                                              oneSubmerged.getPosition().getY(),
                                              oneSubmerged.getPosition().getZ())
                                 .buildAsOneSubmerged();

    }

    @Override
    public State ExecuteMeAsFullySubmerged(FullySubmerged fullySubmerged) {
        return new StateBuilder().setPreviousLinkedState(fullySubmerged)
                                 .setPosition(fullySubmerged.getPosition().getX() + 1,
                                              fullySubmerged.getPosition().getY(),
                                              fullySubmerged.getPosition().getZ())
                                 .buildAsFullySubmerged();
    }

    @Override
    public State ExecuteMeAsDestroyed(Destroyed destroyed) {
        throw new RuntimeException("Cannot execute command on a destroyed submarine");
    }
}
