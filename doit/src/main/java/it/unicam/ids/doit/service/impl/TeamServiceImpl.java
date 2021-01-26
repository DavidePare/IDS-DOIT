package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import it.unicam.ids.doit.service.impl.ProgettistaServiceImpl;
import it.unicam.ids.doit.service.impl.ProgettoServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private int id;

    private List<ProgettistaService> progettistiTeam;

    private int progettoID;

    public TeamServiceImpl(){
        progettistiTeam=new ArrayList<>();
    }

    public int getID(){
        return id;
    }

    /*public Progettista getProgettistaTeam(int ID){
        return progettistiTeam.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }*/

    public List<ProgettistaService> getProgettisti(){
        return progettistiTeam;
    }

    public int getProgetto(){
        return progettoID;
    }

    public void addProgetto(ProgettoService p){
        progettoID = p.getID();
    }

    public void removeProgetto(){
        progettoID = -1;
    }

    public void removeProgettista(ProgettistaService p){
       progettistiTeam.remove(p);
    }

    public void addProgettista(ProgettistaService p){
        progettistiTeam.add(p);
    }
}
