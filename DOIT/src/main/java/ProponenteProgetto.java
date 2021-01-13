import java.util.List;

public class ProponenteProgetto extends Progettista {

    private List<Progetto> progettiGestiti;

    public ProponenteProgetto(){
        super();
    }

    public void addProgettoGestito(Progetto p){
        progettiGestiti.add(p);
    }

    public void createProgetto(){
        Progetto p = new Progetto(); // MANCANO ANCORA I PARAMETRI E POI CI SARA UN FACTORY METHOD
        progettiGestiti.add(p);
    }

    public List<Progetto> getProgettiGestiti(){
        return progettiGestiti;
    }

    public void acceptCandidatura(Progetto progetto, Progettista progettista){
        progetto.getTeam().addProgettista(progettista);
        progetto.removeCandidato(progetto.getSingleCandidato(progettista.getID()));
    }

    public void declineCandidatura(Progetto progetto, Progettista progettista){
        progetto.removeCandidato(progetto.getSingleCandidato(progettista.getID()));
    }

    public void inviteProgettista(Progettista progettista, Progetto progetto){
        progettista.addInvito(progetto);
    }
}
