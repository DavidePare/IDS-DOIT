package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="Progetto_Table")
public class Progetto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Progetto")
    private Long id;

    private int nMaxProgettisti;

    //Era messo
    @OneToOne(targetEntity = AbstractState.class,
                cascade= {CascadeType.ALL})
    private IState state;

    private double amount;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Team")
    private Team team;


    private Long espertoId;

    private Date scadenza;

    private Long proponenteProgettoID;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    //@JoinTable(name ="Progettista",
    //        joinColumns=@JoinColumn(name="ID_Progettista"))
    @JsonIgnoreProperties({"progettiCandidati","progettiProgettista","inviti",})
    private List<Progettista> progettistiInvitati;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"progettiCandidati","progettiProgettista","inviti"})
    private List<Progettista> candidati;

    //@Transient
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Sponsor> sponsors;

    public Progetto(){ }

    public Progetto(Long proponenteProgettoID, String name, int nMaxProgettisti){
        this.name=name;
        this.state = new Waiting();
        this.candidati = new ArrayList<>();
        this.team = new Team(getId());
        this.sponsors= new ArrayList<>();
        this.progettistiInvitati = new ArrayList<>();
        this.espertoId = (long)0;
        this.amount=0;
        this.proponenteProgettoID=proponenteProgettoID;
        this.nMaxProgettisti=nMaxProgettisti;
        this.scadenza= new Date();
    }
    public Long getId() {
        return id;
    }
    public int getnMaxProgettisti() {
        return nMaxProgettisti;
    }
    public void setnMaxProgettisti(int nMaxProgettisti) {
        this.nMaxProgettisti = nMaxProgettisti;
    }
    public IState getState() {
        return state;
    }
    public void setState(IState state) {
        this.state = state;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Long getEspertoId() {
        return espertoId;
    }
    public void setEspertoId(Long espertoId) {
        this.espertoId = espertoId;
    }
    public Date getScadenza() {
        return scadenza;
    }
    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }
    public Long getProponenteProgettoID() {
        return proponenteProgettoID;
    }
    public void setProponenteProgettoID(long proponenteProgettoID) {
        this.proponenteProgettoID = proponenteProgettoID;
    }
    public List<Progettista> getCandidati() {
        return candidati;
    }
    public void setCandidati(List<Progettista> candidati) {
        this.candidati = candidati;
    }
    public List<Sponsor> getSponsors() {
        return sponsors;
    }
    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }
    public List<Progettista> getProgettistiInvitati() {
        return progettistiInvitati;
    }
    public void setProgettistiInvitati(List<Progettista> progettistiInvitati) {
        this.progettistiInvitati = progettistiInvitati;
    }
}