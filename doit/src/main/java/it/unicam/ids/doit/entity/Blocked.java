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
    public void changeState(Long idProgetto, IState newState) {
        Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setState(newState);
    }

    @Override
    public void decline(Long idProgetto){
        this.changeState(idProgetto,new Blocked());
    }

    @Override
    public String toString() {
        return "Blocked";
    }
}
