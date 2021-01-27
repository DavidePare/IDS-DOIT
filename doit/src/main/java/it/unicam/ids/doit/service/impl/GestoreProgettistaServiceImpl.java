package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.ProgettistaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreProgettistaServiceImpl {

    private static GestoreProgettistaServiceImpl instance = null;

    private List<ProgettistaService> progettisti;

    private GestoreProgettistaServiceImpl(){
        progettisti= new ArrayList<>();
    }

    public List<ProgettistaService> getProgettisti(){
        return progettisti;
    }

    public ProgettistaService getSingleProgettista(int ID){
        return progettisti.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public void addProgettista(ProgettistaService p){
        progettisti.add(p);
    }

    public void removeProgettista(ProgettistaService p){
        progettisti.remove(p);
    }

    public static GestoreProgettistaServiceImpl getInstance(){
        if(instance == null){
            instance = new GestoreProgettistaServiceImpl();
        }
        return instance;
    }
}
