package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProgettistaServiceImplTest {
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
    void createProject() {
        proponenteProgettoA=proponenteProgettoService.createProponenteProgetto("mario","rossi");
        proponenteProgettoB=proponenteProgettoService.createProponenteProgetto("paolo","morlacco");
        e=espertoService.createEsperto("Mario","Michelini");
    }

    @Test
    void createProgettista() {
        assertTrue(progettistaService.getAllProgettisti().isEmpty());
        progettistaService.createProgettista("Nome","Cognome");
        progettistaService.createProgettista("Nome2","Cognome2");
        assertEquals(progettistaService.getAllProgettisti().size(),2);
    }

    @Test
    void deleteProgettista() {
    }

    @Test
    void getProgettista() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome");
        Progettista progettistaB=progettistaService.createProgettista("Nome2","Cognome2");
        assertEquals(progettistaService.getAllProgettisti().size(),2);
        assertTrue(progettistaService.getProgettista(progettistaA.getId()) != null);

        assertNotEquals(progettistaService.getProgettista(progettistaB.getId()),null);


    }

    @Test
    void getAllProgettisti() {
        assertTrue(progettistaService.getAllProgettisti().isEmpty());
        progettistaService.createProgettista("Nome","Cognome");
        progettistaService.createProgettista("Nome2","Cognome2");
        assertEquals(progettistaService.getAllProgettisti().size(),2);
    }

    @Test
    void addWorkingExperience() {
        //TODO modificare
    }

    @Test
    void removeWorkingExperience() {
    }

    @Test
    void addLanguages() {
    }

    @Test
    void removeLanguages() {
    }

    @Test
    void addProgetto() {
    }

    @Test
    void removeProgetto() {
    }

    @Test
    void addInvito() {
    }

    @Test
    void acceptInvito() {
    }

    @Test
    void refuseInvito() {
    }

    @Test
    void addTeam() {
    }

    @Test
    void removeTeam() {
    }

    @Test
    void addprogettoCandidato() {
    }

    @Test
    void removeprogettoCandidato() {
    }

    @Test
    void sendCandidatura() {
    }

    @Test
    void getCurriculum() {
    }

    @Test
    void getInviti() {
    }

    @Test
    void getProgettiAttivi() {
    }

    @Test
    void getCandidature() {
    }
}