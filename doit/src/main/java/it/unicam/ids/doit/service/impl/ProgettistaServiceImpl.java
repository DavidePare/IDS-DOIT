package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgettistaServiceImpl implements ProgettistaService {


    private int id;
    private String name;
    private String surname;
    private CurriculumServiceImpl curriculum;
    private List<ProgettoService> progettiProgettista;
    private List<ProgettoService> inviti;
    private List<Integer> progettiCandidati;

    public ProgettistaServiceImpl(String name, String surname, CurriculumServiceImpl curriculum){
        this.name=name;
        this.surname=surname;
        this.curriculum = curriculum;
        progettiProgettista = new ArrayList<>();
        inviti= new ArrayList<>();
        progettiCandidati= new ArrayList<>();
    }

    @Override
    public int getID(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getSurname(){
        return surname;
    }

    @Override
    public List<ProgettoService> getProgettiProgettista(){
        return progettiProgettista;
    }

    @Override
    public CurriculumServiceImpl getCurriculum(){
        return curriculum;
    }

    @Override
    public void addProgetto(ProgettoService p){
        progettiProgettista.add(p);
    }

    @Override
    public void removeProgetto(ProgettoService p){
        progettiProgettista.remove(p);
    }

    @Override
    public List<ProgettoService> getInviti(){
        return inviti;
    }

    @Override
    public void addInvito(ProgettoService p){
        inviti.add(p);
    }

    @Override
    public void acceptInvito(ProgettoService p){
        p.getTeam().addProgettista(this);
        inviti.remove(p);
        progettiProgettista.add(p);
    }

    @Override
    public void refuseInvito(ProgettoService p){
        inviti.remove(p);
    }

    @Override
    public List<Integer> getprogettiCandidati(){
        return progettiCandidati;
    }

    @Override
    public void addprogettoCandidato(ProgettoService p){
        progettiCandidati.add(p.getID());
    }

    @Override
    public void removeprogettoCandidato(ProgettoService p){
        progettiCandidati.remove(p.getID());
    }

    @Override
    public List<TeamService> getTeamsProgettista() {
        List<TeamService> teams = new ArrayList<>();
        getProgettiProgettista().stream().forEach(p -> teams.add(p.getTeam()));
        return teams;
    }

    @Override
    public void sendCandidatura(ProgettoService p){
        p.addCandidato(this);
        addprogettoCandidato(p);
    }
}
