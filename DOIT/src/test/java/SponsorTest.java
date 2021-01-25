import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SponsorTest {

    private Sponsor sponsor;
    private Sponsor sponsor2;
    private Progetto progetto;
    private Progetto progetto2;
    private int amount=200;

    @BeforeEach
    void createSponsor(){
        sponsor = new Sponsor("Metisoft");
        sponsor2 = new Sponsor("Bastarelli");
        progetto = new Progetto(3,"Vaccino COVID-19",50);
        progetto2 = new Progetto(2,"Clistere",5);
    }

    @Test
    void getNameTest(){
        assertEquals(sponsor.getName(),"Metisoft");
        assertEquals(sponsor2.getName(),"Bastarelli");
        assertNotEquals(sponsor.getName(),"Lorenzo");
        assertNotEquals(sponsor2.getName(),"Paola");
    }

    @Test
    void getProgettiInvTest(){
       sponsor.addAmountProgetto(progetto,amount);
       assertTrue(progetto.getAmount()==0);
       progetto.confirmProgetto();
       progetto2.confirmProgetto();
       sponsor.addAmountProgetto(progetto,amount);
       sponsor.addAmountProgetto(progetto,amount);
       sponsor.addAmountProgetto(progetto2,amount);
       assertTrue(sponsor.getProgettiInv().containsKey(progetto));
       assertTrue(sponsor.getProgettiInv().containsKey(progetto2));
       assertFalse(sponsor2.getProgettiInv().containsKey(progetto2));
       assertTrue(progetto2.getAmount()==200);
       assertTrue(progetto.getAmount()==400);
    }

    @Test
    void decrementAmountProgetto(){
        sponsor.decrementAmountProgetto(progetto,amount);
        sponsor.decrementAmountProgetto(progetto2,amount);
        assertFalse(sponsor.getProgettiInv().containsKey(progetto));
        assertFalse(sponsor.getProgettiInv().containsKey(progetto2));
        assertTrue(progetto.getAmount()==0);
        progetto.confirmProgetto();
        progetto2.confirmProgetto();
        sponsor.addAmountProgetto(progetto,amount);
        sponsor.addAmountProgetto(progetto,amount);
        sponsor.decrementAmountProgetto(progetto,amount);
        assertTrue(progetto.getAmount()==200);
        sponsor.decrementAmountProgetto(progetto,amount);
        assertTrue(progetto.getAmount()==0);
        /*
            questo non me lo deve far fare in verità
         */
        sponsor.decrementAmountProgetto(progetto,amount);
        assertTrue(progetto.getAmount()==-200);


    }
}
