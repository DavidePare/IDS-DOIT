import java.util.List;

public class GestoreProgettista {

    private static GestoreProgettista instance = null;

    private List<Progettista> progettisti;

    private GestoreProgettista(){ }

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

    public static GestoreProgettista getInstance(){
        if(instance == null){
            instance = new GestoreProgettista();
        }
        return instance;
    }
}
