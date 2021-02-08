package it.unicam.ids.doit.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Progetto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int nMaxProgettisti;

    @OneToOne(targetEntity = AbstractState.class,
                cascade= {CascadeType.ALL})
    private IState state;

    private double amount;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Team team;

    private Long espertoId;

    private Date scadenza;

    private Long proponenteProgettoID;

    @ElementCollection
    private List<Long> progettistiInvitati;

    //metterei Progettisti invece di Long perchè al ritorno fa comodo vederli
    @ElementCollection
    private List<Long> candidati;

    @ElementCollection
    private List<Long> sponsors;

    public Progetto(){ }

    public Progetto(Long proponenteProgettoID, String name, int nMaxProgettisti){
        this.name=name;
        this.state = new Waiting();
        this.candidati = new ArrayList<>();
        this.team = new Team();
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
    public List<Long> getCandidati() {
        return candidati;
    }
    public void setCandidati(List<Long> candidati) {
        this.candidati = candidati;
    }
    public List<Long> getSponsors() {
        return sponsors;
    }
    public void setSponsors(List<Long> sponsors) {
        this.sponsors = sponsors;
    }
    public List<Long> getProgettistiInvitati() {
        return progettistiInvitati;
    }
    public void setProgettistiInvitati(List<Long> progettistiInvitati) {
        this.progettistiInvitati = progettistiInvitati;
    }
}