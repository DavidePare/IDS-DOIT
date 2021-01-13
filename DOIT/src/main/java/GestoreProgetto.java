import java.util.List;

public class GestoreProgetto {

    private List<Progetto> progetti;

    public GestoreProgetto(){ }

    public List<Progetto> getProgetti(){
        return progetti;
    }

    public Progetto getSingleProgetto(int ID){
        return progetti.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public void addProgetto(Progetto p){
        progetti.add(p);
    }

    public void removeProgetto(Progetto p){
        progetti.remove(p);
    }
}
