import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgettistaTest {
   /* GestoreProgetto gestoreProgetto= GestoreProgetto.getInstance();
    Progetto progettoA,progettoB;
    Progettista p1,p2,p3;
    ProponenteProgetto proponenteProgetto;
    @BeforeEach
    void createProgettisti(){
        p1 = new Progettista();
        p2 = new Progettista();
        p3 = new Progettista();
        progettoA = new Progetto();
        progettoB = new Progetto();
        proponenteProgetto= new ProponenteProgetto();

    }

    @Test
    void getProgettiProgettista() {
    }

    @Test
    void addProgetto() {
        progettoA.confirmProgetto();
        p1.addProgetto(progettoA);
        progettoB.confirmProgetto();
        p1.addProgetto(progettoB);
        assertTrue(p1.getProgettiProgettista().size()==2);
        assertTrue(p2.getProgettiProgettista().isEmpty());
    }

    @Test
    void removeProgetto() {
        progettoA.confirmProgetto();
        p1.addProgetto(progettoA);
        progettoB.confirmProgetto();
        p1.addProgetto(progettoB);
        p1.removeProgetto(progettoA);
        assertTrue(p1.getProgettiProgettista().size()==1);
        p1.removeProgetto(progettoB);
        assertTrue(p1.getProgettiProgettista().isEmpty());
    }

    @Test
    void getInviti() {
    }

    @Test
    void addInvito() {
    }

    @Test
    void acceptInvito() {
        assertTrue(p1.getProgettiProgettista().isEmpty());
        proponenteProgetto.inviteProgettista(p1,progettoA);

        assertEquals(p1.getInviti().size(),1);
        p1.acceptInvito(progettoA);
        assertEquals(p1.getProgettiProgettista().size(),1);
        assertEquals(p1.getInviti().size(),0);

    }

    @Test
    void refuseInvito() {
    }

    @Test
    void getprogettiCandidati() {
    }

    @Test
    void addprogettoCandidato() {
        progettoA.confirmProgetto();
        p1.sendCandidatura(progettoA);
        //p1.sendCandidatura(progettoA);
        assertTrue(p1.getprogettiCandidati().size()==1);
        assertTrue(p2.getprogettiCandidati().isEmpty());
    }

    @Test
    void removeprogettoCandidato() {
        assertTrue(p1.getprogettiCandidati().isEmpty());
        p1.sendCandidatura(progettoA);

        assertFalse(p1.getprogettiCandidati().isEmpty());

        assertTrue(p1.getprogettiCandidati().size()==1);
        p1.sendCandidatura(progettoB);

        assertTrue(p1.getprogettiCandidati().size()==2);
    }

    @Test
    void getTeamsProgettista() {
    }

    @Test
    void sendCandidatura() {
        progettoA.confirmProgetto();
        assertTrue(progettoA.getCandidati().isEmpty());
        p1.sendCandidatura(progettoA);
        assertFalse(progettoA.getCandidati().isEmpty());
        assertTrue(progettoA.getCandidati().contains(p1.getID()));
    }*/
}