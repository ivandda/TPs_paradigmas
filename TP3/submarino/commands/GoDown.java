package submarino.commands;

import submarino.States.*;

import javax.management.RuntimeErrorException;

public class GoDown extends Command {
    @Override
    public State executeMeAsSurface(Surface surface) {
        return new StateBuilder()
                .setPreviousLinkedState(surface)
                .setPosition(surface.getPosition().getX(),
                            surface.getPosition().getY(),
                            surface.getPosition().getZ() - 1)
                .buildAsOneSubmerged();
    }

    @Override
    public State executeMeAsOneSubmerged(OneSubmerged oneSubmerged) {
        return new StateBuilder()
                .setPreviousLinkedState(oneSubmerged)
                .setPosition(oneSubmerged.getPosition().getX(),
                            oneSubmerged.getPosition().getY(),
                            oneSubmerged.getPosition().getZ() - 1)
                .buildAsFullySubmerged();
    }

    @Override
    public State ExecuteMeAsFullySubmerged(FullySubmerged fullySubmerged) {
        return new StateBuilder()
                .setPreviousLinkedState(fullySubmerged)
                .setPosition(fullySubmerged.getPosition().getX(),
                            fullySubmerged.getPosition().getY(),
                            fullySubmerged.getPosition().getZ() - 1)
                .buildAsFullySubmerged();
    }

    @Override
    public State ExecuteMeAsDestroyed(Destroyed destroyed) {
//        return new StateBuilder()
//                .setPreviousLinkedState(destroyed)
//                .setPosition(destroyed.getPosition().getX(),
//                            destroyed.getPosition().getY(),
//                            destroyed.getPosition().getZ())
//                .buildAsDestroyed();
        throw new RuntimeException("Cannot execute command on a destroyed submarine");
    }
}
