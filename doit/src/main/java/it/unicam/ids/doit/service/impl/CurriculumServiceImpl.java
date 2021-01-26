package it.unicam.ids.doit.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl {

    int ProgettistaID;

    String instruction;

    String formation;

    List<String> workingExperience;

    List<String> languages;

    int phone;

    String email;

    public CurriculumServiceImpl(){ }

    public int getIDProgettista(){
        return ProgettistaID;
    }

    public String getInstruction(){
        return instruction;
    }

    public String getFormation(){
        return formation;
    }

    public List<String> getWorkingExperience(){
        return workingExperience;
    }

    public List<String> getLanguages(){
        return languages;
    }

    public int getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public void addWorkingExperience(String experience){
        workingExperience.add(experience);
    }

    public void removeWorkingExperience(String experience){
        workingExperience.remove(experience);
    }

    public void addLanguages(String language){
        languages.add(language);
    }

    public void removeLanguages(String language){
        languages.add(language);
    }
}
