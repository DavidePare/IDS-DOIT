import java.util.ArrayList;
import java.util.List;

public class Progetto {

    //private GestoreProgettista gestoreProgettista;

    private int id;

    private int nMaxProgettisti;

    private boolean state;

    private double amount;

    private String name;

    private Team team;

    // private String scadenza   CHE TIPO DEVE ESSERE?

    private int proponenteProgettoID;

    private List<Integer> candidati;

    private List<Integer> sponsors;

    public Progetto(){ }

    public int getID(){
        return id;
    }

    public int getProponenteProgetto() {
        return proponenteProgettoID;
    }

    public boolean getState(){
        return state;
    }

    public void confirm() {
        state = true;
    }

    public void decline() {
        state = false;
    }

    public Team getTeam(){
        return team;
    }

    public void addCandidato(Progettista p){
        candidati.add(p.getID());
    }

    public void removeCandidato(Progettista p) {
        candidati.remove(p.getID());
    }

    /*public Progettista getSingleCandidato(int ID){
        return candidati.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }*/

    public List<Integer> getCandidati(){
        return candidati;
    }

    public void addSponsor(Sponsor s){
        sponsors.add(s.getID());
    }

    public void removeSponsor(Sponsor s){
        sponsors.remove(s.getID());
    }

    public void incrementAmount(double a){
        amount = amount + a;
    }

    public void decrementAmount(double a){
        amount = amount - a;
    }



}
