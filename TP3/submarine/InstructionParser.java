package submarine;

import submarine.commands.*;

import java.util.ArrayList;

import static java.lang.Character.toLowerCase;

public class InstructionParser {
    private static ArrayList<Command> commands = new ArrayList<>(
            java.util.Arrays.asList(
                    new GoDown(),
                    new GoUp(),
                    new TurnLeft(),
                    new TurnRight(),
                    new GoForward(),
                    new ReleaseCapsule()
            )
    );


    public ArrayList<Command> getCommands(String instructions) {
        ArrayList<Command> validatedCommands = new ArrayList<>();

        instructions.chars()
                .mapToObj(currentInstruction -> (char) currentInstruction)
                .forEach(currentInstruction -> {
                    commands.stream()
                            .filter(command -> command.applies(toLowerCase(currentInstruction)))
                            .findFirst()
                            .ifPresent(validatedCommands::add);
                });

        return validatedCommands;
    }

}
