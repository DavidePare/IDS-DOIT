package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProponenteProgettoServiceImplTest {

    Progetto p;
    ProponenteProgetto proponenteProgettoA,proponenteProgettoB;
    Progettista progettistaA,progettistaB;
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
    void init() {
        progettistaA=progettistaService.createProgettista("Paolo","Bronio","a","a");
        progettistaB= progettistaService.createProgettista("Mario","Rossi","b","b");
        e=espertoService.createEsperto("Mario","Michelini","d","d");
    }
    @Test
    void createProponenteProgetto() {
        assertTrue(proponenteProgettoService.getAllProponentiProgetto().isEmpty());
        proponenteProgettoService.createProponenteProgetto("Luca","Malva","qqqqqq","");
        proponenteProgettoService.createProponenteProgetto("Mario","Biondi","1qqq","");
        assertEquals(proponenteProgettoService.getAllProponentiProgetto().size(),2);

    }

    @Test
    void deleteProponenteProgetto() {

        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","qww","");
        ProponenteProgetto proponenteB=proponenteProgettoService.createProponenteProgetto("Mario","Biondi","wwwww","");

        assertEquals(proponenteProgettoService.getAllProponentiProgetto().size(),2);
        Progetto p=proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);

       // progettoService.addCandidato(p.getId(),progettistaA.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());
        p=progettoService.getProgetto(p.getId());
        List<Progettista> lProgettisti= p.getTeam().getProgettistiTeam();
        assertTrue(lProgettisti.isEmpty());
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaB.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaB.getId());
        p=progettoService.getProgetto(p.getId());
        lProgettisti= p.getTeam().getProgettistiTeam();
        assertEquals(lProgettisti.size(),2);
/*        proponenteProgettoService.deleteProponenteProgetto(proponenteA.getId());
        assertTrue(progettistaService.getProgettista(progettistaA.getId()).getTeamsProgettista().isEmpty());
        assertTrue(progettistaService.getProgettista(progettistaB.getId()).getTeamsProgettista().isEmpty());
        p= progettoService.getProgetto(p.getId());
        assertNull(p);*/
    }

    @Test
    void getProponenteProgetto() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","wwww","");
        assertEquals(proponenteProgettoService.getProponenteProgetto(proponenteA.getId()).getId(),proponenteA.getId());

    }

    @Test
    void getAllProponentiProgetto() {
        assertTrue(proponenteProgettoService.getAllProponentiProgetto().isEmpty());
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","qqqqqq","");
        ProponenteProgetto proponenteB=proponenteProgettoService.createProponenteProgetto("Massimo","Boldi","qqqqqqqqq","");
        assertEquals(proponenteProgettoService.getAllProponentiProgetto().size(), 2);
    }

    @Test
    void addProgettoGestito() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Massimo","Sordi","sssqqq","");
        p= progettoService.createProgetto(proponenteA.getId(),"ioT",5);
        proponenteProgettoService.addProgettoGestito(proponenteA.getId(),p.getId());
        assertEquals(proponenteProgettoService.getProgettiGestiti(proponenteA.getId()).size(), 1);
        p= progettoService.createProgetto(proponenteA.getId(),"ioT",5);
        proponenteProgettoService.addProgettoGestito(proponenteA.getId(),p.getId());
        assertEquals(proponenteProgettoService.getProgettiGestiti(proponenteA.getId()).size(), 2);
    }

    @Test
    void removeProgettoGestito() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Massimo","Sordi","qqqq","q");
        p= proponenteProgettoService.createProgetto(proponenteA.getId(),"ioT",5);
        Progetto p2= proponenteProgettoService.createProgetto(proponenteA.getId(),"ioT",5);
        assertEquals(proponenteProgettoService.getProgettiGestiti(proponenteA.getId()).size(), 2);
        proponenteProgettoService.removeProgettoGestito(proponenteA.getId(),p.getId());
        assertEquals(proponenteProgettoService.getProgettiGestiti(proponenteA.getId()).size(), 1);
    }

    @Test
    void createProgetto() {
        ProponenteProgetto prop=proponenteProgettoService.createProponenteProgetto("Luca","Malva","qqqq","");
        proponenteProgettoService.createProgetto(prop.getId(),"Iot",5);
        assertEquals(proponenteProgettoService.getProgettiGestiti(prop.getId()).size(),1);
    }

    @Test
    void acceptCandidatura() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","ddd","");
        Progetto p=proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);

        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());
        p=progettoService.getProgetto(p.getId());
        List<Progettista> lProgettisti= p.getTeam().getProgettistiTeam();
        assertTrue(lProgettisti.isEmpty());
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaB.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaB.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getTeam().getProgettistiTeam().size(),2);
    }

    @Test
    void declineCandidatura() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","ddddddd","");
        Progetto p=proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());
        p=progettoService.getProgetto(p.getId());
        List<Progettista> lProgettisti= p.getTeam().getProgettistiTeam();
        assertTrue(lProgettisti.isEmpty());
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaB.getId());
        proponenteProgettoService.declineCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());
        proponenteProgettoService.declineCandidatura(proponenteA.getId(),p.getId(),progettistaB.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getTeam().getProgettistiTeam().size(),0);
        assertEquals(progettoService.getProgetto(p.getId()).getCandidati().size(),0);
    }

    @Test
    void inviteProgettista() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","sssssss","");
        p=proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        progettoService.confirmProgetto(p.getId(),proponenteA.getId());
        proponenteProgettoService.inviteProgettista(proponenteA.getId(),p.getId(),progettistaA.getId());
        p=progettoService.getProgetto(p.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),1);

        proponenteProgettoService.inviteProgettista(proponenteA.getId(),p.getId(),progettistaA.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),1);


    }

    @Test
    void getProgettiGestiti() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","umbero","");
        assertEquals(proponenteProgettoService.getProponenteProgetto(proponenteA.getId()).getProgettiGestiti().size(),0);
        proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        assertEquals(proponenteProgettoService.getProponenteProgetto(proponenteA.getId()).getProgettiGestiti().size(),3);

    }

    @Test
    void removeProgettistaFromProgetto() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","ddddd","");
        p=proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        progettoService.confirmProgetto(p.getId(),e.getId());
        proponenteProgettoService.inviteProgettista(proponenteA.getId(),p.getId(),progettistaA.getId());
        progettistaService.acceptInvito(p.getId(),progettistaA.getId());

        assertEquals(progettoService.getProgetto(p.getId()).getTeam().getProgettistiTeam().size(),1);
        proponenteProgettoService.removeProgettistaFromProgetto(proponenteA.getId(),p.getId(),progettistaA.getId());

        progettistaService.getProgettista(proponenteA.getId());

        assertEquals(progettoService.getProgetto(p.getId()).getTeam().getProgettistiTeam().size(),0);
    }

    @Test
    void getComponentOfTeam() {
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","ddd","");
        p=proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        progettoService.confirmProgetto(p.getId(),proponenteA.getId());
        proponenteProgettoService.inviteProgettista(proponenteA.getId(),p.getId(),progettistaA.getId());
        progettistaService.acceptInvito(p.getId(),proponenteA.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());
        progettistaService.sendCandidatura(p.getId(),progettistaB.getId());
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());

        assertEquals(proponenteProgettoService.getComponentOfTeam(p.getId(),proponenteA.getId()).size(),1);
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaB.getId());
        assertEquals(proponenteProgettoService.getComponentOfTeam(p.getId(),proponenteA.getId()).size(),2);

    }


    @Test
    void getInvitableProgettisti(){
        ProponenteProgetto proponenteA=proponenteProgettoService.createProponenteProgetto("Luca","Malva","c","c");
        p=proponenteProgettoService.createProgetto(proponenteA.getId(),"IoT",5);
        progettoService.confirmProgetto(p.getId(),proponenteA.getId());
        assertEquals(proponenteProgettoService.getInvitableProgettisti(p.getId(),proponenteA.getId()).size(),2); //3
        progettistaService.sendCandidatura(p.getId(),progettistaA.getId());

        assertEquals(proponenteProgettoService.getInvitableProgettisti(p.getId(),proponenteA.getId()).size(),1);
        proponenteProgettoService.acceptCandidatura(proponenteA.getId(),p.getId(),progettistaA.getId());
        assertEquals(proponenteProgettoService.getInvitableProgettisti(p.getId(),proponenteA.getId()).size(),1);


    }
}