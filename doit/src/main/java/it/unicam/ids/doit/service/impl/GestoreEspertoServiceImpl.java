package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.EspertoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreEspertoServiceImpl {

    private static GestoreEspertoServiceImpl instance = null;

    private List<EspertoService> esperti;

    private GestoreEspertoServiceImpl(){
        esperti = new ArrayList<EspertoService>();
    }

    public EspertoService getSingleEsperto(int ID){
        return esperti.stream()
                .filter(e -> e.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<EspertoService> getEsperti(){
        return esperti;
    }

    public void addEsperto(EspertoService e){
        esperti.add(e);
    }

    public void removeEsperto(EspertoService e){
        esperti.remove(e);
    }

    public static GestoreEspertoServiceImpl getInstance(){
        if(instance == null){
            instance = new GestoreEspertoServiceImpl();
        }
        return instance;
    }
}
