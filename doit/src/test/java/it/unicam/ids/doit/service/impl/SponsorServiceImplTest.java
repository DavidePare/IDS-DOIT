package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.Esperto;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Sponsor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SponsorServiceImplTest {

    Sponsor sponsor,sp2;
    Progetto pr1,pr2;
    @Autowired
    SponsorServiceImpl sponsorService;
    @Autowired
    ProgettoServiceImpl progettoService;
    @Autowired
    EspertoServiceImpl espertoService;



    @Test
    void createSponsor() {
        assertEquals(sponsorService.getAllSponsors().size(), 0);
        sponsorService.createSponsor("Metisoft","a","a");
        assertEquals(sponsorService.getAllSponsors().size(), 1);
        sponsorService.createSponsor("ppp","qq","qq");
        assertEquals(sponsorService.getAllSponsors().size(), 2);
    }

    @Test
    void deleteSponsor() {

        sponsor=sponsorService.createSponsor("Metisoft","q","q");
        sp2=sponsorService.createSponsor("gi","qq","q");
        assertEquals(sponsorService.getAllSponsors().size(),2);
        sponsorService.deleteSponsor(sponsor.getId());
        assertEquals(sponsorService.getAllSponsors().size(),1);
        sponsorService.deleteSponsor(sp2.getId());
        assertEquals(sponsorService.getAllSponsors().size(),0);

    }

    @Test
    void getSponsor() {

        sponsor=sponsorService.createSponsor("Metisoft","max","");
        sp2=sponsorService.createSponsor("dddd","qqqq","a");
        assertEquals(sponsorService.getSponsor(sponsor.getId()).getId(),sponsor.getId());
        assertEquals(sponsorService.getSponsor(sp2.getId()).getId(),sp2.getId());

    }

    @Test
    void getAllSponsors() {

        sponsor=sponsorService.createSponsor("Metisoft","e","q");
        assertEquals(sponsorService.getAllSponsors().size(),1);
        sp2=sponsorService.createSponsor("gae","qq","q");
        assertEquals(sponsorService.getAllSponsors().size(),2);
    }

    @Test
    void removeProgetto() {
        Esperto e=espertoService.createEsperto(" "," "," a"," ");
        pr1 = progettoService.createProgetto(1L,"prop",3);
        sponsor=sponsorService.createSponsor("qqq","qqq","");
        progettoService.confirmProgetto(pr1.getId(),e.getId());
        sponsorService.addAmountProgetto(pr1.getId(),sponsor.getId(),200.0);
        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),200.0);
        sponsorService.removeProgetto(pr1.getId(),sponsor.getId());
        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),0.0);
        assertTrue(sponsorService.getSponsor(sponsor.getId()).getProgettiInv().isEmpty());

    }

    @Test
    void addAmountProgetto() {
        Esperto e= espertoService.createEsperto("a","b","ss","");
        pr1 = progettoService.createProgetto(1L,"qqq",3);
        progettoService.confirmProgetto(pr1.getId(),e.getId());
        sponsor=sponsorService.createSponsor("Metisoft","aa","");
        sp2=sponsorService.createSponsor("Metisoft","qq"," ");
        sponsorService.addAmountProgetto(pr1.getId(),sponsor.getId(),200.0);
        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),200.0);
        sponsorService.addAmountProgetto(pr1.getId(),sp2.getId(),200.0);
        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),400.0);

    }

    @Test
    void decrementAmountProgetto() {
        Esperto e= espertoService.createEsperto("a","b","ss","");
        pr1 = progettoService.createProgetto(1L,"ccc",3);

        progettoService.confirmProgetto(pr1.getId(),e.getId());
        sponsor=sponsorService.createSponsor("Metisoft","qq","q");
        sponsorService.decrementAmountProgetto(pr1.getId(),sponsor.getId(),100.0);

        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),0.0);
        sp2=sponsorService.createSponsor("Metisoft","aa","");
        sponsorService.addAmountProgetto(pr1.getId(),sponsor.getId(),200.0);

        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),200.0);
        sponsorService.decrementAmountProgetto(pr1.getId(),sponsor.getId(),100.0);

        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),100.0);

        sponsorService.decrementAmountProgetto(pr1.getId(),sponsor.getId(),102.0);

        assertEquals(progettoService.getProgetto(pr1.getId()).getAmount(),100.0);

    }

    @Test
    void getProgetti() {

        pr1 = progettoService.createProgetto(1L,"aaa",3);
        sponsor=sponsorService.createSponsor("Metisoft","qq","");
        sponsorService.addAmountProgetto(pr1.getId(),sponsor.getId(),200.0);
        assertTrue(sponsorService.getProgetti(sponsor.getId()).size()==1);

    }
}