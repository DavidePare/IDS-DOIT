public abstract class AbstractState implements IState {
    public void confirm(){

    }
    public void decline(){

    }
    public void incrementAmount(double amount){

    }
    public void decrementAmount(double amount){

    }
    public void addCandidato(Progettista progettista){

    }
    public void removeCandidato(Progettista progettista){

    }
    public abstract void changeState(IState newState);
}
