package submarino;

import java.util.ArrayList;
import java.util.Vector;

public class Position {
    public ArrayList<Integer> coordinate = new ArrayList<Integer>();

    public Position() {
        coordinate.add(0);
        coordinate.add(0);
        coordinate.add(0);
    }
    
    public Position(int xCoordinate, int yCoordinate, int zCoordinate){
        coordinate.set(0, xCoordinate);
        coordinate.set(1, yCoordinate);
        coordinate.set(2, zCoordinate);
    }

    public int getX(){
        return coordinate.get(0);
    }

    public int getY(){
        return coordinate.get(1);
    }

    public int getZ(){
        return coordinate.get(2);
    }
}