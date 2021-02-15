package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EspertoServiceImplTest {
    Progetto p, pr, progetto;
    ProponenteProgetto proponenteProgettoA,proponenteProgettoB;
    Esperto e;
    Curriculum c;
    @Autowired
    ProgettoServiceImpl progettoService;
    @Autowired
    ProgettistaServiceImpl progettistaService;
    @Autowired
    SponsorServiceImpl sponsorService;
    @Autowired
    EspertoServiceImpl espertoService;
    @Autowired
    ProponenteProgettoServiceImpl proponenteProgettoService;

    @BeforeEach
    void init() {
        proponenteProgettoA=proponenteProgettoService.createProponenteProgetto("mario","rossi");
        proponenteProgettoB=proponenteProgettoService.createProponenteProgetto("paolo","morlacco");
        e=espertoService.createEsperto("Mario","Michelini");
    }

    @Test
    void addProgetto() {
        Progetto p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        Progettista progettistaA= progettistaService.createProgettista("Gianluca","Alessio");
        espertoService.confirmProgetto(p.getId(),e.getId());
        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),1);
        espertoService.addProgetto(e.getId(),p.getId());

        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),1);
    }

    @Test
    void removeProgetto() {
        Progetto p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        Progettista progettistaA= progettistaService.createProgettista("Gianluca","Alessio");
        espertoService.confirmProgetto(p.getId(),e.getId());
        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),1);
        espertoService.addProgetto(e.getId(),p.getId());
        p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.confirmProgetto(p.getId(),e.getId());

        p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.confirmProgetto(p.getId(),e.getId());

        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),3);

        p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.declineProgetto(p.getId(),e.getId());
        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),4);

        espertoService.removeProgetto(e.getId(),p.getId());
        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),3);

        espertoService.removeProgetto(e.getId(),p.getId());
        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),3);
    }

    @Test
    void createEsperto() {
        e=espertoService.createEsperto("Mario","Michelini");
        e=espertoService.createEsperto("Mario","Michelini");
        assertEquals(espertoService.getAllEsperti().size(),3);
    }

    @Test
    void deleteEsperto() {
        p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.confirmProgetto(p.getId(),e.getId());

        Progetto p2=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.confirmProgetto(p.getId(),e.getId());
        espertoService.deleteEsperto(e.getId());
        assertNotSame(progettoService.getProgetto(p.getId()).getEspertoId(), e.getId());
        assertThrows(NoSuchElementException.class,()-> espertoService.getEsperto(e.getId()));
    }

    @Test
    void getEsperto() {
        e=espertoService.createEsperto("Mario","Michelini");
        assertEquals(espertoService.getEsperto(e.getId()).getId(),e.getId());
    }

    @Test
    void getAllEsperti() {
        e=espertoService.createEsperto("Mario","Michelini");
        e=espertoService.createEsperto("Mario","Michelini");
        assertEquals(espertoService.getAllEsperti().size(),3);

    }

    @Test
    void confirmProgetto() {
        p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.confirmProgetto(p.getId(),e.getId());

        p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.confirmProgetto(p.getId(),e.getId());

        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),2);
        assertEquals(progettoService.getProgetto(p.getId()).getState().toString(),"Accepted");
    }

    @Test
    void declineProgetto() {

        p=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.declineProgetto(p.getId(),e.getId());

        Progetto p2=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.declineProgetto(p2.getId(),e.getId());
        espertoService.declineProgetto(p.getId(),e.getId());
        assertEquals(espertoService.getEsperto(e.getId()).getProgettiEsperto().size(),2);
        assertEquals(progettoService.getProgetto(p.getId()).getState().toString(),"Blocked");
    }
}