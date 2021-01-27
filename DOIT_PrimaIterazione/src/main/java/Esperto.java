public class Esperto {

    private int id;

    private String name;

    private String surname;

    public Esperto(String name, String surname){
        this.name= name;
        this.surname= surname;
    }

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
        p.confirmProgetto();
    }

    public void declineProgetto(Progetto p){ p.declineProgetto(); }


}
