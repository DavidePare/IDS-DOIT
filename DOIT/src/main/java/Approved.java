public class Approved extends AbstractState{
    Progetto progetto;

    public Approved(Progetto p){
        this.progetto=p;
    }

    @Override
    public void changeState(IState newState) {
        progetto.setState(newState);
    }

    /**
     * Metodo che permetterà di aggiungere una somma di denaro dentro allo stato del progetto
     * @param amount
     */
    @Override
    public void incrementAmount(double amount){
        progetto.setAmount(progetto.getAmount()+amount);
    }

    /**
     * Metodo che rimuoverà una cifra di denaro dal progetto
     * @param amount
     */
    @Override
    public void decrementAmount(double amount){
        progetto.setAmount(progetto.getAmount()-amount);
    }

    /**
     * Aggiunta del candidato alla lista dei candidati
     * @param progettista
     */
    @Override
    public void addCandidato(Progettista progettista){
        progetto.getCandidati().add(progettista.getID());
    }

    /**
     * Rimozione del candidato dalla lista
     * @param progettista
     */
    @Override
    public void removeCandidato(Progettista progettista){
        progetto.getCandidati().remove(progettista.getID());
    }


}
