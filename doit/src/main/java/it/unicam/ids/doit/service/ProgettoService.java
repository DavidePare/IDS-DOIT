package it.unicam.ids.doit.service;

import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.SponsorServiceImpl;
import it.unicam.ids.doit.service.impl.TeamServiceImpl;

import java.util.Date;
import java.util.List;

public interface ProgettoService {

    int getID();

    int getProponenteProgetto();

    IState getState();

    void confirmProgetto();

    void declineProgetto();

    TeamService getTeam();

    Date getScadenza();

    void addCandidato(ProgettistaService p);

    void removeCandidato(ProgettistaService p);

    List<Integer> getCandidati();

    void addSponsor(SponsorService s);

    void removeSponsor(SponsorService s);

    void setState(IState state);

    void setAmount(double amount);

    double getAmount();

    void incrementAmount(double a);

    void decrementAmount(double a);

}
