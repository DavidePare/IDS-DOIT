package it.unicam.ids.doit.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="Sponsor_Table")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_SPONSOR")
    private Long id;

    private String name;

    @ElementCollection
    private Map<Long,Double> progettiInv;

    public Sponsor(){ }

    public Sponsor(String name){
        this.name=name;
        progettiInv= new HashMap<>();
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

    public Map<Long, Double> getProgettiInv() {
        return progettiInv;
    }

    public void setProgettiInv(Map<Long, Double> progettiInv) {
        this.progettiInv = progettiInv;
    }
}
