package it.unicam.ids.doit.service.impl;

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



    @Test
    void createSponsor() {
        assertEquals(sponsorService.getAllSponsors().size(), 0);
        sponsorService.createSponsor("Metisoft");
        assertEquals(sponsorService.getAllSponsors().size(), 1);
        sponsorService.createSponsor("giulia picci ama davide");
        assertEquals(sponsorService.getAllSponsors().size(), 2);
    }

    @Test
    void deleteSponsor() {

        sponsor=sponsorService.createSponsor("Metisoft");
        sp2=sponsorService.createSponsor("giulia picci ama davide");
        assertEquals(sponsorService.getAllSponsors().size(),2);
        sponsorService.deleteSponsor(sponsor.getId());
        assertEquals(sponsorService.getAllSponsors().size(),1);
        sponsorService.deleteSponsor(sp2.getId());
        assertEquals(sponsorService.getAllSponsors().size(),0);

    }

    @Test
    void getSponsor() {

        sponsor=sponsorService.createSponsor("Metisoft");
        sp2=sponsorService.createSponsor("giulia picci ama davide");
        assertEquals(sponsorService.getSponsor(sponsor.getId()).getId(),sponsor.getId());
        assertEquals(sponsorService.getSponsor(sp2.getId()).getId(),sp2.getId());

    }

    @Test
    void getAllSponsors() {

        sponsor=sponsorService.createSponsor("Metisoft");
        assertEquals(sponsorService.getAllSponsors().size(),1);
        sp2=sponsorService.createSponsor("giulia picci ama davide");
        assertEquals(sponsorService.getAllSponsors().size(),2);
    }

    @Test
    void removeProgetto() {

        pr1 = progettoService.createProgetto(1L,"cazzo",3);
        sponsor=sponsorService.createSponsor("Metisoft");

    }

    @Test
    void addAmountProgetto() {

        pr1 = progettoService.createProgetto(1L,"cazzo",3);
        sponsor=sponsorService.createSponsor("Metisoft");
        sp2=sponsorService.createSponsor("Metisoft");
        sponsorService.addAmountProgetto(pr1.getId(),sponsor.getId(),200.0);
        assertEquals(pr1.getAmount(),200.0);
        sponsorService.addAmountProgetto(pr1.getId(),sp2.getId(),200.0);
        assertEquals(pr1.getAmount(),400.0);

    }

    @Test
    void decrementAmountProgetto() {

        pr1 = progettoService.createProgetto(1L,"cazzo",3);
        sponsor=sponsorService.createSponsor("Metisoft");
        sp2=sponsorService.createSponsor("Metisoft");
        sponsorService.addAmountProgetto(pr1.getId(),sponsor.getId(),200.0);

    }

    @Test
    void getProgetti() {

        pr1 = progettoService.createProgetto(1L,"cazzo",3);
        sponsor=sponsorService.createSponsor("Metisoft");
        sponsorService.addAmountProgetto(pr1.getId(),sponsor.getId(),200.0);
        assertTrue(sponsorService.getProgetti(sponsor.getId()).contains(pr1));

    }
}