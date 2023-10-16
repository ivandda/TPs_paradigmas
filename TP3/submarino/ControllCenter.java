//package submarino;
//
//import submarino.commands.Command;
//
//import java.util.ArrayList;
//
//public class ControllCenter {
//    private Nemo nemo;
//
//    public ControllCenter(Nemo nemo) {
//        this.nemo = nemo;
//    }
//
//    private ArrayList<Command>  receiveAndValidateInstructions(String instructions){
//        return (new InstructionsInterpreter(instructions).getValidatedCommands());
//    }
//
//    public Nemo executeCommands(String instructions){
//        ArrayList<Command> commands = receiveAndValidateInstructions(instructions);
//        commands.forEach(command -> nemo.executeCommand(command));
//        return nemo;
//    }
//}
