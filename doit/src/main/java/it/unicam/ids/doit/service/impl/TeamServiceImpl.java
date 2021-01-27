package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.TeamRepository;
import it.unicam.ids.doit.entity.Progettista;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    public void addProgetto(ProgettoService p){
        progettoID = p.getID();
    }

    public void removeProgetto(){
        progettoID = -1;
    }

    public void removeProgettista(Progettista p){
       progettistiTeam.remove(p);
    }

    public void addProgettista(Progettista p){
        progettistiTeam.add(p);
    }
}
