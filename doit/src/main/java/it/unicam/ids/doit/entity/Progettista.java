package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.ids.doit.entity.Curriculum.Curriculum;
import it.unicam.ids.doit.entity.Notifiche.NotificationMessage;
import it.unicam.ids.doit.entity.Notifiche.Subscribe;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.lang.Long;
import java.util.Set;

@Entity
@Table(name="Progettista_Table")
@Inheritance(strategy = InheritanceType.JOINED)
public class Progettista implements Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Progettista")
    private Long id;

    private String name;

    private String surname;

    @Column(nullable= false, unique=true)
    private String email;

    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"candidati","progettistiInvitati","sponsor"})
    private List<Progetto> progettiCandidati;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Curriculum curriculum;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"candidati","progettistiInvitati","sponsor"})
    private List<Progetto> progettiProgettista;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"candidati","progettistiInvitati","sponsor"})
    private List<Progetto> inviti;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Team> teamsProgettista;




    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<NotificationMessage> messaggeBacheca;


    public Progettista(){ }

    public Progettista(String name, String surname){
        this.name=name;
        this.surname=surname;
        this.curriculum=null;
        this.progettiProgettista = new ArrayList<>();
        this.teamsProgettista = new ArrayList<>();
        this.inviti= new ArrayList<>();
        this. messaggeBacheca= new HashSet<>();
        progettiCandidati= new ArrayList<>();
    }

    public Progettista(String name, String surname,String email, String password){
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
        this.curriculum=null;
        this.progettiProgettista = new ArrayList<>();
        this.teamsProgettista = new ArrayList<>();
        this.inviti= new ArrayList<>();
        this. messaggeBacheca= new HashSet<>();
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

    public void addCurriculum(Long idProgettista,String instruction,String formation,Long phone,String email){
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

    public void notify(String message,String name, Long id){
        messaggeBacheca.add(new NotificationMessage(message,name,id));
    }

    public Set<NotificationMessage>  getMessaggeBacheca() {
        return messaggeBacheca;
    }

    public void setMessaggeBacheca(Set<NotificationMessage> messaggeBacheca) {
        this.messaggeBacheca.addAll(messaggeBacheca);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurriculum(Curriculum c){
        this.curriculum=c;

    }
}
