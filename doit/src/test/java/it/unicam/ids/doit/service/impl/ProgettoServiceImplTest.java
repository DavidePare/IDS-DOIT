package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProgettoServiceImplTest {



    Progetto p, pr, progetto;
    Progettista progettista, progettista2;
    Esperto e;
    Curriculum c;
    @Autowired
    ProgettoServiceImpl progettoService;
    @Autowired
    ProgettistaServiceImpl progettistaService;

    @Autowired
    EspertoServiceImpl espertoService;

    @Autowired
    ProponenteProgettoServiceImpl proponenteProgettoService;
    @BeforeEach
    void createProject() {
        proponenteProgettoService.createProponenteProgetto("mario","rossi");
        proponenteProgettoService.createProponenteProgetto("paolo","morlacco");
        espertoService.createEsperto("Mario","Michelini");
    }
    @Test
    void createProgetto () {
        Progetto progettoCreato=progettoService.createProgetto(1L,"ciccio",10);
        assertFalse(progettoService.getAllProgetti().isEmpty());
        List<Progetto> progettini=progettoService.getAllProgetti();
        assertEquals(progettoService.getAllProgetti().size(),1);

    }

    @Test
    void deleteProgetto () {

    }


    @Test
    void getProgetto () {
        p=progettoService.createProgetto(1L,"Mario",10);
        pr=progettoService.createProgetto(1L,"Luca",10);
        assertEquals(progettoService.getProgetto(pr.getId()).getId(),pr.getId());
        assertTrue(progettoService.getProgetto(pr.getId()).getId() ==pr.getId());

    }

    @Test
    void getAllProgetti () {
        assertTrue(progettoService.getAllProgetti().isEmpty());
        p=progettoService.createProgetto(1L,"Mario",10);
        pr=progettoService.createProgetto(1L,"Luca",10);
        assertTrue(progettoService.getAllProgetti().size()==2);
    }

    @Test
    void confirmProgetto () {
        p=progettoService.createProgetto(1L,"Mario",10);

        System.out.println(p);
        assertTrue(p.getState() instanceof Waiting);
        progettoService.confirmProgetto(p.getId(),1L);

        assertFalse(progettoService.getProgetto(p.getId()).getState() instanceof Waiting);

        assertTrue(progettoService.getProgetto(p.getId()).getState() instanceof Approved );
    }

    @Test
    void declineProgetto () {
        p=progettoService.createProgetto(1L,"Mario",10);

        System.out.println(p);
        assertTrue(p.getState() instanceof Waiting);
        progettoService.declineProgetto(p.getId(),1L);

        assertFalse(progettoService.getProgetto(p.getId()).getState() instanceof Waiting);

        assertTrue(progettoService.getProgetto(p.getId()).getState() instanceof Blocked );
    }

    @Test
    void addCandidato () {
    }

    @Test
    void removeCandidato () {
    }

    @Test
    void addProgettistaInvitato () {
    }

    @Test
    void removeProgettistaInvitato () {
    }

    @Test
    void addSponsor () {
    }

    @Test
    void removeSponsor () {
    }

    @Test
    void addEsperto () {
    }

    @Test
    void removeEsperto () {
    }

    @Test
    void removeTeam () {
    }

    @Test
    void incrementAmount () {
    }

    @Test
    void decrementAmount () {
    }

    @Test
    void getAllProgettiValutare () {
    }

    @Test
    void getCandidati () {
    }
}
