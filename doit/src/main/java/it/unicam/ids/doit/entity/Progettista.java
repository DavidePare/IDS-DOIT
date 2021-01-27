package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Progettista {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private Curriculum curriculum;

    private List<Progetto> progettiProgettista;

    private List<Progetto> inviti;

    private List<Long> progettiCandidati;

    public Progettista(String name, String surname, Curriculum curriculum){
        this.name=name;
        this.surname=surname;
        this.curriculum=curriculum;
        progettiProgettista = new ArrayList<>();
        inviti= new ArrayList<>();
        progettiCandidati= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public List<Progetto> getProgettiProgettista() {
        return progettiProgettista;
    }

    public void setProgettiProgettista(List<Progetto> progettiProgettista) {
        this.progettiProgettista = progettiProgettista;
    }

    public List<Progetto> getInviti() {
        return inviti;
    }

    public void setInviti(List<Progetto> inviti) {
        this.inviti = inviti;
    }

    public List<Long> getProgettiCandidati() {
        return progettiCandidati;
    }

    public void setProgettiCandidati(List<Long> progettiCandidati) {
        this.progettiCandidati = progettiCandidati;
    }

    public List<Team> getTeamsProgettista() {
        List<Team> teams = new ArrayList<>();
        getProgettiProgettista().stream().forEach(p -> teams.add(p.getTeam()));
        return teams;
    }
}
