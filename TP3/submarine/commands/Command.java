package submarine.commands;

import submarine.Nemo;

public abstract class Command {
    char identifier;

    public boolean applies(char charToValidate) {
        return charToValidate == identifier;
    }

    public abstract void execute(Nemo nemo);
}
