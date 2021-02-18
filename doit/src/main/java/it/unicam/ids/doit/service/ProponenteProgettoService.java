package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.ProponenteProgetto;

import java.util.List;

public interface ProponenteProgettoService {

    ProponenteProgetto createProponenteProgetto(String name, String surname);

    void deleteProponenteProgetto(Long idPropProgetto);

    ProponenteProgetto getProponenteProgetto(Long id);

    List<ProponenteProgetto> getAllProponentiProgetto();

    void addProgettoGestito(Long idPropProgetto, Long idProgetto);

    void removeProgettoGestito(Long idPropProgetto, Long idProgetto);

    Progetto createProgetto(Long idPropProgetto, String name, int nMaxProgettisti);

    void acceptCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista);

    void declineCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista);

    void inviteProgettista(Long idPropProgetto,Long idProgetto,Long idProgettista);

    List<Progetto> getProgettiGestiti(Long idPropProgetto);

    void removeProgettistaFromProgetto(Long idPropProgetto,Long idProgetto, Long idProgettista);

    List<Progettista> getComponentOfTeam(Long id, Long idProponente);

    ProponenteProgetto createProponenteProgetto(String name, String surname,String email , String password);

    List<Progettista> getInvitableProgettisti(Long id,Long idProponente);
<<<<<<< Updated upstream
<<<<<<< Updated upstream

    List<Progettista> getCandidatiProgetto(Long idProgetto);
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}
