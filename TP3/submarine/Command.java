package submarine;

public abstract class Command {
    private char identifier;

    public Command(char identifier) {
        this.identifier = identifier;
    }


    public boolean applies(char charToValidate) {return charToValidate == identifier;}

    public abstract void execute(Submarine submarine);
}

