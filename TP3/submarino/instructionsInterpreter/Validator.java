package submarino.instructionsInterpreter;

import submarino.commands.Command;

public class Validator {
    private char charToValidate;
    private Command commandForThisChar;

    public Validator(char charToValidate, Command commandForThisChar) {
        this.charToValidate = charToValidate;
        this.commandForThisChar = commandForThisChar;
    }

    public boolean applies(char desiredCommand) {
        return (charToValidate == desiredCommand);
    }

    public Command getCommand() {
        return commandForThisChar;
    }
}


//Esto tiene que estar en command, NO en una clase aparte