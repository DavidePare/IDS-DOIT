import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EspertoTest {

    private Esperto esperto;
    private Esperto esperto2;
    private Progetto progetto;
    private Progetto progetto2;

    @BeforeEach
    void createEsperto(){
       esperto = new Esperto("Paola","Guidotti");
       esperto2 = new Esperto("Davide","Lorenzo");
       progetto = new Progetto(3,"Vaccino COVID-19",50);
       progetto2 = new Progetto(2,"Clistere",5);
    }

    @Test
    void getNameTest(){
        assertEquals(esperto.getName(),"Paola");
        assertEquals(esperto2.getName(),"Davide");
        assertNotEquals(esperto.getName(),"Lorenzo");
        assertNotEquals(esperto2.getName(),"Paola");
    }
    @Test
    void getSurnameTest(){
        assertEquals(esperto.getSurname(),"Guidotti");
        assertEquals(esperto2.getSurname(),"Lorenzo");
        assertNotEquals(esperto.getSurname(),"Paola");
        assertNotEquals(esperto2.getSurname(),"Davide");
    }

    @Test
    void confirmProgettoTest(){
        esperto.confirmProgetto(progetto);
        esperto.confirmProgetto(progetto2);
        assertTrue(progetto.getState() instanceof Approved);
        assertTrue(progetto2.getState() instanceof Approved);
        assertFalse(progetto.getState() instanceof Blocked);
        assertFalse(progetto2.getState() instanceof Blocked);
    }

    @Test
    void declineProgetto(){
        esperto.declineProgetto(progetto);
        esperto.declineProgetto(progetto2);
        assertTrue(progetto.getState() instanceof Blocked);
        assertTrue(progetto2.getState() instanceof Blocked);
        assertFalse(progetto.getState() instanceof Approved);
        assertFalse(progetto2.getState() instanceof Approved);
    }

    }
