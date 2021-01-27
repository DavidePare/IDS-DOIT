package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.stereotype.Service;

@Service
public class Blocked extends AbstractState {
    Progetto progetto;

    public Blocked(Progetto p){
        this.progetto=p;
    }

    @Override
    public void changeState(IState newState) {
        progetto.setState(newState);
    }
}
