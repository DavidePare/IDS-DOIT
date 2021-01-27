package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractState implements IState {
    public void confirm(){

    }
    public void decline(){

    }
    public void incrementAmount(double amount){

    }
    public void decrementAmount(double amount){

    }
    public void addCandidato(ProgettistaService progettista){

    }
    public void removeCandidato(ProgettistaService progettista){

    }
    public abstract void changeState(IState newState);
}
