package it.unicam.ids.doit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Investimenti {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private Long idProgetto;
    public Investimenti(){

    }
    public Investimenti(double amount, Long idProgetto) {
        this.amount = amount;
        this.idProgetto = idProgetto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getIdProgetto() {
        return idProgetto;
    }

    public void setIdProgetto(Long idProgetto) {
        this.idProgetto = idProgetto;
    }

    public void addAmount(double amount){
        this.amount+=amount;
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    
=======

>>>>>>> Stashed changes
=======

>>>>>>> Stashed changes
    public void decrementAmount(double amount){
        this.amount=this.amount-amount;
    }
}
