package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractState implements IState {

    @Override
    public void confirm(){ }

    @Override
    public void decline(){ }

    @Override
    public void incrementAmount(Long idProgetto, double amount){ }

    @Override
    public void decrementAmount(Long idProgetto, double amount){ }

    @Override
    public void addCandidato(Long idProgetto,Long idProgettista){ }

    @Override
    public void removeCandidato(Long idProgetto,Long idProgettista){ }

    public abstract void changeState(Long idProgetto, IState newState);
}
