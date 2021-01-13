import java.util.List;

public class GestoreEsperto {

    private List<Esperto> esperti;

    public GestoreEsperto(){ }

    public Esperto getSingleEsperto(int ID){
        return esperti.stream()
                .filter(e -> e.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Esperto> getEsperti(){
        return esperti;
    }

    public void addEsperto(Esperto e){
        esperti.add(e);
    }

    public void removeEsperto(Esperto e){
        esperti.remove(e);
    }
}
