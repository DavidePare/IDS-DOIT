package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Waiting extends AbstractState {

    @Autowired
    @Transient
    private ProgettoService progettoService;

    public Waiting(){ }

    @Override
    public void changeState(Long idProgetto, IState newState) {
        Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setState(newState);
    }

    @Override
    public void confirm(Long idProgetto){
        this.changeState(idProgetto,new Approved());
    }

    @Override
    public void decline(Long idProgetto){
        this.changeState(idProgetto,new Blocked());
    }

    @Override
    public String toString() {
        return "Waiting";
    }
}
