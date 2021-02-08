package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.TeamRepository;
import it.unicam.ids.doit.entity.Team;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private ProgettistaService progettistaService;

    @Override
    public Team createTeam(Long idProgetto){
        Team team = new Team(idProgetto);
        teamRepository.save(team);
        return team;
    }

    @Override
    public void deleteTeam(Long idTeam){
        Team team = getTeam(idTeam);
        progettoService.removeTeam(team.getProgettoID());
        if(!team.getProgettistiTeam().isEmpty()) team.getProgettistiTeam().
                forEach(p -> progettistaService.removeTeam(p,idTeam));
        teamRepository.delete(team);
    }

    @Override
    public Team getTeam(Long id){
        return teamRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @Override
    public void removeProgettista(Long idTeam, Long idProgettista){
        Team team = getTeam(idTeam);
        team.getProgettistiTeam().remove(idProgettista);
        //progettistiTeam.remove(p);
        teamRepository.save(team);
    }

    @Override
    public void addProgettista(Long idTeam, Long idProgettista){
        Team team = getTeam(idTeam);
        team.getProgettistiTeam().add(idProgettista);
        //progettistiTeam.add(p);
        teamRepository.save(team);
    }

}
