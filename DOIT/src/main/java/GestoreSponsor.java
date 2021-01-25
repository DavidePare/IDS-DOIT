import java.util.ArrayList;
import java.util.List;

public class GestoreSponsor {

    private static GestoreSponsor instance = null;

    private List<Sponsor> sponsors;

    private GestoreSponsor(){
        sponsors = new ArrayList<>();
    }

    public Sponsor getSingleSponsor(int ID){
        return sponsors.stream()
                .filter(s -> s.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Sponsor> getSponsors(){
        return sponsors;
    }

    public void addSponsor(Sponsor s){
        sponsors.add(s);
    }

    public void removeSponsor(Sponsor s){
        sponsors.remove(s);
    }

    public static GestoreSponsor getInstance(){
        if(instance == null){
            instance = new GestoreSponsor();
        }
        return instance;
    }
}
