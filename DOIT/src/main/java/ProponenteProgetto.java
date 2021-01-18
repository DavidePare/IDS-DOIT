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
        if(progettiGestiti.contains(progetto)&&progetto.getCandidati().contains(progettista)){
            progetto.getTeam().addProgettista(progettista);
            progetto.removeCandidato(progettista);
            progettista.removeprogettoCandidato(progetto);
        }

    }

    public void declineCandidatura(Progetto progetto, Progettista progettista){
        if(progettiGestiti.contains(progetto)&&progetto.getCandidati().contains(progettista)){
            progetto.removeCandidato(progettista);
            progettista.removeprogettoCandidato(progetto);
        }
    }

    public void inviteProgettista(Progettista progettista, Progetto progetto){
        progettista.addInvito(progetto);
    }
}
