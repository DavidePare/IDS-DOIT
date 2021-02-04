package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;

public class Blocked extends AbstractState{

    @Autowired
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
}
