package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;

import java.util.List;

public interface ProgettoService {

    Progetto createProgetto(Long proponenteProgettoID, String name, int nMaxProgettisti);

    void deleteProgetto(Long idProgetto);

    Progetto getProgetto(Long id);

    List<Progetto> getAllProgetti();

    void confirmProgetto(Long idProgetto,Long idEsperto);

    void declineProgetto(Long idProgetto,Long idEsperto);

    boolean addCandidato(Long idProgetto, Long idProgettista);

    void removeCandidato(Long idProgetto, Long idProgettista);

    void addProgettistaInvitato(Long idProgetto, Long idProgettista);

    void removeProgettistaInvitato(Long idProgetto, Long idProgettista);

    void addSponsor(Long idProgetto, Long idSponsor);

    void removeSponsor(Long idProgetto, Long idSponsor);

    void addEsperto(Long idProgetto, Long idEsperto);

    void removeEsperto(Long idProgetto);

    void removeTeam(Long idProgetto);

    void incrementAmount(Long idProgetto, double amount);

    void decrementAmount(Long idProgetto, double amount);

    List<Progetto> getAllProgettiValutare();


    List<Progettista> getCandidati(Long idProgetto);
}
