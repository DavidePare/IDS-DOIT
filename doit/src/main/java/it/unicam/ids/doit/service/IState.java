package it.unicam.ids.doit.service;

public interface IState {

    void confirm();
    void decline();
    void incrementAmount(double amount);
    void decrementAmount(double amount);
    void addCandidato(ProgettistaService progettista);
    void removeCandidato(ProgettistaService progettista);

}
