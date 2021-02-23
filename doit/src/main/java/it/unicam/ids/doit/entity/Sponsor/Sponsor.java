package it.unicam.ids.doit.entity.Sponsor;

import it.unicam.ids.doit.entity.Notifiche.NotificationMessage;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Sponsor_Table")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_SPONSOR")
    private Long id;

    private String name;

    @Column(nullable= false, unique=true)
    private String email;
    private String password;



 /*   @Transient
    @ElementCollection(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("sponsors")*/
    //private Map<Long,Double> progettiInv;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Investimenti> progettiInv;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<NotificationMessage> messagge;

    public Sponsor(){ }

    /**
     * Per test
     * @param name nome
     */
    public Sponsor(String name){
        this.name=name;
        progettiInv= new HashSet<>();

    }
    public Sponsor(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
        progettiInv= new HashSet<>();

    }

    public Set<Investimenti> getProgettiInv() {
        return progettiInv;
    }

    public void setProgettiInv(Set<Investimenti> progettiInv) {
        this.progettiInv = progettiInv;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
