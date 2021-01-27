import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestoreEspertoTest {

    private Esperto esperto;
    private Esperto esperto2;
    private static GestoreEsperto instance;

    @BeforeEach
    void createGestoreEspertoTest(){
        instance = null;
        instance = GestoreEsperto.getInstance();
        esperto = new Esperto("Paola","Guidotti");
        esperto2 = new Esperto("Davide","Lorenzo");
    }
    @Test
    public void getSingleEspertoTest(){
        instance.getInstance().addEsperto(esperto);
        //assertTrue(instance.getSingleSponsor(sponsor.getID()).equals(sponsor));
    }
    @Test
    public void getEspertiTest(){
        instance.getInstance().addEsperto(esperto);
        instance.getInstance().addEsperto(esperto2);
        assertTrue(instance.getEsperti().contains(esperto));
        assertTrue(instance.getEsperti().contains(esperto2));
    }
    @Test
    public void addEspertoTest(){
        instance.getInstance().addEsperto(esperto);
        assertTrue(instance.getEsperti().contains(esperto));
        assertFalse(instance.getEsperti().contains(esperto2));
        instance.getInstance().addEsperto(esperto2);
        assertTrue(instance.getEsperti().contains(esperto2));

    }

    @Test
    public void removeEspertoTest(){
        assertFalse(instance.getEsperti().contains(esperto2));
        instance.getInstance().addEsperto(esperto2);
        assertTrue(instance.getEsperti().contains(esperto2));
        instance.getInstance().removeEsperto(esperto2);
        assertFalse(instance.getEsperti().contains(esperto2));
    }

}
