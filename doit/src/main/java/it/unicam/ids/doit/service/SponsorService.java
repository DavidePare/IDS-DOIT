package it.unicam.ids.doit.service;

import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;

import java.util.Map;

public interface SponsorService {
    int getID();

    String getName();
    Map<ProgettoService,Double> getProgettiInv();

    void addAmountProgetto(ProgettoService p, double amount);

    void decrementAmountProgetto(ProgettoService p, double amount);
}
