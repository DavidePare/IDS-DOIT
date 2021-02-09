package it.unicam.ids.doit.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long progettistaID;
    String instruction;
    String formation;
    @ElementCollection
    List<String> workingExperience;
    @ElementCollection
    List<String> languages;
    int phone;
    String email;

    public Curriculum(){ }

    public Curriculum(Long idProgettista,String instruction,String formation,int phone,String email){
        this.progettistaID = idProgettista;
        this.instruction = instruction;
        this.formation = formation;
        this.phone = phone;
        this.email = email;
        workingExperience = new ArrayList<>();
        languages = new ArrayList<>();
    }
    public long getId() {
        return id;
    }
    public Long getProgettistaID() {
        return progettistaID;
    }
    public void setProgettistaID(long progettistaID) {
        this.progettistaID = progettistaID;
    }
    public String getInstruction() {
        return instruction;
    }
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    public String getFormation() {
        return formation;
    }
    public void setFormation(String formation) {
        this.formation = formation;
    }
    public List<String> getWorkingExperience() {
        return workingExperience;
    }
    public void setWorkingExperience(List<String> workingExperience) {
        this.workingExperience = workingExperience;
    }
    public List<String> getLanguages() {
        return languages;
    }
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}