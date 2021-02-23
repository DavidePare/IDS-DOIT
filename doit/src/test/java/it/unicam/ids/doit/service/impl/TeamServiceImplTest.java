package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import it.unicam.ids.doit.entity.Curriculum.Curriculum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TeamServiceImplTest {

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
    @Autowired
    TeamServiceImpl teamService;


    @BeforeEach
    void init() {
        proponenteProgettoA=proponenteProgettoService.createProponenteProgetto("mario","rossi","qqqqq","");
        proponenteProgettoB=proponenteProgettoService.createProponenteProgetto("paolo","morlacco","aaaaaaaa","");
        e=espertoService.createEsperto("Mario","Michelini","cccc","ccc");
    }

    @Test
    void createTeam() {
        teamService.createTeam((long) 1);
        assertEquals(teamService.getAllTeams().size(),1);
    }

    @Test
    void deleteTeam() {
        p= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        espertoService.confirmProgetto(p.getId(),e.getId());
        Team t=p.getTeam();
        teamService.deleteTeam(t.getId());

        assertThrows(NoSuchElementException.class,()-> teamService.getTeam(t.getId()));
    }

    @Test
    void getTeam() {
        p= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        assertFalse(teamService.getTeam(p.getTeam().getId()) == null);
        espertoService.confirmProgetto(p.getId(),e.getId());
        Progettista progettistaA= progettistaService.createProgettista("Gianluca","Alessio","aaa","");
        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(), 0);
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteProgettoA.getId(),p.getId(),progettistaA.getId());
        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(), 1);

    }

    @Test
    void getAllTeams() {
        assertTrue(teamService.getAllTeams().isEmpty());
        proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        assertEquals(teamService.getAllTeams().size(),2);
    }

    @Test
    void removeProgettista() {
        p= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);

        Progettista progettistaA= progettistaService.createProgettista("Gianluca","Alessio","qqqq","");
        Progettista progettistaB= progettistaService.createProgettista("Gianluca","Alessio","qqqqqqq","");
        teamService.addProgettista(p.getTeam().getId(),progettistaA.getId());

        teamService.addProgettista(p.getTeam().getId(),progettistaB.getId());
        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(),2);
        teamService.removeProgettista(p.getTeam().getId(),progettistaA.getId(),p.getId());
        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(),1);

        teamService.removeProgettista(p.getTeam().getId(),progettistaA.getId(),p.getId());
        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(),1);

        teamService.removeProgettista(p.getTeam().getId(),progettistaB.getId(),p.getId());
        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(),0);

    }

    @Test
    void addProgettista() {
        p= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);

        assertTrue(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().isEmpty());
        Progettista progettistaA= progettistaService.createProgettista("Gianluca","Alessio","qqqqqqqqq","");
        Progettista progettistaB= progettistaService.createProgettista("Gianluca","Alessio","qqqqqqqqqqqqq","");
        teamService.addProgettista(p.getTeam().getId(),progettistaA.getId());
        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(),1);

        teamService.addProgettista(p.getTeam().getId(),progettistaA.getId());

        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(),1);

        teamService.addProgettista(p.getTeam().getId(),progettistaB.getId());

        assertEquals(teamService.getTeam(p.getTeam().getId()).getProgettistiTeam().size(),2);
    }
}