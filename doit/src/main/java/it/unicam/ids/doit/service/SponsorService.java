package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Sponsor;

import java.util.List;

public interface SponsorService {

    Sponsor createSponsor(String name);

    void deleteSponsor(Long idSponsor);

    Sponsor getSponsor(Long id);

    List<Sponsor> getAllSponsors();

    void removeProgetto(Long idProgetto, Long idSponsor);

    void addAmountProgetto(Long idProgetto, Long idSponsor, double amount);

    void decrementAmountProgetto(Long idProgetto, Long idSponsor, double amount);
}