package submarino;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class submarinoTests {

    @Test
    public void test00TodasLasPosInicialesYCardinalSonCorrectas() {
//        Esta en la superficie?
//        En que pos esta?
//        Para donde esta mirando?

        Submarino submarino = my_submarino();
        int posX = 0;
        int posY = 0;
        int posZ = 0;
        String correct_direction = "NORTE";

//        assertEquals(submarino.posXY, Arrays.asList(posX, posY));
        assertEquals(submarino.posX, posX);
        assertEquals(submarino.posY, posY);
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
//        assertEquals(submarino.posXY, Arrays.asList(posX, posY));
        assertEquals(submarino.posX, posX);
        assertEquals(submarino.posY, posY);
        assertEquals(submarino.posZ, posZ);
        assertEquals(submarino.cardinal, correct_direction);

    }

    @Test
    public void test02DeciendeUnaUnidad() {
        Submarino submarino = my_submarino();

        int posX = 0;
        int posY = 0;
        int posZ = 0;
        String correct_direction = "NORTE";

        submarino.go("d");
        assertEquals(submarino.posX, posX);
        assertEquals(submarino.posY, posY);
        assertEquals(submarino.posZ, -1);
        assertEquals(submarino.cardinal, correct_direction);


    }

    @Test
    public void test03NoCambiaSiHaciendeAlPrincipio() {
        Submarino submarino = my_submarino();

        int posX = 0;
        int posY = 0;
        int posZ = 0;
        String correct_direction = "NORTE";

        submarino.go("u");
        assertEquals(submarino.posX, posX);
        assertEquals(submarino.posY, posY);
        assertEquals(submarino.posZ, posZ);
        assertEquals(submarino.cardinal, correct_direction);

    }

    @Test
    public void test04AsciendeUnaUnidadLuegoDeDescenderUnaUnidad() {
        Submarino submarino = my_submarino();

        int posX = 0;
        int posY = 0;
        int posZ = 0;
        String correct_direction = "NORTE";

        submarino.go("d");
        submarino.go("u");
        assertEquals(submarino.posX, posX);
        assertEquals(submarino.posY, posY);
        assertEquals(submarino.posZ, posZ);
        assertEquals(submarino.cardinal, correct_direction);

    }

    @Test
    public void test05ForwardAlPrincipioMueveUnaPosEnX(){
        Submarino submarino = my_submarino();

        int posX = 1;
        int posY = 0;
        int posZ = 0;
        String correct_direction = "NORTE";

        submarino.go("f");
        assertEquals(submarino.posX, posX);
        assertEquals(submarino.posY, posY);
        assertEquals(submarino.posZ, posZ);
        assertEquals(submarino.cardinal, correct_direction);
    }





    private Submarino my_submarino() {
        return new Submarino();
    }

}