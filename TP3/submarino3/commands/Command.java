package submarino3.commands;

import submarino3.Nemo;

public abstract class Command {
    char charIdentifier;

    public boolean applies(char c) {
        return c == charIdentifier;
    }

    public abstract void execute(Nemo nemo);
}

