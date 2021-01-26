package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProgettoServiceImpl implements ProgettoService {

    private int id;

    private int nMaxProgettisti;

    private IState state;

    private double amount;

    private String name;

    private TeamService team;

    private Date scadenza;

    private int proponenteProgettoID;

    private List<Integer> candidati;

    private List<Integer> sponsors;
    public ProgettoServiceImpl(int proponenteProgettoID, String name, int nMaxProgettisti){
        this.name=name;
        this.state = new Waiting(this);
        this.candidati = new ArrayList<Integer>();
        this.team = new TeamServiceImpl();
        this.sponsors= new ArrayList<>();
        this.amount=0;
        this.proponenteProgettoID=proponenteProgettoID;
        this.nMaxProgettisti=nMaxProgettisti;
        this.scadenza= new Date();
    }

    @Override
    public int getID(){
        return id;
    }

    @Override
    public int getProponenteProgetto() {
        return proponenteProgettoID;
    }

    @Override
    public IState getState(){
        return state;
    }

    @Override
    public void confirmProgetto() {
        /*state = true;*/
        state.confirm();
    }

    @Override
    public void declineProgetto() {
        /*state = false;*/
        state.decline();
    }

    @Override
    public TeamService getTeam(){
        return team;
    }

    @Override
    public Date getScadenza(){
        return scadenza;
    }

    @Override
    public void addCandidato(ProgettistaService p){
        //candidati.add(p);
        state.addCandidato(p);
    }

    @Override
    public void removeCandidato(ProgettistaService p) {
        //candidati.remove(p);
        state.removeCandidato(p);
    }

    /*public Progettista getSingleCandidato(int ID){
        return candidati.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }*/
    @Override
    public List<Integer> getCandidati(){
        return candidati;
    }

    @Override
    public void addSponsor(SponsorService s){
        sponsors.add(s.getID());
    }

    @Override
    public void removeSponsor(SponsorService s){
        sponsors.remove(s.getID());
    }

    @Override
    public void setState(IState state){ this.state=state;}

    @Override
    public void setAmount(double amount){ this.amount=amount;}

    @Override
    public double getAmount(){ return this.amount;}

    @Override
    public void incrementAmount(double a){
        state.incrementAmount(a);
    }

    @Override
    public void decrementAmount(double a){
        state.decrementAmount(a);
    }
}
