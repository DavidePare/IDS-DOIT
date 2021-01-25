import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestoreProgettoTest {
    GestoreProgetto p;
    Progetto p1,p2,p3,p4,p5;
    @BeforeEach
    void createproject(){
        GestoreProgetto p = GestoreProgetto.getInstance();
        p1=new Progetto(1,"prog1",5);
        p2=new Progetto(2,"prog2",5);
        p3=new Progetto(3,"prog3",5);
        p4=new Progetto(4,"prog4",5);
        p5=new Progetto(5,"prog5",5);
    }


    @Test
    void getProgettiForType() {
        assertTrue(p.getInstance().getProgetti().isEmpty());
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

    }
}