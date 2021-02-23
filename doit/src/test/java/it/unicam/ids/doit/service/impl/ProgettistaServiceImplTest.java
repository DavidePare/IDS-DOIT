package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import it.unicam.ids.doit.entity.Curriculum.Curriculum;
import it.unicam.ids.doit.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.NoSuchElementException;

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
    @Autowired
    TeamService teamService;

    @BeforeEach
    void createProject() {
        proponenteProgettoA=proponenteProgettoService.createProponenteProgetto("mario","rossi","ddd","ddd");
        proponenteProgettoB=proponenteProgettoService.createProponenteProgetto("paolo","morlacco","ddd,","ddd");

        p= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"IoT",3);
        e=espertoService.createEsperto("Mario","Michelini","Giampiero","b");
    }

    @Test
    void createProgettista() {
        assertEquals(progettistaService.getAllProgettisti().size(),2);
        progettistaService.createProgettista("Nome","Cognome","cccccc","c");
        progettistaService.createProgettista("Nome2","Cognome2","ddddddddd","d");
        assertEquals(progettistaService.getAllProgettisti().size(),4);
    }

    @Test
    void deleteProgettista() {

       // assertEquals(progettistaService.getAllProgettisti().size(),2);
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","ddddddda","dddd");
        assertEquals(progettistaService.getMessage(progettistaA.getId()).size(),1);
        progettistaService.deleteProgettista(progettistaA.getId());
        assertThrows(NoSuchElementException.class, ()-> progettistaService.getProgettista(progettistaA.getId()));


    }

    @Test
    void getProgettista() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","Nome@","d");
        Progettista progettistaB=progettistaService.createProgettista("Nome2","Cognome2","ddddd","q");
        assertEquals(progettistaService.getAllProgettisti().size(),4);
        assertTrue(progettistaService.getProgettista(progettistaA.getId()) != null);

        assertNotEquals(progettistaService.getProgettista(progettistaB.getId()),null);


    }

    @Test
    void getAllProgettisti() {
        assertEquals(progettistaService.getAllProgettisti().size(),2);
        progettistaService.createProgettista("Nome","Cognome","qooo","ddd");
        progettistaService.createProgettista("Nome2","Cognome2","ssss","sss");
        assertEquals(progettistaService.getAllProgettisti().size(),4);
    }

    @Test
    void addWorkingExperience() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","ddddd","eeee");
        progettistaService.createCurriculum(progettistaA.getId(),"Scuola","Formato",331223335L,"Email");
        c=progettistaService.getCurriculum(progettistaA.getId());
        assertTrue(c.getWorkingExperience().isEmpty());
        progettistaService.addWorkingExperience(progettistaA.getId(),"Esperienza 1");
        progettistaService.addWorkingExperience(progettistaA.getId(),"Esperienza 2");

        c=progettistaService.getCurriculum(progettistaA.getId());
        assertEquals(c.getWorkingExperience().size(),2);
    }

    @Test
    void removeWorkingExperience() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","ssss","ss");
        progettistaService.createCurriculum(progettistaA.getId(),"Scuola","Formato",331223335L,"Email");
        c=progettistaService.getCurriculum(progettistaA.getId());
        assertTrue(c.getWorkingExperience().isEmpty());
        progettistaService.addWorkingExperience(progettistaA.getId(),"Esperienza 1");
        progettistaService.addWorkingExperience(progettistaA.getId(),"Esperienza 2");

        c=progettistaService.getCurriculum(progettistaA.getId());
        assertEquals(c.getWorkingExperience().size(),2);
        progettistaService.removeWorkingExperience(progettistaA.getId(),"Esperienza 1");

        assertEquals(progettistaService.getCurriculum(progettistaA.getId()).getWorkingExperience().size(),1);
        progettistaService.removeWorkingExperience(progettistaA.getId(),"Esperienza 1");

        assertEquals(progettistaService.getCurriculum(progettistaA.getId()).getWorkingExperience().size(),1);

    }

    @Test
    void addLanguages() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaa","qq");
        progettistaService.createCurriculum(progettistaA.getId(),"Scuola","Formato",331223335L,"Email");
        c=progettistaService.getCurriculum(progettistaA.getId());
        assertTrue(c.getLanguages().isEmpty());
        progettistaService.addLanguages(progettistaA.getId(),"Francese");
        progettistaService.addLanguages(progettistaA.getId(),"Inglese");

        c=progettistaService.getCurriculum(progettistaA.getId());
        assertEquals(c.getLanguages().size(),2);
    }

    @Test
    void removeLanguages() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","qqqq","aaaaaa");
        progettistaService.createCurriculum(progettistaA.getId(),"Scuola","Formato",331223335L,"Email");
        c=progettistaService.getCurriculum(progettistaA.getId());
        assertTrue(c.getLanguages().isEmpty());
        progettistaService.addLanguages(progettistaA.getId(),"Francese");
        progettistaService.addLanguages(progettistaA.getId(),"Inglese");

        c=progettistaService.getCurriculum(progettistaA.getId());
        assertEquals(c.getLanguages().size(),2);
        progettistaService.removeLanguages(progettistaA.getId(),"Francese");

        assertEquals(progettistaService.getCurriculum(progettistaA.getId()).getLanguages().size(),1);
        progettistaService.removeWorkingExperience(progettistaA.getId(),"Francese");

        assertEquals(progettistaService.getCurriculum(progettistaA.getId()).getLanguages().size(),1);
    }

    @Test
    void addProgetto() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaa","qqqqqq");
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        progettistaService.addProgetto(p.getId(),progettistaA.getId());
        progettistaService.addProgetto(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().size(),1);
    }

    @Test
    void removeProgetto() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaa","aa");
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        progettistaService.addProgetto(p.getId(),progettistaA.getId());
        progettistaService.addProgetto(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().size(),1);
        pr=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"Progetto2",5);
        espertoService.confirmProgetto(pr.getId(),e.getId());
        progettistaService.addProgetto(pr.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().size(),2);
        progettistaService.removeProgetto(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().size(),1);
        assertTrue(progettoService.getProgetto(p.getId()).getTeam().getProgettistiTeam().stream().noneMatch(t-> t.getId().equals(p.getId())));
    }

    @Test
    void addInvito() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaa","aaa");
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getInviti().size(),1);
    }

    @Test
    void acceptInvito() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaa","aaaa");
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getInviti().size(),1);
        progettistaService.acceptInvito(p.getId(),progettistaA.getId());
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getInviti().isEmpty());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().size(),1);
        assertTrue(progettoService.getProgetto(p.getId()).getProgettistiInvitati().isEmpty());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getInviti().size(),0);

        assertEquals(teamService.getTeam(progettoService.getProgetto(p.getId()).getTeam().getId()).getProgettistiTeam().size(),1);
    }

    @Test
    void refuseInvito() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaaa","aaaaa");
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getInviti().size(),1);
        progettistaService.refuseInvito(p.getId(),progettistaA.getId());

        progettistaService.refuseInvito(p.getId(),progettistaA.getId());
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getInviti().isEmpty());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().size(),0);
        assertTrue(progettoService.getProgetto(p.getId()).getProgettistiInvitati().isEmpty());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getInviti().size(),0);

        assertEquals(teamService.getTeam(progettoService.getProgetto(p.getId()).getTeam().getId()).getProgettistiTeam().size(),0);
    }

    @Test
    void addTeam() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaaaa","aaaaaa");

        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        pr= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"Progetto",5);
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        progettistaService.acceptInvito(p.getId(),progettistaA.getId());

        progettoService.confirmProgetto(pr.getId(),e.getId());
        progettistaService.addInvito(pr.getId(),progettistaA.getId());
        progettistaService.acceptInvito(pr.getId(),progettistaA.getId());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getTeamsProgettista().size(),2);

    }

    @Test
    void removeTeam() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaaa","aaaaa");

        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        pr= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"Progetto",5);
        espertoService.confirmProgetto(pr.getId(),e.getId());
        progettistaService.addInvito(p.getId(),progettistaA.getId());
        progettistaService.acceptInvito(p.getId(),progettistaA.getId());
        progettistaA= progettistaService.getProgettista(progettistaA.getId());
        progettistaService.addInvito(pr.getId(),progettistaA.getId());
        progettistaService.acceptInvito(pr.getId(),progettistaA.getId());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getTeamsProgettista().size(),2);
        progettistaService.removeTeam(progettistaA.getId(),p.getTeam().getId());
        assertEquals(progettistaA.getTeamsProgettista().size(),1);
    }

    @Test
    void addprogettoCandidato() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aa","");
        espertoService.confirmProgetto(p.getId(),e.getId());
        progettistaService.addprogettoCandidato(p.getId(),progettistaA.getId());
        progettistaService.addprogettoCandidato(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),1);
    }

    @Test
    void removeprogettoCandidato() {

        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaa","");
        espertoService.confirmProgetto(p.getId(),e.getId());
        progettistaService.addprogettoCandidato(p.getId(),progettistaA.getId());
        pr=proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"Progetto2",5);
        espertoService.confirmProgetto(pr.getId(),e.getId());
        progettistaService.addprogettoCandidato(pr.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),2);
        progettistaService.removeprogettoCandidato(p.getId(),progettistaA.getId());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),1);

        progettistaService.removeprogettoCandidato(p.getId(),progettistaA.getId());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),1);

    }

    @Test
    void sendCandidatura() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaaaaaaa","");

        Progettista progettistaB=progettistaService.createProgettista("Nome","Cognome","aaaaaa","");
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().isEmpty());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),0);
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),1);
        assertEquals(progettoService.getCandidati(p.getId()).size(),1);
        pr= proponenteProgettoService.createProgetto(proponenteProgettoA.getId(),"Progetto2",5);

        progettistaService.sendCandidatura(p.getId(),progettistaB.getId());
        progettoService.confirmProgetto(pr.getId(),e.getId());
        progettistaService.sendCandidatura(pr.getId(),progettistaA.getId());
        assertEquals(progettoService.getCandidati(p.getId()).size(),2);

        assertEquals(progettoService.getCandidati(pr.getId()).size(),1);
    }

    @Test
    void getCurriculum() {
    }

    @Test
    void getInviti() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaa","");
        assertTrue(progettistaService.getInviti(progettistaA.getId()).isEmpty());
        proponenteProgettoService.inviteProgettista(proponenteProgettoA.getId(),p.getId(),progettistaA.getId());
        progettistaA=progettistaService.getProgettista(progettistaA.getId());
        assertEquals(progettistaService.getInviti(progettistaA.getId()).size(),1);

        proponenteProgettoService.inviteProgettista(proponenteProgettoA.getId(),p.getId(),progettistaA.getId());

        assertEquals(progettistaService.getInviti(progettistaA.getId()).size(),1);

    }

    @Test
    void getProgettiAttivi() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","aaaaaaa","");
        progettoService.confirmProgetto(p.getId(),e.getId()); // è uguale mettere espertoservice
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().isEmpty());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteProgettoA.getId(),p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteProgettoA.getId(),p.getId(),progettistaA.getId());

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiProgettista().size(), 1);

    }

    @Test
    void getCandidature() {
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","a_a","");
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().isEmpty());

        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),0);
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),1);

        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),1);

    }

    @Test
    void getMessage(){
        Progettista progettistaA=progettistaService.createProgettista("Nome","Cognome","a_a","");
        assertEquals(progettistaService.getMessage(progettistaA.getId()).size(),1);

    }
}