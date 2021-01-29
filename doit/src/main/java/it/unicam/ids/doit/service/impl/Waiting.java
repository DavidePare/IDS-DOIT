package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.stereotype.Service;

@Service
public class Waiting extends AbstractState {

    Progetto progetto;

    public Waiting(Progetto p){
        this.progetto=p;
    }

    @Override
    public void changeState(Long idProgetto, IState newState) {

    }

    /*@Override
    public void changeState(IState newState) {
        progetto.setState(newState);
    }


    public void confirm(){
        this.changeState(new Approved(progetto));
    }


    public void decline(){
        this.changeState(new Blocked(progetto));
    }*/
}
