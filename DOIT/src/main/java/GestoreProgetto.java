import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestoreProgetto {

    private static GestoreProgetto instance;

    private List<Progetto> progetti;

    private GestoreProgetto(){
        progetti =new ArrayList<>();
    }

    public List<Progetto> getProgetti(){
        return progetti;
    }

    public Progetto getSingleProgetto(int ID){
        return progetti.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Progetto> getProgettiForType(IState state){
        List<Progetto> projList= new ArrayList<>();
        progetti.stream().filter(p-> p.getState().getClass() == state.getClass()).forEach(p-> projList.add(p));
        //System.out.println("Ciao "+projList.size());
        return projList;
    }

    public void addProgetto(Progetto p){
        progetti.add(p);
    }

    public void removeProgetto(Progetto p){
        progetti.remove(p);
    }

    public static GestoreProgetto getInstance(){
        if(instance == null){
            instance = new GestoreProgetto();
        }
        return instance;
    }
}
