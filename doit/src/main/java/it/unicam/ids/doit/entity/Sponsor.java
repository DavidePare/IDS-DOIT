package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

public class Sponsor {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Map<Progetto,Double> progettiInv;

    public Sponsor(String name){
        this.name=name;
        progettiInv= new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Progetto, Double> getProgettiInv() {
        return progettiInv;
    }

    public void setProgettiInv(Map<Progetto, Double> progettiInv) {
        this.progettiInv = progettiInv;
    }
}
