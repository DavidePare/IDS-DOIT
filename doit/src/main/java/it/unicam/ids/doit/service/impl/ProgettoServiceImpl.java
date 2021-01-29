package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.dao.ProgettoRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Sponsor;
import it.unicam.ids.doit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProgettoServiceImpl implements ProgettoService {

    @Autowired
    private ProgettoRepository progettoRepository;

    @Override
    public Progetto getProgetto(Long id){
        return progettoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Progetto> getAllProgetti() {
        return progettoRepository.findAll();
    }

    @Override
    public void confirmProgetto(Long idProgetto) {
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().confirm();
        //state.confirm();
        progettoRepository.save(progetto);
    }

    @Override
    public void declineProgetto(Long idProgetto) {
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().decline();
        //state.decline();
        progettoRepository.save(progetto);

    }

    @Override
    public void addCandidato(Long idProgetto, Long idProgettista){
        Progetto progetto = getProgetto(idProgetto);
        //Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getState().addCandidato(idProgetto, idProgettista);
        //state.addCandidato(progettista);
        progettoRepository.save(progetto);

    }

    @Override
    public void removeCandidato(Long idProgetto, Long idProgettista) {
        Progetto progetto = getProgetto(idProgetto);
        //Progettista progettista = progettistaService.getProgettista(idProgettista);
        progetto.getState().removeCandidato(idProgetto, idProgettista);
        //state.removeCandidato(p);
        progettoRepository.save(progetto);

    }

    @Override
    public void addSponsor(Long idProgetto, Long idSponsor){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getSponsors().add(idSponsor);
        //sponsors.add(s.getID());
        progettoRepository.save(progetto);
    }

    @Override
    public void removeSponsor(Long idProgetto, Long idSponsor){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getSponsors().remove(idSponsor);
        //sponsors.remove(s.getID());
        progettoRepository.save(progetto);
    }

    @Override
    public void incrementAmount(Long idProgetto, double amount){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().incrementAmount(idProgetto, amount);
        //state.incrementAmount(a);
        progettoRepository.save(progetto);
    }

    @Override
    public void decrementAmount(Long idProgetto, double amount){
        Progetto progetto = getProgetto(idProgetto);
        progetto.getState().decrementAmount(idProgetto, amount);
        //state.decrementAmount(a);
        progettoRepository.save(progetto);
    }
}
