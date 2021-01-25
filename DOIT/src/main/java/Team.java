import java.util.ArrayList;
import java.util.List;

public class Team {

    private int id;

    private List<Progettista> progettistiTeam;

    private int progettoID;

    public Team(){
        progettistiTeam = new ArrayList<>();
    }

    public int getID(){
        return id;
    }

    /*public Progettista getProgettistaTeam(int ID){
        return progettistiTeam.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }*/

    public List<Progettista> getProgettisti(){
        return progettistiTeam;
    }

    public int getProgetto(){
        return progettoID;
    }

    public void addProgetto(Progetto p){
        progettoID = p.getID();
    }

    public void removeProgetto(){
        progettoID = -1;
    }

    public void removeProgettista(Progettista p){
       progettistiTeam.remove(p);
    }

    public void addProgettista(Progettista p){
        progettistiTeam.add(p);
    }
}
