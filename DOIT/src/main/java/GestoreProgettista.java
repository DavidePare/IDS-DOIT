import java.util.List;

public class GestoreProgettista {

    private List<Progettista> progettisti;

    public GestoreProgettista(){ }

    public List<Progettista> getProgettisti(){
        return progettisti;
    }

    public Progettista getSingleProgettista(int ID){
        return progettisti.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public void addProgettista(Progettista p){
        progettisti.add(p);
    }

    public void removeProgettista(Progettista p){
        progettisti.remove(p);
    }
}
