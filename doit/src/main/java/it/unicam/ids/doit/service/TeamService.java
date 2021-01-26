package it.unicam.ids.doit.service;

import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;

import java.util.List;

public interface TeamService {
    int getID();

    List<ProgettistaService> getProgettisti();

    int getProgetto();

    void addProgetto(ProgettoService p);

    void removeProgetto();

    void removeProgettista(ProgettistaService p);

    void addProgettista(ProgettistaService p);
}
