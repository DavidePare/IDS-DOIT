package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Sponsor;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;

import java.util.List;
import java.util.Map;

public interface SponsorService {

    Sponsor getSponsor(Long id);

    List<Sponsor> getAllSponsors();

    void addAmountProgetto(Long idProgetto, Long idSponsor, double amount);

    void decrementAmountProgetto(Long idProgetto, Long idSponsor, double amount);
}
