public class Blocked extends AbstractState{
    Progetto progetto;

    public Blocked(Progetto p){
        this.progetto=p;
    }

    @Override
    public void changeState(IState newState) {
        progetto.setState(newState);
    }
}
