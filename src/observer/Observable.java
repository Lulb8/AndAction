package observer;

public interface Observable {
    void addObservateur(Observer obs);
    void updateObservateur();
    void delObservateur();
}