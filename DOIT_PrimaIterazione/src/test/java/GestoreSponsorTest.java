import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

public class GestoreSponsorTest {

    private Sponsor sponsor;
    private Sponsor sponsor2;
    private static GestoreSponsor instance;

    @BeforeEach
    void createSponsorTest(){
      instance = null;
      instance = GestoreSponsor.getInstance();
      sponsor = new Sponsor("Metisoft");
      sponsor2 = new Sponsor("Bastarelli");

    }

    @Test
    void gestSingleSponsorTest(){
        instance.getInstance().addSponsor(sponsor);
        //assertTrue(instance.getSingleSponsor(sponsor.getID()).equals(sponsor));
    }

    @Test
    void getSponsorsTest(){
        instance.getInstance().addSponsor(sponsor);
        instance.getInstance().addSponsor(sponsor2);
        assertTrue(instance.getSponsors().contains(sponsor));
        assertTrue(instance.getSponsors().contains(sponsor2));
    }

    @Test
    void addSponsorTest(){
        instance.getInstance().addSponsor(sponsor);
        assertTrue(instance.getSponsors().contains(sponsor));
        assertFalse(instance.getSponsors().contains(sponsor2));
        instance.getInstance().addSponsor(sponsor2);
        assertTrue(instance.getSponsors().contains(sponsor2));


    }

    @Test
    void removeSponsorTest(){
        assertFalse(instance.getSponsors().contains(sponsor2));
        instance.getInstance().addSponsor(sponsor2);
        assertTrue(instance.getSponsors().contains(sponsor2));
        instance.getInstance().removeSponsor(sponsor2);
        assertFalse(instance.getSponsors().contains(sponsor2));
    }
}
