package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Sponsor_Table")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_SPONSOR")
    private Long id;

    private String name;

    @Transient
    @ElementCollection(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("sponsors")
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
