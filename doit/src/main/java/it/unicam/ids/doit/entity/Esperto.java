package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Esperto_Table")
public class Esperto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Esperto")
    private Long id;

    private String name;

    private String surname;

    //@OneToMany(mappedBy ="ID_Progetto")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Progetto> progettiEsperto;




    public Esperto(){

    }
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

    public List<Progetto> getProgettiEsperto() {
        return progettiEsperto;
    }

    public void setProgettiEsperto(List<Progetto> progettiEsperto) {
        this.progettiEsperto = progettiEsperto;
    }


}
