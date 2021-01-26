package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.IState;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreProgettoServiceImpl {

    private static GestoreProgettoServiceImpl instance;

    private List<ProgettoService> progetti;

    private GestoreProgettoServiceImpl(){
        progetti =new ArrayList<>();
    }

    public List<ProgettoService> getProgetti(){
        return progetti;
    }

    public ProgettoService getSingleProgetto(int ID){
        return progetti.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<ProgettoService> getProgettiForType(IState state){
        List<ProgettoService> projList= new ArrayList<>();
        progetti.stream().filter(p-> p.getState().getClass() == state.getClass()).forEach(p-> projList.add(p));
        return projList;
    }

    public void addProgetto(ProgettoService p){
        progetti.add(p);
    }

    public void removeProgetto(ProgettoService p){
        progetti.remove(p);
    }

    public static GestoreProgettoServiceImpl getInstance(){
        if(instance == null){
            instance = new GestoreProgettoServiceImpl();
        }
        return instance;
    }
}
