package submarino;

import submarino.commands.*;

import java.util.ArrayList;
import java.util.Arrays;

public class InstructionsInterpreter {

    private String inputInstructions;
    private ArrayList<Validator> validators = new ArrayList<>(
            Arrays.asList(
                    new Validator('d', new GoDown()),
                    new Validator('u', new GoUp()),
                    new Validator('f', new GoForward()),
                    new Validator('r', new TurnRight()),
                    new Validator('l', new TurnLeft()),
                    new Validator('m', new ReleaseCapsule())
            )
    );

    public InstructionsInterpreter(String instructions) {
        String stringToIndicateNoMoreCommands = "@";
        this.inputInstructions = instructions + stringToIndicateNoMoreCommands;
    }

    public ArrayList<Command> getValidatedCommands() {
        ArrayList<Command> validatedCommands = new ArrayList<>();
        parseAndValidateInstructions(inputInstructions, validatedCommands);
        return validatedCommands;
    }

    private void parseAndValidateInstructions(String instructions, ArrayList<Command> validatedCommands) {
        char currentCommand = instructions.charAt(0);
        String nextInstructions = instructions.substring(1);

        validators.stream()
                .filter(validator -> validator.applies(currentCommand))
                .findFirst().ifPresent(
                        validator -> {
                            validatedCommands.add(validator.getCommand());
                            parseAndValidateInstructions(nextInstructions, validatedCommands);
                        });
    }
}


////        validators.stream()
////                .filter(validator -> validator.applies(currentCommand))
////                .findFirst().ifPresentOrElse(
////                        validator -> {
////                            validatedCommands.add(validator.getCommand());
////                            parseAndValidateInstructions(nextInstructions, validatedCommands);
////                        },
////                        () -> validatedCommands.add(new FlagNoMoreCommands()));
//    }
//
////    private void parseAndValidateInstructions(char[] instructions, ArrayList<Command> validatedCommands) {
////        char currentCommand = instructions[0];
////        char nextInstructions[] = Arrays.copyOfRange(instructions, 1, instructions.length);
////        validators.stream()
////                .filter(validator -> validator.applies(currentCommand))
////                .findFirst().ifPresent(
////                        validator -> {
////                            validatedCommands.add(validator.getCommand());
////                            parseAndValidateInstructions(nextInstructions, validatedCommands);
////                        });
////
//////        validators.stream()
//////                .filter(validator -> validator.applies(currentCommand))
//////                .findFirst().ifPresentOrElse(
//////                        validator -> {
//////                            validatedCommands.add(validator.getCommand());
//////                            parseAndValidateInstructions(nextInstructions, validatedCommands);
//////                        },
//////                        () -> validatedCommands.add(new FlagNoMoreCommands()));
////    }
////
////
////}
//
//
//
//
//}
