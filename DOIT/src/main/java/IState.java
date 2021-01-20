public interface IState {
    void confirm();
    void decline();
    void incrementAmount(double amount);
    void decrementAmount(double amount);
    void addCandidato(Progettista progettista);
    void removeCandidato(Progettista progettista);
}
