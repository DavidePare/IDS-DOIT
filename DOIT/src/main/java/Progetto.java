import java.util.List;

public class Progetto {

    private int id;

    private boolean state;

    private double amount;

    private String name;

    private Team team;

    // private String scadenza   CHE TIPO DEVE ESSERE?

    private ProponenteProgetto proponenteProgetto;

    private List<Progettista> candidati;

    public Progetto(){ }

    public int getID(){
        return id;
    }

    public ProponenteProgetto getProponenteProgetto() {
        return proponenteProgetto;
    }

    public boolean getState(){
        return state;
    }

    public void confirmProgetto() {
        state = true;
    }

    public void declineProgetto() {
        state = false;
    }

    public Team getTeam(){
        return team;
    }

    public void addCandidato(Progettista p){
        candidati.add(p);
    }

    public void removeCandidato(Progettista p) { candidati.remove(p); }

    public Progettista getSingleCandidato(int ID){
        return candidati.stream()
                .filter(p -> p.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Progettista> getCandidati(){
        return candidati;
    }

    public void incrementAmount(double a){
        amount = amount + a;
    }

    public void decrementAmount(double a){
        amount = amount - a;
    }



}
