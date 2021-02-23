package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.*;
import it.unicam.ids.doit.entity.Curriculum.Curriculum;
import it.unicam.ids.doit.entity.Sponsor.Sponsor;
import it.unicam.ids.doit.entity.Stato.Approved;
import it.unicam.ids.doit.entity.Stato.Blocked;
import it.unicam.ids.doit.entity.Stato.Waiting;
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
        proponenteProgettoA=proponenteProgettoService.createProponenteProgetto("mario","rossi","qqq","qq");
        proponenteProgettoB=proponenteProgettoService.createProponenteProgetto("paolo","morlacco","qq","qq");
        e=espertoService.createEsperto("Mario","Michelini","q","q");
    }
    @Test
    void createProgetto () {
        Progetto progettoCreato=progettoService.createProgetto(proponenteProgettoA.getId(),"ciccio",10);
        assertFalse(progettoService.getAllProgetti().isEmpty());
        assertEquals(progettoService.getAllProgetti().size(),1);
        progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",5);
        assertEquals(progettoService.getAllProgetti().size(),2);

    }

    @Test
    void deleteProgetto () {
        assertTrue(progettoService.getAllProgetti().isEmpty());

        Progetto p1=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",5);

        Progetto p2=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",5);

        Progetto p3=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",5);
        assertEquals(progettoService.getAllProgetti().size(),3);

        progettoService.deleteProgetto(p3.getId());

        assertEquals(progettoService.getAllProgetti().size(),2);
        progettoService.deleteProgetto(p2.getId());
        progettoService.deleteProgetto(p1.getId());
        assertTrue(progettoService.getAllProgetti().isEmpty());
    }


    @Test
    void getProgetto () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"Mario",10);
        pr=progettoService.createProgetto(proponenteProgettoA.getId(),"Luca",10);
        assertEquals(progettoService.getProgetto(pr.getId()).getId(),pr.getId());
        assertEquals(progettoService.getProgetto(pr.getId()).getId(),pr.getId());

    }

    @Test
    void getAllProgetti () {
        assertTrue(progettoService.getAllProgetti().isEmpty());
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"Mario",10);
        pr=progettoService.createProgetto(proponenteProgettoB.getId(),"Luca",10);
        assertEquals(progettoService.getAllProgetti().size(),2);
    }

    @Test
    void confirmProgetto () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"Mario",10);
        System.out.println(p);
        assertTrue(p.getState() instanceof Waiting);
        progettoService.confirmProgetto(p.getId(),1L);
        assertFalse(progettoService.getProgetto(p.getId()).getState() instanceof Waiting);
        assertTrue(progettoService.getProgetto(p.getId()).getState() instanceof Approved);
    }

    @Test
    void declineProgetto () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"Mario",10);
        System.out.println(p);
        assertTrue(p.getState() instanceof Waiting);
        progettoService.declineProgetto(p.getId(),e.getId());
        assertFalse(progettoService.getProgetto(p.getId()).getState() instanceof Waiting);
        assertTrue(progettoService.getProgetto(p.getId()).getState() instanceof Blocked);
    }

    @Test
    void addCandidato () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        assertTrue(p.getCandidati().isEmpty());
        Progettista progettistaA=progettistaService.createProgettista("Paolo","Bronio","bros","");
        Progettista progettistaB= progettistaService.createProgettista("Mario","Rossi","ss","");
        assertTrue(progettistaService.sendCandidatura(p.getId(),progettistaA.getId()));
        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),0);
        progettoService.confirmProgetto(p.getId(),e.getId());
        List<Progettista> progettistaList=progettoService.getProgetto(p.getId()).getCandidati();

        assertTrue(progettistaService.sendCandidatura(p.getId(),progettistaA.getId()));

        assertEquals(progettistaService.getProgettista(progettistaA.getId()).getProgettiCandidati().size(),1);

        progettoService.addCandidato(p.getId(),progettistaB.getId());
        progettistaList=progettoService.getProgetto(p.getId()).getCandidati();
        assertEquals(progettoService.getProgetto(p.getId()).getCandidati().size(),2);
    }

    @Test
    void removeCandidato () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        Progettista progettistaA=progettistaService.createProgettista("Paolo","Bronio","cc","");
        Progettista progettistaB= progettistaService.createProgettista("Mario","Rossi","ddd","");
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettoService.addCandidato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getCandidati(p.getId()).size(),1);
        progettoService.addCandidato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getCandidati(p.getId()).size(),1);
        progettoService.addCandidato(p.getId(),progettistaB.getId());
        assertEquals(progettoService.getCandidati(p.getId()).size(),2);
        progettoService.removeCandidato(p.getId(),progettistaB.getId());
        assertEquals(progettoService.getCandidati(p.getId()).size(),1);
    }

    @Test
    void addProgettistaInvitato () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        Progettista progettistaA=progettistaService.createProgettista("Paolo","Bronio","ddd","");
        Progettista progettistaB= progettistaService.createProgettista("Mario","Rossi","dddd","");
        progettoService.addProgettistaInvitato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),0);
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettoService.addProgettistaInvitato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),1);
        progettoService.addProgettistaInvitato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),1);

        progettoService.addProgettistaInvitato(p.getId(),progettistaB.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),2);

    }

    @Test
    void removeProgettistaInvitato () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        Progettista progettistaA=progettistaService.createProgettista("Paolo","Bronio","ddd","");
        Progettista progettistaB= progettistaService.createProgettista("Mario","Rossi","ddddd","");
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettoService.addProgettistaInvitato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),1);
        progettoService.removeProgettistaInvitato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),0);

        progettoService.removeProgettistaInvitato(p.getId(),progettistaA.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getProgettistiInvitati().size(),0);


    }

    @Test
    void addSponsor () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        Sponsor sponsor= sponsorService.createSponsor("mario","dd","");
        progettoService.addSponsor(p.getId(),sponsor.getId());
        progettoService.incrementAmount(p.getId(),100);
        assertNotEquals(progettoService.getProgetto(p.getId()).getAmount(),100.0);
        progettoService.confirmProgetto(p.getId(),e.getId());
        progettoService.addSponsor(p.getId(),sponsor.getId());
        progettoService.incrementAmount(p.getId(),100);
        assertEquals(progettoService.getProgetto(p.getId()).getAmount(),100.0);
        assertFalse(progettoService.getProgetto(p.getId()).getSponsors().isEmpty());

    }

    @Test
    void removeSponsor () {
    }

    @Test
    void addEsperto () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        progettoService.confirmProgetto(p.getId(),e.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getEspertoId(),e.getId());
        Progetto p2=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        progettoService.addEsperto(p2.getId(),e.getId());
        assertEquals(progettoService.getProgetto(p2.getId()).getEspertoId(),e.getId());
    }

    @Test
    void removeEsperto () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        progettoService.confirmProgetto(p.getId(),e.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getEspertoId(),e.getId());
        progettoService.removeEsperto(p.getId());
        assertEquals(progettoService.getProgetto(p.getId()).getEspertoId(),0);
    }


    @Test
    void incrementAmount () {
        Progetto p=progettoService.createProgetto(proponenteProgettoA.getId(),"ciccio",10);
        progettoService.confirmProgetto(p.getId(),e.getId());

        progettoService.incrementAmount(p.getId(),100.0);
        assertEquals(progettoService.getProgetto(p.getId()).getAmount(),100.0);
    }

    @Test
    void decrementAmount () {
        Progetto p=progettoService.createProgetto(proponenteProgettoA.getId(),"ciccio",10);
        progettoService.confirmProgetto(p.getId(),e.getId());
    //    progettoService.decrementAmount(p.getId(),100.0);
     //   assertEquals(progettoService.getProgetto(p.getId()).getAmount(),0.0);
        progettoService.incrementAmount(p.getId(),100.0);
        assertEquals(progettoService.getProgetto(p.getId()).getAmount(),100.0);
        progettoService.decrementAmount(p.getId(),100.0);
        assertEquals(progettoService.getProgetto(p.getId()).getAmount(),0.0);

    }

    @Test
    void getAllProgettiValutare () {
        progettoService.createProgetto(proponenteProgettoA.getId(),"IoT",10);
        pr=progettoService.createProgetto(proponenteProgettoA.getId(),"UniversalBank",10);
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"Digiworld",10);
        assertEquals(progettoService.getAllProgettiValutare().size(),3);
        progettoService.confirmProgetto(p.getId(),e.getId());
        assertEquals(progettoService.getAllProgettiValutare().size(),2);
        progettoService.declineProgetto(pr.getId(),e.getId());
        assertEquals(progettoService.getAllProgettiValutare().size(),1);
    }

    @Test
    void getCandidati () {
        p=progettoService.createProgetto(proponenteProgettoA.getId(),"UniversalBank",10);
        assertTrue(progettoService.getCandidati(p.getId()).isEmpty());
    }
}
