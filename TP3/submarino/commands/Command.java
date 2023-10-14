package submarino.commands;

import submarino.Position;

public abstract class Command {
    public abstract Position execute(Position position);
}