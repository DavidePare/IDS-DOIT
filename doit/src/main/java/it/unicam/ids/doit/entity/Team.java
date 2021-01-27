package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettistaService;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Long id;

    private List<Progettista> progettistiTeam;

    private int progettoID;

    public Team(){
        progettistiTeam = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<Progettista> getProgettistiTeam() {
        return progettistiTeam;
    }

    public void setProgettistiTeam(List<Progettista> progettistiTeam) {
        this.progettistiTeam = progettistiTeam;
    }

    public int getProgettoID() {
        return progettoID;
    }

    public void setProgettoID(int progettoID) {
        this.progettoID = progettoID;
    }
}
