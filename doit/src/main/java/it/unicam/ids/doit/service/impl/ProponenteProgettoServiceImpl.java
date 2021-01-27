package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.ProponenteProgettoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProponenteProgettoServiceImpl extends ProgettistaServiceImpl implements ProponenteProgettoService {

    private List<ProgettoService> progettiGestiti;

    public ProponenteProgettoServiceImpl(String name, String surname, CurriculumServiceImpl curriculum){
        super(name, surname, curriculum);
        progettiGestiti = new ArrayList<>();
    }

    @Override
    public void addProgettoGestito(ProgettoService p){
        progettiGestiti.add(p);
    }

    @Override
    public void removeProgettoGestito(ProgettoService p){
        progettiGestiti.remove(p);
    }

    @Override
    public void createProgetto(String name,int nMax){
        ProgettoService p = new ProgettoServiceImpl(this.getID(),name,nMax);
        addProgettoGestito(p);
        //il controller farà l aggiunta al gestore dei progetti
    }

    @Override
    public List<ProgettoService> getProgettiGestiti(){
        return progettiGestiti;
    }

    @Override
    public void acceptCandidatura(ProgettoService progetto, ProgettistaService progettista){
        if(progettiGestiti.contains(progetto)&&progetto.getCandidati().contains(progettista.getID())){
            progetto.getTeam().addProgettista(progettista);
            progetto.removeCandidato(progettista);
            progettista.removeprogettoCandidato(progetto);
        }

    }

    @Override
    public void declineCandidatura(ProgettoService progetto, ProgettistaService progettista){
        if(progettiGestiti.contains(progetto) && progetto.getCandidati().contains(progettista.getID())){
            progetto.removeCandidato(progettista);
            progettista.removeprogettoCandidato(progetto);
        }
    }

    @Override
    public void inviteProgettista(ProgettistaService progettista, ProgettoService progetto){
        progettista.addInvito(progetto);
    }
}
