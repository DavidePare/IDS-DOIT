package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Team;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;

import java.util.List;

public interface TeamService {

    Team getTeam(Long id);

    List<Team> getAllTeams();

    void addProgetto(Long idTeam, Long idProgetto);

    void removeProgetto(Long idTeam);

    void removeProgettista(Long idTeam, Long idProgettista);

    void addProgettista(Long idTeam, Long idProgettista);
}
