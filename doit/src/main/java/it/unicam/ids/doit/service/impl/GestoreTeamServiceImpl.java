package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestoreTeamServiceImpl {

    private static GestoreTeamServiceImpl instance = null;

    private List<TeamService> teams;

    private GestoreTeamServiceImpl(){ }

    public TeamService getSingleTeam(int ID){
        return teams.stream()
                .filter(t -> t.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<TeamService> getTeams(){
        return teams;
    }

    public void addTeam(TeamService t){
        teams.add(t);
    }

    public void removeTeam(TeamService t){
        teams.remove(t);
    }

    public static GestoreTeamServiceImpl getInstance(){
        if(instance == null){
            instance = new GestoreTeamServiceImpl();
        }
        return instance;
    }
}
