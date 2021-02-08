package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.ProponenteProgettoRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.ProponenteProgetto;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.ProponenteProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProponenteProgettoServiceImpl implements ProponenteProgettoService {

    @Autowired
    private ProponenteProgettoRepository propProgRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ProgettistaService progettistaService;

    @Override
    public ProponenteProgetto createProponenteProgetto(String name, String surname){
        ProponenteProgetto prop =new ProponenteProgetto(name,surname);
        propProgRepository.save(prop);
        return prop;
    }

    @Override
    public void deleteProponenteProgetto(Long idPropProgetto){
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        if(!prop.getProgettiGestiti().isEmpty()) prop.getProgettiGestiti().
                forEach(p -> progettoService.deleteProgetto(p));
        propProgRepository.delete(prop);
    }

    @Override
    public ProponenteProgetto getProponenteProgetto(Long id){
        return propProgRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<ProponenteProgetto> getAllProponentiProgetto() {
        return propProgRepository.findAll();
    }

    @Override
    public void addProgettoGestito(Long idPropProgetto, Long idProgetto) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        prop.getProgettiGestiti().add(idProgetto);
        propProgRepository.save(prop);
    }

    @Override
    public void removeProgettoGestito(Long idPropProgetto, Long idProgetto) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        prop.getProgettiGestiti().remove(idProgetto);
        propProgRepository.save(prop);
    }

    @Override
    public void createProgetto(Long idPropProgetto, String name, int nMaxProgettisti) {
        Progetto p = progettoService.createProgetto(idPropProgetto,name,nMaxProgettisti);
        addProgettoGestito(idPropProgetto,p.getId());
    }

    @Override
    public void acceptCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progetto p = progettoService.getProgetto(idProgetto);
        if(prop.getProgettiGestiti().contains(idProgetto) && p.getCandidati().contains(idProgettista)){
            //progetto.getTeam().addProgettista(progettista);
            teamService.addProgettista(p.getTeam().getId(),idProgettista);
            progettistaService.addTeam(idProgettista,p.getTeam().getId());
            //progetto.removeCandidato(progettista);
            progettoService.removeCandidato(idProgetto,idProgettista);
            //progettista.removeprogettoCandidato(progetto);
            progettistaService.removeprogettoCandidato(idProgetto,idProgettista);
        }
    }

    @Override
    public void declineCandidatura(Long idPropProgetto,Long idProgetto,Long idProgettista) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        Progetto p = progettoService.getProgetto(idProgetto);
        if(prop.getProgettiGestiti().contains(idProgetto) && p.getCandidati().contains(idProgettista)){
            progettoService.removeCandidato(idProgetto,idProgettista);
            progettistaService.removeprogettoCandidato(idProgetto,idProgettista);
        }
    }

    @Override
    public void inviteProgettista(Long idPropProgetto,Long idProgetto,Long idProgettista) {
        ProponenteProgetto prop = getProponenteProgetto(idPropProgetto);
        if(prop.getProgettiGestiti().contains(idProgetto)){
            progettistaService.addInvito(idProgetto,idProgettista);
        }
    }
}
