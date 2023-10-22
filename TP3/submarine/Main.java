package submarine;

public class Main {
    public static void main(String[] args) {
        Submarine submarine = new Submarine();
        submarine.executeInstructions("");
        System.out.println(submarine.getAllCoordsAndOrientation());
    }
}
