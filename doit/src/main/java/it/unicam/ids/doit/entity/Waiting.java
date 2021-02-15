package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Transient;

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
