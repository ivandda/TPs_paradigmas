package submarino;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class submarinoTests {

    @Test
    public void test01TodasLasPosInicialesSonCorrectas() {
//        Esta en la superficie?
//        En que pos esta?
//        Para donde esta mirando?

        Submarino submarino = my_submarino();
        int posX = 0;
        int posY = 0;
        int posZ = 0;
        String correct_direction = "NORTE";

        assertEquals(submarino.posXY, Arrays.asList(posX, posY));
        assertEquals(submarino.posZ, posZ);
        assertEquals(submarino.cardinal, correct_direction);
    }

    @Test
    public void test01PermaneceEnLugarSiNoHayIndicaciones() {
        Submarino submarino = my_submarino();

        int posX = 0;
        int posY = 0;
        int posZ = 0;
        String correct_direction = "NORTE";

        submarino.go("");
        assertEquals(submarino.posXY, Arrays.asList(posX, posY));
        assertEquals(submarino.posZ, posZ);
        assertEquals(submarino.cardinal, correct_direction);

    }


    private Submarino my_submarino() {
        return new Submarino();
    }

}