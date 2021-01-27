package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.TeamService;
import it.unicam.ids.doit.service.impl.TeamServiceImpl;
import it.unicam.ids.doit.service.impl.Waiting;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Progetto {

    @Id
    @GeneratedValue
    private Long id;

    private int nMaxProgettisti;

    private IState state;

    private double amount;

    private String name;

    private Team team;

    private Date scadenza;

    private int proponenteProgettoID;

    private List<Long> candidati;

    private List<Long> sponsors;

    public Progetto(int proponenteProgettoID, String name, int nMaxProgettisti){
        this.name=name;
        this.state = new Waiting(this);
        this.candidati = new ArrayList<>();
        this.team = new Team();
        this.sponsors= new ArrayList<>();
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

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public int getProponenteProgettoID() {
        return proponenteProgettoID;
    }

    public void setProponenteProgettoID(int proponenteProgettoID) {
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

}
