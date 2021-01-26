package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.stereotype.Service;

@Service
public class Approved extends AbstractState {
    ProgettoService progetto;

    public Approved(ProgettoService p){
        this.progetto=p;
    }

    @Override
    public void changeState(IState newState) {
        progetto.setState(newState);
    }

    /**
     * Metodo che permetterà di aggiungere una somma di denaro dentro allo stato del progetto
     * @param amount
     */
    @Override
    public void incrementAmount(double amount){
        progetto.setAmount(progetto.getAmount()+amount);
    }

    /**
     * Metodo che rimuoverà una cifra di denaro dal progetto
     * @param amount
     */
    @Override
    public void decrementAmount(double amount){
        progetto.setAmount(progetto.getAmount()-amount);
    }

    /**
     * Aggiunta del candidato alla lista dei candidati
     * @param progettista
     */
    @Override
    public void addCandidato(ProgettistaService progettista){
        progetto.getCandidati().add(progettista.getID());
    }

    /**
     * Rimozione del candidato dalla lista
     * @param progettista
     */
    @Override
    public void removeCandidato(ProgettistaService progettista){
        progetto.getCandidati().remove(progettista.getID());
    }


}
