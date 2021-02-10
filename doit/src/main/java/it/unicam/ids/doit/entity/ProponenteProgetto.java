package it.unicam.ids.doit.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ProponenteProgetto_Table")
public class ProponenteProgetto extends  Progettista{

  //  @OneToMany()
    //@JoinColumn(name="id")
  /*  @OneToMany
    @JoinColumn(name="id_Progetti")*/
    @ElementCollection
    private List<Long> progettiGestiti;
    public ProponenteProgetto(){
        super();
    }
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
