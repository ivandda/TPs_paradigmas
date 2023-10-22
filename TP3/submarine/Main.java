package submarine;

public class Main {
    public static void main(String[] args) {
        Nemo nemo = new Nemo();
        nemo.executeInstructions("");
        System.out.println(nemo.getAllCoordsAndOrientation());
    }
}
