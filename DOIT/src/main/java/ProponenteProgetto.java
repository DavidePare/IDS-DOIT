import java.util.List;

public class ProponenteProgetto extends Progettista {

    private List<Progetto> progettiGestiti;

    public ProponenteProgetto(String name, String surname, Curriculum curriculum){
        super(name, surname,curriculum);
    }

    public void addProgettoGestito(Progetto p){
        progettiGestiti.add(p);
    }

    public void removeProgettoGestito(Progetto p){
        progettiGestiti.remove(p);
    }

    public void createProgetto(String name,int nMax){
        Progetto p = new Progetto(this.getID(),name,nMax); // MANCANO ANCORA I PARAMETRI E POI CI SARA UN FACTORY METHOD
        addProgettoGestito(p);
        //il controller farà l aggiunta al gestore dei progetti
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
