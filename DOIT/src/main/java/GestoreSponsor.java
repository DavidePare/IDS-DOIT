import java.util.List;

public class GestoreSponsor {

    private List<Sponsor> sponsors;

    public GestoreSponsor(){ }

    public Sponsor getSingleSponsor(int ID){
        return sponsors.stream()
                .filter(s -> s.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Sponsor> getSponpors(){
        return sponsors;
    }

    public void addSponsor(Sponsor s){
        sponsors.add(s);
    }

    public void removeSponsor(Sponsor s){
        sponsors.remove(s);
    }
}
