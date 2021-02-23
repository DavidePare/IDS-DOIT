package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.ids.doit.entity.Sponsor.Sponsor;
import it.unicam.ids.doit.entity.Stato.AbstractState;
import it.unicam.ids.doit.entity.Stato.IState;
import it.unicam.ids.doit.entity.Stato.Waiting;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Progetto_Table")
public class Progetto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Progetto")
    private Long id;

    private int nMaxProgettisti;

    @OneToOne(targetEntity = AbstractState.class,
                cascade= {CascadeType.ALL})
    private IState state;

    private String nState;



    private double amount;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Team")
    private Team team;


    private Long espertoId;

    private LocalDate scadenza;

    private Long proponenteProgettoID;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"progettiCandidati","progettiProgettista","inviti",})
    private List<Progettista> progettistiInvitati;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"progettiCandidati","progettiProgettista","inviti"})
    private List<Progettista> candidati;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Sponsor> sponsors;

    public Progetto(){ }

    public Progetto(Long proponenteProgettoID, String name, int nMaxProgettisti){
        this.name=name;
        this.state = new Waiting();
        this.candidati = new ArrayList<>();
        this.team = new Team(getId());
        this.team.setProgettoID(getId());
        this.nState = state.toString();
        this.sponsors= new ArrayList<>();
        this.progettistiInvitati = new ArrayList<>();
        this.espertoId = (long)0;
        this.amount=0;
        this.proponenteProgettoID=proponenteProgettoID;
        this.nMaxProgettisti=nMaxProgettisti;
        this.scadenza= LocalDate.now().plusYears(3);
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
    public LocalDate getScadenza() {
        return scadenza;
    }
    public void setScadenza(LocalDate scadenza) {
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

    public String getnState() {
        return state.toString();
    }

    public void setnState(String nState) {
        this.nState = state.toString();
    }

    public void setProponenteProgettoID(Long proponenteProgettoID) {
        this.proponenteProgettoID = proponenteProgettoID;
    }
}