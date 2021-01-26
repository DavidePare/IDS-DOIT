import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgettistaTest {
    Progetto progettoA,progettoB;
    Progettista p1,p2,p3;
    Curriculum c;
    ProponenteProgetto proponenteProgetto;
    @BeforeEach
    void createProgettisti(){
        c=new Curriculum();
        p1 = new Progettista("Pippo","Cognome",c);
        p2 = new Progettista("Mario","Boldi",c);
        p3 = new Progettista("Gianluca","Marrone",c);
        progettoA = new Progetto(1,"Iot",10);
        progettoB = new Progetto(1,"Data analysis",5);
        proponenteProgetto= new ProponenteProgetto("Michele","Raimondi",c);

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
    void acceptInvito() {
        assertTrue(p1.getProgettiProgettista().isEmpty());
        proponenteProgetto.inviteProgettista(p1,progettoA);
        assertEquals(p1.getInviti().size(),1);
        progettoA.confirmProgetto();
        p1.acceptInvito(progettoA);
        assertEquals(p1.getProgettiProgettista().size(),1);
        assertEquals(p1.getInviti().size(),0);

    }

    @Test
    void refuseInvito() {
        assertTrue(p1.getProgettiProgettista().isEmpty());
        proponenteProgetto.inviteProgettista(p1,progettoA);
        assertEquals(p1.getInviti().size(),1);
        progettoA.confirmProgetto();
        p1.refuseInvito(progettoA);
        assertTrue(p1.getProgettiProgettista().isEmpty());
        assertEquals(p1.getInviti().size(),0);
    }

    @Test
    void getprogettiCandidati() {
        assertTrue(p1.getprogettiCandidati().isEmpty());
        p1.sendCandidatura(progettoA);
        p1.sendCandidatura(progettoB);
        assertEquals(p1.getprogettiCandidati().size(),2);

    }

    @Test
    void addprogettoCandidato() {
        progettoA.confirmProgetto();
        p1.sendCandidatura(progettoA);
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
    void sendCandidatura() {
        progettoA.confirmProgetto();
        assertTrue(progettoA.getCandidati().isEmpty());
        p1.sendCandidatura(progettoA);
        assertFalse(progettoA.getCandidati().isEmpty());
        assertTrue(progettoA.getCandidati().contains(p1.getID()));
    }
}