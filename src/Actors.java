import java.util.ArrayList;
import java.util.List;

public class Actors{


    public ArrayList<Actor> actors = new ArrayList<Actor>();
    public int nbActors=actors.size(); //nombre d'acteurs


    /**
     * @return
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * @param actors
     */
    public void setActors(ArrayList<Actor> actors) {

        this.actors = actors;
    }

    public void addActor(Actor newActor) {
        actors.add(newActor);
    }

    public void InitializeActors() {
        Actor a1 = new Actor(), a2 = new Actor(), a3 = new Actor(), a4 = new Actor();
        a1.createActor("Nom1",1000,"red-haired");
        a2.createActor("Nom2",500,"blond-haired");
        a3.createActor("Nom3",1100,"tall");
        a4.createActor("Nom4",850,"fit and black-haired");
        actors.add(a1);
        actors.add(a2);
        actors.add(a3);
        actors.add(a4);
    }

    @Override
    public String toString() {
        return "Actors{" +
                "actors=" + actors +
                '}';
    }




    /*
    public void toString(ArrayList<Actor> actors) {
        for (Actor a : actors) {
            System.out.print(a);
        }
    }
    */


}
