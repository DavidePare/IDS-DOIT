import java.util.List;

public class Progettista {

    private int id;
    private String name;
    private String surname;
    // private curriculum; pensato di utilizzare il design pattern state
    private List<Progetto> inviti;
    private List<Team> teams;

    public Progettista(){ }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public List<Progetto> getInviti(){
        return inviti;
    }

    /*public Progetto getSingleInvito(int ID){
        return inviti.stream()
                .filter(i -> i.getID() == ID)
                .findFirst()
                .orElse(null);
    }*/

    public List<Team> getTeams() {
        return teams;
    }

    public Team getSingleTeam(int ID){
        return teams.stream()
                .filter(t -> t.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public void sendCandidatura(Progetto p){ // non so se è corretto passare direttamente l'oggetto
        p.addCandidato(this);
    }

    public void addInvito(Progetto p){
        inviti.add(p);
    }

    public void acceptInvito(Progetto p){
        p.getTeam().addProgettista(this);
        teams.add(p.getTeam());
        inviti.remove(p);
    }

    public void deleteInvito(Progetto p){
        inviti.remove(p);
    }


}
