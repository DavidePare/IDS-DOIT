package it.unicam.ids.doit.service;

import it.unicam.ids.doit.entity.Team;

import java.util.List;

public interface TeamService {

    Team createTeam(Long idProgetto);

    void deleteTeam(Long idProgetto);

    Team getTeam(Long id);

    List<Team> getAllTeams();

    void removeProgettista(Long idTeam, Long idProgettista, Long idProgetto);

    void addProgettista(Long idTeam, Long idProgettista);

}
