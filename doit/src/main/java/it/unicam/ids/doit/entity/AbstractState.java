package it.unicam.ids.doit.entity;

public abstract class AbstractState implements IState {

    @Override
    public void confirm(Long idProgetto){ }

    @Override
    public void decline(Long idProgetto){ }

    @Override
    public void incrementAmount(Long idProgetto, double amount){ }

    @Override
    public void decrementAmount(Long idProgetto, double amount){ }

    @Override
    public void addCandidato(Long idProgetto,Long idProgettista){ }

    @Override
    public void removeCandidato(Long idProgetto,Long idProgettista){ }

    @Override
    public void addInvitoProgettista(Long idProgetto,Long idProgettista){ }

    @Override
    public void removeInvitoProgettista(Long idProgetto,Long idProgettista){ }

    public abstract void changeState(Long idProgetto, IState newState);
}
