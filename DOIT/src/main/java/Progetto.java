import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Progetto {

    private int id;

    private int nMaxProgettisti;

    private IState state;

    private double amount;

    private String name;

    private Team team;

    private Date scadenza;

    private int proponenteProgettoID;

    private List<Integer> candidati;

    private List<Integer> sponsors;

    public Progetto(){
        state = new Waiting(this);
        candidati = new ArrayList<Integer>();
    }

    public int getID(){
        return id;
    }

    public int getProponenteProgetto() {
        return proponenteProgettoID;
    }

    public IState getState(){
        return state;
    }

    public void confirmProgetto() {
        /*state = true;*/
        state.confirm();
    }

    public void declineProgetto() {
        /*state = false;*/
        state.decline();
    }

    public Team getTeam(){
        return team;
    }

    public Date getScadenza(){
        return scadenza;
    }

    public void addCandidato(Progettista p){
        //candidati.add(p);
        state.addCandidato(p);
    }

    public void removeCandidato(Progettista p) {
        //candidati.remove(p);
        state.removeCandidato(p);
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

    public void setState(IState state){ this.state=state;}

    public void setAmount(double amount){ this.amount=amount;}

    public double getAmount(){ return this.amount;}

    public void incrementAmount(double a){
        state.incrementAmount(a);
    }

    public void decrementAmount(double a){
        state.decrementAmount(a);
    }
}
