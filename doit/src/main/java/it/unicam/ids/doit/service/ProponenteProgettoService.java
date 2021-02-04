package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.ProponenteProgetto;

import java.util.List;

public interface ProponenteProgettoService {

    ProponenteProgetto createProponenteProgetto(String name, String surname);

    void deleteProponenteProgetto(Long idPropProgetto);

    ProponenteProgetto getProponenteProgetto(Long id);

    List<ProponenteProgetto> getAllProponentiProgetto();

    void addProgettoGestito(Long idPropProgetto, Long idProgetto);

    void removeProgettoGestito(Long idPropProgetto, Long idProgetto);

    void createProgetto(Long idPropProgetto, String name, int nMaxProgettisti);

    void acceptCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista);

    void declineCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista);

    void inviteProgettista(Long idPropProgetto,Long idProgetto,Long idProgettista);
}
