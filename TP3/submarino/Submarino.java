package submarino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Submarino {
    public int posZ = 0;
    public int posX = 0;
    public int posY = 0;
//    public List<Integer> posXY = Arrays.asList(0,0);
    public String cardinal = "NORTE";
    public Submarino() {
    }

    public void go(String indicaciones){
        if (indicaciones == ""){
            return;
        }
        if (indicaciones == "d"){
            this.posZ -= 1;
            return;
        }

        if (indicaciones == "u" && this.posZ == 0){
            return;
        }

        if (indicaciones == "u" && this.posZ != 0){
            this.posZ += 1;
            return;
        }

        if(indicaciones == "f" && this.cardinal == "NORTE"){
            this.posX += 1;
            return;
        }

        if(indicaciones == "f" && this.cardinal == "SUR"){
            this.posX -= 1;
            return;
        }

        if(indicaciones == "f" && this.cardinal == "ESTE"){
            this.posY += 1;
            return;
        }

        if (indicaciones == "f" && this.cardinal == "OESTE"){
            this.posY -= 1;
            return;
        }

        if (indicaciones == "r" && cardinal == "NORTE"){
            this.cardinal = "ESTE";
        }
        if (indicaciones == "r" && cardinal == "ESTE"){
            this.cardinal = "SUR";
        }
        if (indicaciones == "r" && cardinal == "SUR"){
            this.cardinal = "OESTE";
        }
        if (indicaciones == "r" && cardinal == "OESTE"){
            this.cardinal = "NORTE";
        }

        if (indicaciones == "l" && cardinal == "NORTE"){
            this.cardinal = "OESTE";
        }
        if (indicaciones == "l" && cardinal == "OESTE"){
            this.cardinal = "SUR";
        }
        if(indicaciones == "l" && cardinal == "SUR"){
            this.cardinal = "ESTE";
        }
        if(indicaciones == "l" && cardinal == "ESTE"){
            this.cardinal = "NORTE";
        }
        return;
    }

}
