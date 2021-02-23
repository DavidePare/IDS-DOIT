package it.unicam.ids.doit.entity.CurriculumD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkingExperienceCurriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String workingExperience;

    public WorkingExperienceCurriculum(){

    }
    public WorkingExperienceCurriculum(String experience){
        this.workingExperience=experience;
    }

    public String getWorkingExperience(){
        return workingExperience;
    }
    public void setWorkingExperience(String workingExperience){
        this.workingExperience=workingExperience;
    }

}
