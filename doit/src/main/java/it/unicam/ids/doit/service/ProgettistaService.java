package it.unicam.ids.doit.service;

import it.unicam.ids.doit.service.impl.CurriculumServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import it.unicam.ids.doit.service.impl.TeamServiceImpl;

import java.util.ArrayList;
import java.util.List;

public interface ProgettistaService {

    int getID();

    String getName();

    String getSurname();

    List<ProgettoService> getProgettiProgettista();

    CurriculumServiceImpl getCurriculum();

    void addProgetto(ProgettoService p);

    void removeProgetto(ProgettoService p);

    List<ProgettoService> getInviti();

    void addInvito(ProgettoService p);

    void acceptInvito(ProgettoService p);

    void refuseInvito(ProgettoService p);

    List<Integer> getprogettiCandidati();

    void addprogettoCandidato(ProgettoService p);

    void removeprogettoCandidato(ProgettoService p);

    List<TeamService> getTeamsProgettista();

    void sendCandidatura(ProgettoService p);

}
