package it.unicam.ids.doit.entity.Curriculum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class LanguagesCurriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String language;
    public LanguagesCurriculum() {

    }
    public LanguagesCurriculum(String language){
        this.language=language;
    }

    public String getLanguage(){
        return language;
    }
    public void setLanguage(String Language){
        this.language=language;
    }
}
