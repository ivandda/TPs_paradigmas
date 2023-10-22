package submarine.commands;

import submarine.Submarine;

public abstract class Command {
    char identifier;

    public boolean applies(char charToValidate) {return charToValidate == identifier;}

    public abstract void execute(Submarine submarine);
}

