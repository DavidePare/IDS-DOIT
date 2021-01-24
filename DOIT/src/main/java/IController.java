import java.util.List;

public interface IController {
    void removeProgettista(int id);
    void candidaturaProgettista();
    void registerProgettista(String name, String surname, Curriculum curriculum);
    void registerProponenteProgetto(String name, String surname, Curriculum curriculum);
    void registerEsperto(String name,String surname);
    void registerSponsor(String name);
    void addProgetto(String name,int proponenteProgettoID,int nMaxProgettisti);
    void candidateProgetto(Progettista p, Progetto progetto);
    void inviteProgettista(Progettista p,Progetto progetto, ProponenteProgetto proponenteProgetto);
    void confirmProgetto(Progetto progetto);
    void declineProgetto(Progetto progetto);
    void sponsorizzaProgetto(Sponsor s, double amount, Progetto p);
    List<Progettista> printProgettisti();
    List<Progetto> printProgetti();

}
