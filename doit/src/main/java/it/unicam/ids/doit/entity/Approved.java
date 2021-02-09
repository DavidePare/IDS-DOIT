package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.dao.ProgettoRepository;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Approved extends AbstractState {

    @Autowired
    @Transient
    private ProgettoService progettoService;

    @Autowired
    @Transient
    private ProgettistaService progettistaService;

    @Override
    public void changeState(Long idProgetto, IState newState) {
        Progetto progetto = progettoService.getProgetto(idProgetto);
        progetto.setState(newState);
    }

    @Override
    public void decline(Long idProgetto){
        this.changeState(idProgetto,new Blocked());
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

    @Override
    public void addInvitoProgettista(Long idProgetto,Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getProgettistiInvitati().add(progettista.getId());
    }

    @Override
    public void removeInvitoProgettista(Long idProgetto,Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getProgettistiInvitati().remove(progettista.getId());
    }


    @Override
    public String toString() {
        return "Accepted";
    }
}
