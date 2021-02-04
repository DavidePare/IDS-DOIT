package it.unicam.ids.doit.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProponenteProgetto extends  Progettista{

    @ElementCollection
    private List<Long> progettiGestiti;

    public ProponenteProgetto(String name, String surname){
        super(name, surname);
        progettiGestiti = new ArrayList<>();
    }

    public List<Long> getProgettiGestiti() {
        return progettiGestiti;
    }

    public void setProgettiGestiti(List<Long> progettiGestiti) {
        this.progettiGestiti = progettiGestiti;
    }
}
