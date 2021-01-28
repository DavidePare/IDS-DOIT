package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.CurriculumRepository;
import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.dao.ProgettoRepository;
import it.unicam.ids.doit.dao.TeamRepository;
import it.unicam.ids.doit.entity.Curriculum;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Team;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProgettistaServiceImpl implements ProgettistaService {

    @Autowired
    private ProgettistaRepository progettistaRepository;

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ProgettoService progettoService;

    @Override
    public Progettista getProgettista(Long id){
        return progettistaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Progettista> getAllProgettisti() {
        return progettistaRepository.findAll();
    }

    @Override
    public List<Curriculum> getCurriculum(){
        return curriculumRepository.findAll();
    }

    @Override
    public void addProgetto(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiProgettista().add(progetto);
        progettistaRepository.save(progettista);

    }

    @Override
    public void removeProgetto(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiProgettista().remove(progetto);
        progettistaRepository.save(progettista);
    }

    @Override
    public void addInvito(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getInviti().add(progetto);
        progettistaRepository.save(progettista);
    }

    @Override
    public void acceptInvito(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        teamService.addProgettista(progetto.getTeam().getId(),idProgettista);
        //p.getTeam().addProgettista(this);
        progettista.getInviti().remove(progetto);
        //inviti.remove(p);
        progettista.getProgettiProgettista().add(progetto);
        //progettiProgettista.add(p);
        progettistaRepository.save(progettista);

    }

    @Override
    public void refuseInvito(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getInviti().remove(progetto);
        //inviti.remove(p);
        progettistaRepository.save(progettista);
    }

    @Override
    public void addprogettoCandidato(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiCandidati().add(progetto.getId());
        //progettiCandidati.add(p.getID());
        progettistaRepository.save(progettista);
    }

    @Override
    public void removeprogettoCandidato(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiCandidati().remove(progetto.getId());
        //progettiCandidati.remove(p.getID());
        progettistaRepository.save(progettista);
    }

    @Override
    public void sendCandidatura(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettoService.addCandidato(idProgetto, idProgettista);
        //progetto.getCandidati().add(progettista.getId());
        progettista.getProgettiCandidati().add(progetto.getId());
        //addprogettoCandidato(p);
        //progettoRepository.save(progetto);
        progettistaRepository.save(progettista);
    }
}
