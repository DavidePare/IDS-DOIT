package it.unicam.ids.doit.service;

import it.unicam.ids.doit.service.impl.*;

import java.util.List;

public class Controller{
    GestoreProgettoServiceImpl gestoreProgettoServiceImpl;
    GestoreProgettistaServiceImpl gestoreProgettistaServiceImpl;
    GestoreEspertoServiceImpl gestoreEspertoServiceImpl;
    GestoreSponsorServiceImpl gestoreSponsorServiceImpl;
    GestoreTeamServiceImpl gestoreTeam;
    public Controller(){
        gestoreProgettoServiceImpl = GestoreProgettoServiceImpl.getInstance();
        gestoreProgettistaServiceImpl = GestoreProgettistaServiceImpl.getInstance();
        gestoreEspertoServiceImpl = GestoreEspertoServiceImpl.getInstance();
        gestoreSponsorServiceImpl = GestoreSponsorServiceImpl.getInstance();
        gestoreTeam= GestoreTeamServiceImpl.getInstance();
    }
    public void removeProgettista(int id) {

    }
    public void candidaturaProgettista(){

    }
    public void registerProgettista(String name, String surname, CurriculumServiceImpl curriculumServiceImpl) {
        ProgettistaServiceImpl p= new ProgettistaServiceImpl(name,surname, curriculumServiceImpl);
        GestoreProgettistaServiceImpl.getInstance().addProgettista(p);
    }
    public void registerProponenteProgetto(String name, String surname, CurriculumServiceImpl curriculumServiceImpl){
        ProponenteProgettoServiceImpl p= new ProponenteProgettoServiceImpl(name,surname, curriculumServiceImpl);
        GestoreProgettistaServiceImpl.getInstance().addProgettista(p); //?

    }
    public void registerEsperto(String name,String surname){
        EspertoServiceImpl espertoServiceImpl = new EspertoServiceImpl(name,surname);
        GestoreEspertoServiceImpl.getInstance().addEsperto(espertoServiceImpl);
    }
    public void registerSponsor(String name){
        SponsorServiceImpl s= new SponsorServiceImpl(name);
        GestoreSponsorServiceImpl.getInstance().addSponsor(s);
    }
    public void addProgetto(String name,int proponenteProgettoID,int nMaxProgettisti){
        ProgettoServiceImpl p= new ProgettoServiceImpl(proponenteProgettoID,name,nMaxProgettisti);
        GestoreProgettoServiceImpl.getInstance().addProgetto(p);
    }
    public void candidateProgetto(ProgettistaServiceImpl p, ProgettoServiceImpl progetto){
        p.sendCandidatura(progetto);
    }

    public void inviteProgettista(ProgettistaServiceImpl p, ProgettoServiceImpl progetto, ProponenteProgettoServiceImpl proponenteProgetto){
        proponenteProgetto.inviteProgettista(p,progetto);
    }

    public void confirmProgetto(ProgettoServiceImpl progetto){
        progetto.confirmProgetto();
    }

    public void declineProgetto(ProgettoServiceImpl progetto){
        progetto.declineProgetto();
    }

    public void sponsorizzaProgetto(SponsorServiceImpl s, double amount, ProgettoServiceImpl p){  }

    public List<ProgettistaServiceImpl> printProgettisti(){
        return GestoreProgettistaServiceImpl.getInstance().getProgettisti();
    }

    public List<ProgettoServiceImpl> printProgetti(){
        return GestoreProgettoServiceImpl.getInstance().getProgetti();
    }
}
