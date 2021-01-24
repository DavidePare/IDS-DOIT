import java.util.HashMap;
import java.util.Map;

public class Sponsor {

    private int id;

    private String name;

    private Map<Progetto,Double> progettiInv;

    public Sponsor(String name){
        this.name=name;
        progettiInv= new HashMap<>();
    }

    public int getID(){
        return id;
    }

    public Map<Progetto,Double> getProgettiInv(){
        return progettiInv;
    }

    public void addAmountProgetto(Progetto p, double amount){
        if(progettiInv.containsKey(p)){
            progettiInv.replace(p,progettiInv.get(p)+amount);
        } else{
            progettiInv.put(p,amount);
        }
    }

    public void decrementAmountProgetto(Progetto p, double amount){
        if(progettiInv.containsKey(p)){
            progettiInv.replace(p,progettiInv.get(p)-amount);
        }
    }
}
