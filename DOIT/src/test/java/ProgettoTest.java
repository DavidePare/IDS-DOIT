import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgettoTest {
   /* Progetto p,pr,progetto;
    Progettista progettista,progettista2;
    @BeforeEach
    void createProject(){
        p=new Progetto();
        pr=new Progetto();
        progetto=new Progetto();
        progettista=new Progettista();
        progettista2=new Progettista();
    }
    @Test
    void getID() {
    }

    @Test
    void getProponenteProgetto() {
    }

    @Test
    void getState() {
        assertTrue(p.getState() instanceof Waiting);
    }

    @Test
    void confirmProgetto() {
        p.confirmProgetto();
        assertTrue(p.getState() instanceof Approved);
        assertFalse(progetto.getState() instanceof Approved);
    }

    @Test
    void declineProgetto() {
        p.declineProgetto();
        assertTrue(p.getState() instanceof Blocked);
        assertFalse(progetto.getState() instanceof Blocked);
    }

    @Test
    void getTeam() {
    }

    @Test
    void addCandidato() {
        p.addCandidato(progettista);
        assertTrue(p.getCandidati().size()==0);
        p.confirmProgetto();
        p.addCandidato(progettista);
        assertTrue(p.getCandidati().size()==1);
        p.addCandidato(progettista2);
        assertTrue(p.getCandidati().size()==2);
        progetto.declineProgetto();
        progetto.addCandidato(progettista);
        assertTrue(progetto.getCandidati().size()==0);
    }

    @Test
    void removeCandidato() {
        p.confirmProgetto();
        p.addCandidato(progettista);
        p.addCandidato(progettista2);
        System.out.println(p.getCandidati().size());
        assertTrue(p.getCandidati().size()==2);
        p.removeCandidato(progettista2);
       // assertTrue(p.getCandidati().size()==1);
        p.removeCandidato(progettista);
        assertTrue(p.getCandidati().isEmpty());
    }

    @Test
    void getSingleCandidato() {
    }

    @Test
    void getCandidati() {
    }

    @Test
    void incrementAmount() {
    }

    @Test
    void decrementAmount() {
    }

    @Test
    void setState() {
        p.confirmProgetto();
        assertTrue(p.getState() instanceof Approved);
        pr.declineProgetto();
        assertFalse(p.getState() instanceof Waiting);
    }

    @Test
    void setAmount() {
    }

    @Test
    void getAmount() {
    }*/
}