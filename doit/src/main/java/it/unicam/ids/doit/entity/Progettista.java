package it.unicam.ids.doit.entity;

import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.impl.CurriculumServiceImpl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Progettista {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String surname;

    private CurriculumServiceImpl curriculum;

    private List<ProgettoService> progettiProgettista;

    private List<ProgettoService> inviti;

    private List<Integer> progettiCandidati;

    public Progettista(String name, String surname, CurriculumServiceImpl curriculum){
        this.name=name;
        this.surname=surname;
        this.curriculum=curriculum;
        progettiProgettista = new ArrayList<>();
        inviti= new ArrayList<>();
        progettiCandidati= new ArrayList<>();
    }

}
