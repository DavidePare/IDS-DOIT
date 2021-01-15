import java.util.List;

public class GestoreTeam {

    private List<Team> teams;

    public GestoreTeam(){ }

    public Team getSingleTeam(int ID){
        return teams.stream()
                .filter(t -> t.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Team> getTeams(){
        return teams;
    }

    public void addTeam(Team t){
        teams.add(t);
    }

    public void removeTeam(Team t){
        teams.remove(t);
    }
}
