public class ConsoleView implements IView {
    public void start(IController controller){
        System.out.println("Open");
        menu();
    }

    public void menu(){
        System.out.println("1) Registrazione");
        System.out.println("2) Login");
        System.out.println("3) Inserimento progetto");
        System.out.println("4) Visualizza progetti");
        System.out.println("5) Sponsorizza progetto");
        System.out.println("6) Candidatura a progetto");
        System.out.println("7) Invitare Progettista");
        System.out.println("8) ");
    }

    public void registrazione(){
        //1-->Progettista 2--> proponenteProge 3-->  4
    }

    public void stop(){}
}
