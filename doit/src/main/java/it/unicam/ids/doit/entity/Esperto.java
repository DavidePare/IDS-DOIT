package it.unicam.ids.doit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Esperto_Table")
public class Esperto implements Subscribe{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Esperto")
    private Long id;

    private String name;

    private String surname;

    @Column(nullable= false, unique=true)
    private String email;

    private String password;
    //@OneToMany(mappedBy ="ID_Progetto")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Progetto> progettiEsperto;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NotificationMessage> messaggeBacheca;



    public Esperto(){

    }

    /**
     * Costruttore per i test
     * @param name nome
     * @param surname cognome
     */
    public Esperto(String name, String surname){
        this.name= name;
        this.surname= surname;
        this.progettiEsperto = new ArrayList<>();
    }

    public Esperto(String name, String surname,String email, String password){
        this.name= name;
        this.surname= surname;
        this.email= email;
        this.password=password;
        this.progettiEsperto = new ArrayList<>();
        this.messaggeBacheca= null;
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Progetto> getProgettiEsperto() {
        return progettiEsperto;
    }

    public void setProgettiEsperto(List<Progetto> progettiEsperto) {
        this.progettiEsperto = progettiEsperto;
    }


    @Override
    public void notify(String message, String name, Long id) {
        messaggeBacheca.add(new NotificationMessage(message,name,id));
    }

    @Override
    public List<NotificationMessage> getMessaggeBacheca() {
        return messaggeBacheca;
    }

    public void setMessaggeBacheca(List<NotificationMessage> messaggeBacheca) {
        this.messaggeBacheca.addAll(messaggeBacheca);
    }
}
