public class Blocked extends AbstractState{
    Progetto progetto;
    @Override
    public void changeState(IState newState) {

    }
    public Blocked(Progetto p){
        this.progetto=p;
    }
}
