package it.unicam.ids.doit.entity;

public interface IState {

    void confirm(Long idProgetto);

    void decline(Long idProgetto);

    void incrementAmount(Long idProgetto, double amount);

    void decrementAmount(Long idProgetto, double amount);

    void addCandidato(Long idProgetto,Long idProgettista);

    void removeCandidato(Long idProgetto,Long idProgettista);

    void addInvitoProgettista(Long idProgetto,Long idProgettista);

    void removeInvitoProgettista(Long idProgetto,Long idProgettista);
}
