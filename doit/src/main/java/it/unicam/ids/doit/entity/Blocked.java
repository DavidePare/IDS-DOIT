package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Blocked extends AbstractState{

    @Autowired
    @Transient
    private ProgettoService progettoService;

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
