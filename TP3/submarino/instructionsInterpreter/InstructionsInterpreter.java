package submarino.instructionsInterpreter;

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
        this.inputInstructions = instructions;
    }

    public ArrayList<Command> getValidatedCommands() {
        ArrayList<Command> validatedCommands = new ArrayList<>();
        parseAndValidateInstructions(inputInstructions, validatedCommands);
        return validatedCommands;
    }

    private void parseAndValidateInstructions(String instructions, ArrayList<Command> validatedCommands) {
        instructions.chars()
                .mapToObj(currentInstruction -> (char) currentInstruction)
                .forEach(currentInstruction -> {
                    validators.stream()
                            .filter(validator -> validator.applies(currentInstruction))
                            .findFirst()
                            .ifPresent(validator -> {
                                validatedCommands.add(validator.getCommand());
                            });
                });
    }
}


//    public InstructionsInterpreter(String instructions) {
//        String stringToIndicateNoMoreCommands = "@";
//        this.inputInstructions = instructions + stringToIndicateNoMoreCommands;
//    }

//    private void parseAndValidateInstructions(String instructions, ArrayList<Command> validatedCommands) {
//        char currentCommand = instructions.charAt(0);
//        String nextInstructions = instructions.substring(1);
//
//        validators.stream()
//                .filter(validator -> validator.applies(currentCommand))
//                .findFirst().ifPresent(
//                        validator -> {
//                            validatedCommands.add(validator.getCommand());
//                            parseAndValidateInstructions(nextInstructions, validatedCommands);
//                        });
//    }

