package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.IState;
import org.springframework.stereotype.Service;

@Service
public class Waiting extends AbstractState {

    ProgettoServiceImpl progetto;

    public Waiting(ProgettoServiceImpl p){
        this.progetto=p;
    }

    @Override
    public void changeState(IState newState) {
        progetto.setState(newState);
    }

    /**
     * Metodo che modificherà lo stato del progetto da stato di waiting ad approved
     */
    public void confirm(){
        this.changeState(new Approved(progetto));
    }

    /**
     * Metodo che modificherà lo stato del progetto da stato di waiting a Blocked
     */
    public void decline(){
        this.changeState(new Blocked(progetto));
    }
}
