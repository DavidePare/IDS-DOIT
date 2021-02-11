package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.Long;
import java.util.stream.Collectors;

@Entity
@Table(name="Progettista_Table")
@Inheritance(strategy = InheritanceType.JOINED)
public class Progettista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Progettista")
    private Long id;

    private String name;

    private String surname;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
  //  @JsonIgnore()
    @JsonIgnoreProperties({"candidati","progettistiInvitati","sponsor"})
    private List<Progetto> progettiCandidati;

   // @Transient
    @OneToOne
    private Curriculum curriculum;

    @Transient
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"candidati","progettistiInvitati","sponsor"})
    private List<Progetto> progettiProgettista;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"candidati","progettistiInvitati","sponsor"})
    private List<Progetto> inviti;

    @Transient
  //  @ElementCollection
    private List<Team> teamsProgettista;


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

    public List<Progetto> getProgettiCandidati() {
        return progettiCandidati;
    }

    public void setProgettiCandidati(List<Progetto> progettiCandidati) {
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

    public List<Team> getTeamsProgettista() {
        return teamsProgettista;
    }

    public void setTeamsProgettista(List<Team> teamsProgettista) {
        this.teamsProgettista = teamsProgettista;
    }
}
