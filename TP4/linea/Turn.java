package linea;

public abstract class Turn {
    private char charIdentifier;
    public abstract void playAsRedAt(int position);
    public abstract void playAsBlueAt(int position);
}
