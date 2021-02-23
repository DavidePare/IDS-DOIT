package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.SponsorD.Sponsor;

import java.util.List;

public interface SponsorService {

    Sponsor createSponsor(String name);

    void deleteSponsor(Long idSponsor);

    Sponsor getSponsor(Long id);

    List<Sponsor> getAllSponsors();

    void removeProgetto(Long idProgetto, Long idSponsor);

    void addAmountProgetto(Long idProgetto, Long idSponsor, double amount);

    void decrementAmountProgetto(Long idProgetto, Long idSponsor, double amount);

    List<Progetto> getProgetti(Long idSponsor);

    Sponsor createSponsor(String name,String email, String password);
}
