package it.unicam.ids.doit.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;

@Entity
public class Progettista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @ElementCollection
    private List<Long> progettiCandidati;

    @OneToOne
    private Curriculum curriculum;

    @OneToMany
    private List<Progetto> progettiProgettista;

    @OneToMany
    private List<Progetto> inviti;

    @ElementCollection
    private List<Long> teamsProgettista;


    public Progettista(){ }

    public Progettista(String name, String surname){
        this.name=name;
        this.surname=surname;
        this.curriculum=null;
        this.progettiProgettista = new ArrayList<>();
        this.teamsProgettista = new ArrayList<>();
        this.inviti= new ArrayList<>();
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

    public List<Long> getProgettiCandidati() {
        return progettiCandidati;
    }

    public void setProgettiCandidati(List<Long> progettiCandidati) {
        this.progettiCandidati = progettiCandidati;
    }

    public Curriculum getCurriculum(){
        return curriculum;
    }

    public void addCurriculum(Long idProgettista,String instruction,String formation,int phone,String email){
        this.curriculum = new Curriculum(idProgettista,instruction,formation,phone,email);
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

    public List<Long> getTeamsProgettista() {
        return teamsProgettista;
    }

    public void setTeamsProgettista(List<Long> teamsProgettista) {
        this.teamsProgettista = teamsProgettista;
    }
}
