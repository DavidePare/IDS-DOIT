package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unicam.ids.doit.entity.Notifiche.NotificationMessage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ProponenteProgetto_Table")
public class ProponenteProgetto extends Progettista{

  //  @OneToMany()
    //@JoinColumn(name="id")
  /*  @OneToMany
    @JoinColumn(name="id_Progetti")*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//sicuro
    @JsonIgnoreProperties({"candidati","progettistiInvitati","sponsor"})
    private List<Progetto> progettiGestiti;



    public ProponenteProgetto(){
        super();
    }
    public ProponenteProgetto(String name, String surname,String email,String password){
        super(name, surname, email ,password);
        progettiGestiti = new ArrayList<>();
    }

    /**
     * Per i test Eliminabile
     * @param name nome
     * @param surname cognome
     */
    public ProponenteProgetto(String name, String surname){
        super(name, surname);
        progettiGestiti = new ArrayList<>();
    }

    public List<Progetto> getProgettiGestiti() {
        return progettiGestiti;
    }

    public void setProgettiGestiti(List<Progetto> progettiGestiti) {
        this.progettiGestiti = progettiGestiti;
    }
}
