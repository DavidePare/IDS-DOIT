package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.ProponenteProgettoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
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
    ProponenteProgettoServiceImpl proponenteProgettoService;
    @BeforeEach
    void createProject() {
     p = new Progetto(1L,"Iot",10);
     pr = new Progetto(2L,"DataAnalysis",10);
     progetto = new Progetto(3L,"Prova",10);
     e = new Esperto("ciccio","pasticcio");
        c = new Curriculum();
        proponenteProgettoService.createProponenteProgetto("mario","rossi");
        proponenteProgettoService.createProponenteProgetto("paolo","morlacco");

    }
    @Test
    void createProgetto () {
        //assertTrue(progettoService.getAllProgetti().isEmpty());
        progettoService.createProgetto(1L,"ciccio",10);
        assertEquals(progettoService.getAllProgetti().size(),1);

    }

    @Test
    void deleteProgetto () {
    }

    @Test
    void getProgetto () {
    }

    @Test
    void getAllProgetti () {
    }

    @Test
    void confirmProgetto () {
    }

    @Test
    void declineProgetto () {
        progettoService.createProgetto(1L,"Mario",10);

        //progettoService.declineProgetto(1L,1L);
        p=progettoService.getProgetto(1L);
        //assertTrue(p.getState() instanceof Waiting);
        //System.out.println(p.getId());
        //System.out.println(e.getId());

        //progettoService.declineProgetto(p.getId(),e.getId());
        //assertTrue(p.getState() instanceof Blocked);
        //assertFalse(progetto.getState() instanceof Blocked);
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
