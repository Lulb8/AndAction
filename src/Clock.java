import observer.Observable;
import observer.Observer;

import java.util.ArrayList;
import java.util.Calendar;

public class Clock implements Observable {
    //On récupère l'instance d'un calendrier
    //Elle va nous permettre de récupérer l'heure actuelle
    private Calendar cal;
    private String hour = "";
    //Notre collection d'observateurs
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();

    public void run() {
        while(true){
            this.cal = Calendar.getInstance();
            this.hour =  //Les heures
                    this.cal.get(Calendar.HOUR_OF_DAY) + " : "
                            +
                            (      //Les minutes
                                    this.cal.get(Calendar.MINUTE) < 10
                                            ? "0" + this.cal.get(Calendar.MINUTE)
                                            : this.cal.get(Calendar.MINUTE)
                            )
                            + " : "
                            +
                            (      //Les secondes
                                    (this.cal.get(Calendar.SECOND)< 10)
                                            ? "0"+this.cal.get(Calendar.SECOND)
                                            : this.cal.get(Calendar.SECOND)
                            );
            //On avertit les observateurs que l'heure a été mise à jour
            this.updateObservateur();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Ajoute un observateur à la liste
    public void addObservateur(Observer obs) {
        this.listObserver.add(obs);
    }
    //Retire tous les observateurs de la liste
    public void delObservateur() {
        this.listObserver = new ArrayList<Observer>();
    }
    //Avertit les observateurs que l'objet observable a changé
    //et invoque la méthode update() de chaque observateur
    public void updateObservateur() {
        for(Observer obs : this.listObserver)
            obs.update(this.hour);
    }
}