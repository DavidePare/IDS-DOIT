package it.unicam.ids.doit.service;

import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;

public interface EspertoService {

    int getID();

    String getName();

    String getSurname();

    void confirmProgetto(ProgettoService p);

    void declineProgetto(ProgettoService p);
}
