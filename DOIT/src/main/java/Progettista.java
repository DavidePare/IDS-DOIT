import java.util.ArrayList;
import java.util.List;

public class Progettista {


    private int id;
    private String name;
    private String surname;
    private Curriculum curriculum;
    private List<Progetto> progettiProgettista;
    private List<Progetto> inviti;
    private List<Integer> progettiCandidati;

    public Progettista(String name, String surname, Curriculum curriculum){
        this.name=name;
        this.surname=surname;
        this.curriculum=curriculum;
        progettiProgettista = new ArrayList<>();
        inviti= new ArrayList<>();
        progettiCandidati= new ArrayList<>();
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public List<Progetto> getProgettiProgettista(){
        return progettiProgettista;
    }

    public Curriculum getCurriculum(){
        return curriculum;
    }

    public void addProgetto(Progetto p){
        progettiProgettista.add(p);
    }

    public void removeProgetto(Progetto p){
        progettiProgettista.remove(p);
    }

    public List<Progetto> getInviti(){
        return inviti;
    }

    public void addInvito(Progetto p){
        inviti.add(p);
    }

    public void acceptInvito(Progetto p){
        p.getTeam().addProgettista(this);
        inviti.remove(p);
    }

    public void refuseInvito(Progetto p){
        inviti.remove(p);
    }

    public List<Integer> getprogettiCandidati(){
        return progettiCandidati;
    }

    public void addprogettoCandidato(Progetto p){
        progettiCandidati.add(p.getID());
    }

    public void removeprogettoCandidato(Progetto p){
        progettiCandidati.remove(p.getID());
    }

    public List<Team> getTeamsProgettista() {
        List<Team> teams = new ArrayList<>();
        getProgettiProgettista().stream().forEach(p -> teams.add(p.getTeam()));
        return teams;
    }

    public void sendCandidatura(Progetto p){
        p.addCandidato(this);
        addprogettoCandidato(p);
    }
}
