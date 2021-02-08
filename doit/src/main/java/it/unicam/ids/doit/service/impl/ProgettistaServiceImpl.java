package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProgettistaRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Team;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProgettistaServiceImpl implements ProgettistaService {

    @Autowired
    private ProgettistaRepository progettistaRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private TeamService teamService;

    @Override
    public Progettista createProgettista(String name, String surname){
        Progettista p=new Progettista(name,surname);
        progettistaRepository.save(p);
        return p;
    }

    @Override
    public void deleteProgettista(Long idProgettista){
        Progettista p = getProgettista(idProgettista);
        if(!p.getInviti().isEmpty()) p.getInviti().forEach(pr -> progettoService.removeProgettistaInvitato(pr.getId(),idProgettista));
        if(!p.getProgettiCandidati().isEmpty()) p.getProgettiCandidati().
                forEach(pc -> progettoService.removeCandidato(pc,idProgettista));
        if(!p.getTeamsProgettista().isEmpty()) p.getTeamsProgettista().
                forEach(t -> teamService.removeProgettista(t,idProgettista));
        progettistaRepository.delete(p);
    }

    @Override
    public Progettista getProgettista(Long id){
        return progettistaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Progettista> getAllProgettisti(){
        return progettistaRepository.findAll();
    }

    @Override
    public void addWorkingExperience(Long id,String experience){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getWorkingExperience();
            appoggio.add(experience);
            progettista.getCurriculum().setWorkingExperience(appoggio);
            progettistaRepository.save(progettista);
        }
    }

    @Override
    public void removeWorkingExperience(Long id,String experience){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getWorkingExperience();
            appoggio.remove(experience);
            progettista.getCurriculum().setWorkingExperience(appoggio);
            progettistaRepository.save(progettista);
        }
    }

    @Override
    public void addLanguages(Long id,String language){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getLanguages();
            appoggio.add(language);
            progettista.getCurriculum().setLanguages(appoggio);
            progettistaRepository.save(progettista);
        }
    }

    @Override
    public void removeLanguages(Long id,String language){
        Progettista progettista = progettistaRepository.findById(id).orElseThrow(null);
        if(progettista!=null) {
            List<String> appoggio = progettista.getCurriculum().getLanguages();
            appoggio.remove(language);
            progettista.getCurriculum().setLanguages(appoggio);
            progettistaRepository.save(progettista);
        }
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
        progettista.getInviti().remove(progetto);
        progettista.getProgettiProgettista().add(progetto);
        progettistaRepository.save(progettista);

    }

    @Override
    public void refuseInvito(Long idProgetto, Long idProgettista){
        Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getInviti().remove(progetto);
        progettistaRepository.save(progettista);
    }

    @Override
    public void addTeam(Long idProgettista, Long idTeam){
        Progettista progettista = getProgettista(idProgettista);
        progettista.getTeamsProgettista().add(idTeam);
        progettistaRepository.save(progettista);

    }

    @Override
    public void removeTeam(Long idProgettista, Long idTeam){
        Progettista progettista = getProgettista(idProgettista);
        progettista.getTeamsProgettista().remove(idTeam);
        progettistaRepository.save(progettista);
    }

    @Override
    public void addprogettoCandidato(Long idProgetto, Long idProgettista){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiCandidati().add(idProgetto);
        progettistaRepository.save(progettista);
    }

    @Override
    public void removeprogettoCandidato(Long idProgetto, Long idProgettista){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettista.getProgettiCandidati().remove(idProgetto);
        progettistaRepository.save(progettista);
    }

    @Override
    public void sendCandidatura(Long idProgetto, Long idProgettista){
        //Progetto progetto = progettoService.getProgetto(idProgetto);
        Progettista progettista = getProgettista(idProgettista);
        progettoService.addCandidato(idProgetto, idProgettista);
        progettista.getProgettiCandidati().add(idProgetto);
        progettistaRepository.save(progettista);
    }
}
