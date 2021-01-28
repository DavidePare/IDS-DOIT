package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progettista;

public interface IState {

    void confirm();
    void decline();
    void incrementAmount(Long idProgetto, double amount);
    void decrementAmount(Long idProgetto, double amount);
    void addCandidato(Long idProgetto,Long idProgettista);
    void removeCandidato(Long idProgetto,Long idProgettista);

}
