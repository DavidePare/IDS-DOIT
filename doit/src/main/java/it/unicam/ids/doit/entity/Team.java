package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettistaService;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private List<Long> progettistiTeam;

    private Long progettoID;

    public Team(){
        progettistiTeam = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<Long> getProgettistiTeam() {
        return progettistiTeam;
    }

    public void setProgettistiTeam(List<Long> progettistiTeam) {
        this.progettistiTeam = progettistiTeam;
    }

    public Long getProgettoID() {
        return progettoID;
    }

    public void setProgettoID(Long progettoID) {
        this.progettoID = progettoID;
    }
}
