import java.util.List;

public class GestoreTeam {

    private static GestoreTeam instance = null;

    private List<Team> teams;

    private GestoreTeam(){ }

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

    public static GestoreTeam getInstance(){
        if(instance == null){
            instance = new GestoreTeam();
        }
        return instance;
    }
}
