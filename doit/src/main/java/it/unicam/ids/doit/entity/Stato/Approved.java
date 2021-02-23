package it.unicam.ids.doit.entity.Stato;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;

import javax.persistence.Entity;

@Entity
public class Approved extends AbstractState {




    @Override
    public void changeState(Progetto progetto, IState newState) {
       // Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setState(newState);
    }

    @Override
    public void decline(Progetto progetto){
        this.changeState(progetto,new Blocked());
    }

    /**
     * Metodo che permetterà di aggiungere una somma di denaro dentro allo stato del progetto
     * @param progetto
     * @param amount
     */
    @Override
    public void incrementAmount(Progetto progetto, double amount){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setAmount(progetto.getAmount()+amount);
    }

    /**
     * Metodo che rimuoverà una cifra di denaro dal progetto
     * @param progetto
     * @param amount
     */
    @Override
    public void decrementAmount(Progetto progetto, double amount){
       // Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setAmount(progetto.getAmount()-amount);
    }

    /**
     * Aggiunta del candidato alla lista dei candidati
     * @param progetto
     * @param progettista
     */
    @Override
    public void addCandidato(Progetto progetto, Progettista progettista){
       // Progetto progetto = progettoService.getProgetto(idProgetto);
       // Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getCandidati().add(progettista);
    }

    /**
     * Rimozione del candidato dalla lista
     * @param progetto
     * @param progettista
     */
    @Override
    public void removeCandidato(Progetto progetto,Progettista progettista){
        progetto.getCandidati().removeIf(p -> p.getId().equals(progettista.getId()));
    }

    @Override
    public void addInvitoProgettista(Progetto progetto,Progettista progettista){
       // Progetto progetto = progettoService.getProgetto(idProgetto);
      //  Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getProgettistiInvitati().add(progettista);
    }

    @Override
    public void removeInvitoProgettista(Progetto progetto,Progettista progettista){
       // Progetto progetto = progettoService.getProgetto(idProgetto);
      //  Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getProgettistiInvitati().removeIf(p -> p.getId().equals(progettista.getId()));
    }


    @Override
    public String toString() {
        return "Accepted";
    }
}
