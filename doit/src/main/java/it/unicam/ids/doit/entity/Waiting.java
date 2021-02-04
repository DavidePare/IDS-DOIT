package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;

public class Waiting extends AbstractState {

    @Autowired
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

}
