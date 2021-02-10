package it.unicam.ids.doit.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Team_Table")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_TEAM")
    private Long id;

    @ElementCollection
    private List<Long> progettistiTeam;

    private Long progettoID;

    public Team(){ }

    public Team(Long idProgetto){
        this.progettoID = idProgetto;
        progettistiTeam = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<Long> getProgettistiTeam() {
        return progettistiTeam;
    }

    public void setProgettistiTeam(List<Long> progettistiTeam) {
        this.progettistiTeam = progettistiTeam;
    }

    public Long getProgettoID() {
        return progettoID;
    }

    public void setProgettoID(Long progettoID) {
        this.progettoID = progettoID;
    }

}
