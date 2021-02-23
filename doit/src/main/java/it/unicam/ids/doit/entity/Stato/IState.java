package it.unicam.ids.doit.entity.Stato;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;

public interface IState {

    void confirm(Progetto progetto);

    void decline(Progetto progetto);

    void incrementAmount(Progetto progetto, double amount);

    void decrementAmount(Progetto progetto, double amount);

    void addCandidato(Progetto progetto, Progettista progettista);

    void removeCandidato(Progetto progetto,Progettista progettista);

    void addInvitoProgettista(Progetto progetto,Progettista progettista);

    void removeInvitoProgettista(Progetto progetto,Progettista progettista);
}
