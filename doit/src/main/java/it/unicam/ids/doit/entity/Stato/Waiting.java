package it.unicam.ids.doit.entity.Stato;

import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Stato.AbstractState;
import it.unicam.ids.doit.entity.Stato.Approved;
import it.unicam.ids.doit.entity.Stato.Blocked;
import it.unicam.ids.doit.entity.Stato.IState;

import javax.persistence.Entity;

@Entity
public class Waiting extends AbstractState {


    public Waiting(){ }

    @Override
    public void changeState(Progetto progetto, IState newState) {
        progetto.setState(newState);
    }

    @Override
    public void confirm(Progetto progetto){
        this.changeState(progetto,new Approved());
    }

    @Override
    public void decline(Progetto progetto){
        this.changeState(progetto,new Blocked());
    }

    @Override
    public String toString() {
        return "Waiting";
    }
}
