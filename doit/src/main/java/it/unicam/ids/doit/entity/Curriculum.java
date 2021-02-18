package it.unicam.ids.doit.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Curriculum_Table")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long progettistaID;
    String instruction;
    String formation;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER) //classe esperienza con l entita
    Set<WorkingExperienceCurriculum> workingExperience;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<LanguagesCurriculum> languages;
    Number phone;
    String email;

    public Curriculum(){ }

    public Curriculum(Long idProgettista,String instruction,String formation,Number phone,String email){
        this.progettistaID = idProgettista;
        this.instruction = instruction;
        this.formation = formation;
        this.phone = phone;
        this.email = email;
        this.workingExperience=new HashSet<>();
        this.languages = new HashSet<>();
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
    public Set<WorkingExperienceCurriculum> getWorkingExperience() {
        return workingExperience;
    }
    public void setWorkingExperience(Set<WorkingExperienceCurriculum> workingExperience) {
        this.workingExperience = workingExperience;
    }
    public Set<LanguagesCurriculum> getLanguages() {
        return languages;
    }
    public void setLanguages(Set<LanguagesCurriculum> languages) {
        this.languages = languages;
    }
    public Number getPhone() {
        return phone;
    }
    public void setPhone(Number phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}