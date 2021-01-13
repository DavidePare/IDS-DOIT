public class Sponsor {

    private int id;

    private String name;

    public Sponsor(){ }

    public void addAmount(Progetto p, double amount){
        p.incrementAmount(amount);
    }

    public void decrementAmount(Progetto p, double amount){
        p.decrementAmount(amount);
    }
}
