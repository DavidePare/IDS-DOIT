package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.stereotype.Service;

@Service
public class Blocked extends AbstractState {
    ProgettoService progetto;

    public Blocked(ProgettoService p){
        this.progetto=p;
    }

    @Override
    public void changeState(IState newState) {
        progetto.setState(newState);
    }
}
