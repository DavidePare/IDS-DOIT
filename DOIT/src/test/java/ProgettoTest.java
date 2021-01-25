import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgettoTest {
    Progetto p, pr, progetto;
    Progettista progettista, progettista2;
    Curriculum c;
    @BeforeEach
    void createProject() {
        c= new Curriculum();
        p = new Progetto(1,"Iot",10);
        pr = new Progetto(2,"DataAnalysis",10);
        progetto = new Progetto(3,"Prova",10);
        progettista = new Progettista("Pippo","Baudo", c);
        progettista2 = new Progettista("Mario","Rossi",c);
    }

    @Test
    void getState() {
        assertTrue(p.getState() instanceof Waiting);
        p.declineProgetto();
        assertTrue(p.getState() instanceof Blocked);
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
        assertTrue(p.getTeam().hashCode() != pr.getTeam().hashCode());
        assertTrue(p.getTeam().getProgetto() == p.getID());
    }

    @Test
    void addCandidato() {
        p.addCandidato(progettista);
        assertTrue(p.getCandidati().size() == 0);
        p.confirmProgetto();
        p.addCandidato(progettista);
        assertTrue(p.getCandidati().size() == 1);
        p.addCandidato(progettista2);
        assertTrue(p.getCandidati().size() == 2);
        progetto.declineProgetto();
        progetto.addCandidato(progettista);
        assertTrue(progetto.getCandidati().size() == 0);
    }

    @Test
    void removeCandidato() {
        p.confirmProgetto();
        p.addCandidato(progettista);
        p.addCandidato(progettista2);
        assertTrue(p.getCandidati().size() == 2);
        p.removeCandidato(progettista2);
        p.removeCandidato(progettista);
        assertTrue(p.getCandidati().isEmpty());
    }


    @Test
    void incrementAmount() {
        p.confirmProgetto();
        assertTrue(p.getAmount()==0);
        p.incrementAmount(100);
        assertTrue(p.getAmount()==100);
    }

    @Test
    void decrementAmount() {
        p.confirmProgetto();
        assertTrue(p.getAmount()==0);
        p.incrementAmount(1000);
        p.decrementAmount(100);
        System.out.println(p.getAmount());
        assertTrue(p.getAmount()==900);

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
        p.confirmProgetto();
        p.incrementAmount(100);
        assertTrue(p.getAmount()==100);
        pr.incrementAmount(100);
        assertFalse(pr.getAmount()==100);
    }

    @Test
    void getAmount() {
        assertTrue(p.getAmount()==0);
        p.incrementAmount(100);

        assertTrue(p.getAmount()==0);
        p.confirmProgetto();

        p.incrementAmount(100);
        assertTrue(p.getAmount()==100);
    }
}