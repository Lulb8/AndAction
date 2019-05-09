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

    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    /*
    public void chooseActor(Actor actorChoosen) {
        if(actors.contains(actorChoosen)) {

            actors.remove(actorChoosen);
        }
    }
    */

    public void initializeActors() {
        Actor a1 = new Actor(), a2 = new Actor(), a3 = new Actor(), a4 = new Actor();
        a1.createActor("Melanie",1000,"rousse");
        a2.createActor("Kevin",500,"grand");
        a3.createActor("Léo",1100,"brun");
        a4.createActor("Sofia",850,"musclée");
        actors.add(a1);
        actors.add(a2);
        actors.add(a3);
        actors.add(a4);
    }

    @Override
    public String toString() {
        String string=new String();
        for (Actor a : actors) {
            string += a.toString();
        }
        return string;
    }




    /*
    public void toString(ArrayList<Actor> actors) {
        for (Actor a : actors) {
            System.out.print(a);
        }
    }
    */


}
