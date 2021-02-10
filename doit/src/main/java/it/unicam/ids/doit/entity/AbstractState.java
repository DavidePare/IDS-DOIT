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

    public abstract void changeState(Progetto progetto, IState newState);
}
