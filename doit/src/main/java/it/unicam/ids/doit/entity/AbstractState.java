package it.unicam.ids.doit.entity;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractState implements IState{
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    @Override
    public void confirm(Progetto progetto){ }

    @Override
    public void decline(Progetto progetto){ }

    @Override
    public void incrementAmount(Progetto progetto, double amount){ }

    @Override
    public void decrementAmount(Progetto progetto, double amount){ }

    @Override
    public void addCandidato(Progetto progetto,Progettista progettista){ }

    @Override
    public void removeCandidato(Progetto progetto,Progettista progettista){ }

    @Override
    public void addInvitoProgettista(Progetto progetto,Progettista progettista){ }

    @Override
    public void removeInvitoProgettista(Progetto progetto,Progettista progettista){ }

    public abstract void changeState(Progetto progetto, IState newState);
}
