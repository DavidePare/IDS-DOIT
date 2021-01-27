import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProponenteProgettoTest {

    ProponenteProgetto proponenteProgetto;
    Progetto p1,p2;
    Progettista progettista;
    Curriculum curriculum;

    @BeforeEach
    void createComponent(){
        proponenteProgetto = new ProponenteProgetto("Davide","Parente",curriculum);
        p1 = new Progetto(1,"DOIT",3);
        p2 = new Progetto(2,"C3",3);
        curriculum = new Curriculum();
        progettista = new Progettista("Paolo","Rossi",curriculum);
    }

    @Test
    void getProgettiGestiti() {
        assertTrue(proponenteProgetto.getProgettiGestiti().isEmpty());
        proponenteProgetto.addProgettoGestito(p1);
        assertFalse(proponenteProgetto.getProgettiGestiti().isEmpty());
        proponenteProgetto.addProgettoGestito(p2);
        assertTrue(proponenteProgetto.getProgettiGestiti().size()==2);
        proponenteProgetto.removeProgettoGestito(p1);
        assertTrue(proponenteProgetto.getProgettiGestiti().size()==1);
        proponenteProgetto.removeProgettoGestito(p2);
        assertTrue(proponenteProgetto.getProgettiGestiti().isEmpty());
    }

    @Test
    void acceptCandidatura() {
        p1.confirmProgetto();
        proponenteProgetto.addProgettoGestito(p1);
        progettista.addprogettoCandidato(p1);
        p1.addCandidato(progettista);
        proponenteProgetto.acceptCandidatura(p1,progettista);
        assertTrue(p1.getTeam().getProgettisti().contains(progettista));
        assertTrue(progettista.getprogettiCandidati().isEmpty());
        assertFalse(p1.getCandidati().contains(progettista.getID()));
    }

    @Test
    void declineCandidatura() {
        p1.confirmProgetto();
        proponenteProgetto.addProgettoGestito(p1);
        progettista.addprogettoCandidato(p1);
        p1.addCandidato(progettista);
        proponenteProgetto.declineCandidatura(p1,progettista);
        assertFalse(p1.getTeam().getProgettisti().contains(progettista));
        assertTrue(progettista.getprogettiCandidati().isEmpty());
        assertFalse(p1.getCandidati().contains(progettista.getID()));
    }

    @Test
    void inviteProgettista() {
        assertTrue(progettista.getInviti().isEmpty());
        proponenteProgetto.inviteProgettista(progettista,p1);
        assertTrue(progettista.getInviti().contains(p1));
    }

}
