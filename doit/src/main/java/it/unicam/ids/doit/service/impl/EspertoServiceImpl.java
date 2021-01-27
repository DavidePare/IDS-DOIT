package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.service.EspertoService;
import it.unicam.ids.doit.service.ProgettoService;
import org.springframework.stereotype.Service;

@Service
public class EspertoServiceImpl implements EspertoService {

    private int id;

    private String name;

    private String surname;

    public EspertoServiceImpl(String name, String surname){
        this.name= name;
        this.surname= surname;
    }

    @Override
    public int getID(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getSurname(){
        return surname;
    }

    @Override
    public void confirmProgetto(ProgettoService p){
        p.confirmProgetto();
    }

    @Override
    public void declineProgetto(ProgettoService p){ p.declineProgetto(); }


}
