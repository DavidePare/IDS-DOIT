package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProgettoRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Approved extends AbstractState {

    @Autowired
    private ProgettoRepository progettoRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private ProgettistaService progettistaService;

    //Progetto progetto;

    /*public Approved(Progetto p){
        this.progetto=p;
    }*/

    @Override
    public void changeState(Long idProgetto, IState newState) {
        Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setState(newState);
        progettoRepository.save(progetto);
    }

    /**
     * Metodo che permetterà di aggiungere una somma di denaro dentro allo stato del progetto
     * @param idProgetto
     * @param amount
     */
    @Override
    public void incrementAmount(Long idProgetto, double amount){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setAmount(progetto.getAmount()+amount);
    }

    /**
     * Metodo che rimuoverà una cifra di denaro dal progetto
     * @param idProgetto
     * @param amount
     */
    @Override
    public void decrementAmount(Long idProgetto, double amount){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setAmount(progetto.getAmount()-amount);
    }

    /**
     * Aggiunta del candidato alla lista dei candidati
     * @param idProgetto
     * @param idProgettista
     */
    @Override
    public void addCandidato(Long idProgetto,Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getCandidati().add(progettista.getId());
    }

    /**
     * Rimozione del candidato dalla lista
     * @param idProgetto
     * @param idProgettista
     */
    @Override
    public void removeCandidato(Long idProgetto,Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getCandidati().remove(progettista.getId());
    }


}
