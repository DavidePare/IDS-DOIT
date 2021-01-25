import java.util.ArrayList;
import java.util.List;

public class Controller{
    GestoreProgetto gestoreProgetto;
    GestoreProgettista gestoreProgettista;
    GestoreEsperto gestoreEsperto;
    GestoreSponsor gestoreSponsor;
    GestoreTeam gestoreTeam;
    public Controller(){
        gestoreProgetto= GestoreProgetto.getInstance();
        gestoreProgettista = GestoreProgettista.getInstance();
        gestoreEsperto= GestoreEsperto.getInstance();
        gestoreSponsor=GestoreSponsor.getInstance();
        gestoreTeam=GestoreTeam.getInstance();
    }
    public void removeProgettista(int id) {

    }
    public void candidaturaProgettista(){

    }
    public void registerProgettista(String name, String surname, Curriculum curriculum) {
        Progettista p= new Progettista(name,surname,curriculum);
        GestoreProgettista.getInstance().addProgettista(p);
    }
    public void registerProponenteProgetto(String name, String surname, Curriculum curriculum){
        ProponenteProgetto p= new ProponenteProgetto(name,surname,curriculum);
        GestoreProgettista.getInstance().addProgettista(p); //?

    }
    public void registerEsperto(String name,String surname){
        Esperto esperto= new Esperto(name,surname);
        GestoreEsperto.getInstance().addEsperto(esperto);
    }
    public void registerSponsor(String name){
        Sponsor s= new Sponsor(name);
        GestoreSponsor.getInstance().addSponsor(s);
    }
    public void addProgetto(String name,int proponenteProgettoID,int nMaxProgettisti){
        Progetto p= new Progetto(proponenteProgettoID,name,nMaxProgettisti);
        GestoreProgetto.getInstance().addProgetto(p);
    }
    public void candidateProgetto(Progettista p,Progetto progetto){
        p.sendCandidatura(progetto);
    }

    public void inviteProgettista(Progettista p,Progetto progetto, ProponenteProgetto proponenteProgetto){
        proponenteProgetto.inviteProgettista(p,progetto);
    }

    public void confirmProgetto(Progetto progetto){
        progetto.confirmProgetto();
    }

    public void declineProgetto(Progetto progetto){
        progetto.declineProgetto();
    }

    public void sponsorizzaProgetto(Sponsor s, double amount, Progetto p){  }

    public List<Progettista> printProgettisti(){
        return GestoreProgettista.getInstance().getProgettisti();
    }

    public List<Progetto> printProgetti(){
        return GestoreProgetto.getInstance().getProgetti();
    }
}
