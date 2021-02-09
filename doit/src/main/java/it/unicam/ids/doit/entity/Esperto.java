package it.unicam.ids.doit.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Esperto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @ElementCollection
    private List<Long> progettiEsperto;

    public Esperto(String name, String surname){
        this.name= name;
        this.surname= surname;
        this.progettiEsperto = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Long> getProgettiEsperto() {
        return progettiEsperto;
    }

    public void setProgettiEsperto(List<Long> progettiEsperto) {
        this.progettiEsperto = progettiEsperto;
    }
}
