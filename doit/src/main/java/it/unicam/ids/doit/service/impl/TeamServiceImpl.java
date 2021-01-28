package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.TeamRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.entity.Progetto;
import it.unicam.ids.doit.entity.Team;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team getTeam(Long id){
        return teamRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @Override
    public void addProgetto(Long idTeam, Long idProgetto){
        Team team = getTeam(idTeam);
        team.setProgettoID(idProgetto);
        //progettoID = p.getID();
        teamRepository.save(team);
    }

    @Override
    public void removeProgetto(Long idTeam){ //QUESTO METODO NON SO SE SERVE
        Team team = getTeam(idTeam);
        team.setProgettoID((long)-1);
        //progettoID = -1;
        teamRepository.save(team);
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
