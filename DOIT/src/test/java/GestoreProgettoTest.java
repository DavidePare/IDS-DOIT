import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestoreProgettoTest {
    GestoreProgetto p;
    //IState s;
    Progetto p1,p2,p3,p4,p5;
    @BeforeEach
    void createproject(){
       /* GestoreProgetto p = GestoreProgetto.getInstance();
        p1=new Progetto();
        p2=new Progetto();
        p3=new Progetto();
        p4=new Progetto();
        p5=new Progetto();
*/
    }

    @Test
    void getProgetti() {

    }

    @Test
    void getSingleProgetto() {
    }

    @Test
    void getProgettiForType() {
      /*  assertTrue(p.getInstance().getProgetti().isEmpty());
        p.getInstance().addProgetto(p1);
        p.getInstance().addProgetto(p2);
        assertTrue(p.getInstance().getProgettiForType(new Waiting(null)).size() == 2);
        p1.confirmProgetto();
        assertTrue(p.getInstance().getProgettiForType(new Approved(null)).size() == 1);
        p2.declineProgetto();
        p1.declineProgetto();
        assertTrue(p.getInstance().getProgettiForType(new Blocked(null)).size() == 1);
        p.getInstance().removeProgetto(p2);

        assertTrue(p.getInstance().getProgettiForType(new Waiting(null)).size() == 0);

        assertTrue(p.getInstance().getProgettiForType(new Blocked(null)).size() == 0);
*/
    }

    @Test
    void getInstance() {

    }
}