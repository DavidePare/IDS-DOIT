import java.util.List;

public class Team {

    private int id;

    private List<Progettista> progettistiTeam;

    private Progetto progetto;

    public Team(){ }

    public int getID(){
        return id;
    }

    public Progettista getProgettistaTeam(int ID){
        return progettistiTeam.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Progettista> getProgettisti(){
        return progettistiTeam;
    }

    public Progetto getProgetto(){
        return progetto;
    }

    public void addProgetto(Progetto p){
        progetto = p;
    }

    public void removeProgetto(){
        progetto = null;
    }

    public void removeProgettista(Progettista p){
       progettistiTeam.remove(p);
    }

    public void addProgettista(Progettista p){
        progettistiTeam.add(p);
    }


}
