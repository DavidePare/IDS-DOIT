public class Esperto {

    private int id;

    private String name;

    private String surname;

    public Esperto(){ }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void confirmProgetto(Progetto p){
        p.confirm();
    }

    public void declineProgetto(Progetto p){
        p.decline();
    }

}
