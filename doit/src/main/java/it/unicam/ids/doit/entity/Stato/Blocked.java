package it.unicam.ids.doit.entity.Stato;

import it.unicam.ids.doit.entity.Progetto;

import javax.persistence.Entity;

@Entity
public class Blocked extends AbstractState {



    public Blocked(){ }

    @Override
    public void changeState(Progetto progetto, IState newState) {
      //  Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setState(newState);
    }

    @Override
    public void confirm(Progetto progetto){
        this.changeState(progetto,new Blocked());
    }

    @Override
    public String toString() {
        return "Blocked";
    }
}
