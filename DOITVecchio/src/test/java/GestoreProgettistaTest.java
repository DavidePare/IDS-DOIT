import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestoreProgettistaTest {
    private Progettista p3,p1,p2;
    @BeforeEach
    void createprogettisti(){

        p3=new Progettista("Luca","Rossi", new Curriculum());

        p2=new Progettista("GianLuca","Bianchi", new Curriculum());
        p1=new Progettista("Massimo","Rossi", new Curriculum());
    }

    @Test
    void removeandAddProgettista() {
        assertTrue(GestoreProgettista.getInstance().getProgettisti().isEmpty());
        GestoreProgettista.getInstance().addProgettista(p1);
        GestoreProgettista.getInstance().addProgettista(p2);
        GestoreProgettista.getInstance().addProgettista(p3);

        assertTrue(GestoreProgettista.getInstance().getProgettisti().size()==3);

        GestoreProgettista.getInstance().removeProgettista(p2);

        assertTrue(GestoreProgettista.getInstance().getProgettisti().size()==2);

        GestoreProgettista.getInstance().removeProgettista(p2);

        assertTrue(GestoreProgettista.getInstance().getProgettisti().size()==2);

    }

}