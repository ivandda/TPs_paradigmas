package submarino.commands;

import submarino.States.*;

public abstract class Command {
    public abstract State ExecuteMeAsDestroyed(Destroyed destroyed);

    public abstract State executeMeAsOneSubmerged(OneSubmerged oneSubmerged);

    public abstract State executeMeAsSurface(Surface surface);

    public abstract State ExecuteMeAsFullySubmerged(FullySubmerged fullySubmerged);
}