package it.unicam.ids.doit.service;

import it.unicam.ids.doit.service.impl.CurriculumServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;

import java.util.ArrayList;
import java.util.List;

public interface ProponenteProgettoService extends ProgettistaService {

    void addProgettoGestito(ProgettoService p);

    void removeProgettoGestito(ProgettoService p);

    void createProgetto(String name,int nMax);

    List<ProgettoService> getProgettiGestiti();

    void acceptCandidatura(ProgettoService progetto, ProgettistaService progettista);

    void declineCandidatura(ProgettoService progetto, ProgettistaService progettista);

    void inviteProgettista(ProgettistaService progettista, ProgettoService progetto);
}
