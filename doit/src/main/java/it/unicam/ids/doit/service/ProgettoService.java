package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.SponsorServiceImpl;
import it.unicam.ids.doit.service.impl.TeamServiceImpl;

import java.util.Date;
import java.util.List;

public interface ProgettoService {

    Progetto getProgetto(Long id);

    List<Progetto> getAllProgetti();

    void confirmProgetto(Long idProgetto);

    void declineProgetto(Long idProgetto);

    void addCandidato(Long idProgetto, Long idProgettista);

    void removeCandidato(Long idProgetto, Long idProgettista);

    void addSponsor(Long idProgetto, Long idSponsor);

    void removeSponsor(Long idProgetto, Long idSponsor);

    void incrementAmount(Long idProgetto, double amount);

    void decrementAmount(Long idProgetto, double amount);

}
