import java.util.ArrayList;

public class Actors{


    private ArrayList<Actor> actors = new ArrayList<Actor>();
    //public int nbActors=actors.size(); //nombre d'acteurs


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
        Actor a1 = new Actor(), a2 = new Actor(), a3 = new Actor(), a4 = new Actor(),a5=new Actor();
        a1.createActor("Bad Pitt",1000,"roux");
        a2.createActor( "Robert Downey Senior",500,"grand");
        a3.createActor( "Michael J.Box",1100,"brun");
        a4.createActor( "Nathalie Porthomme",850,"musclée");
        a5.createActor( "Angelina Moche",850,"laide");
        actors.add(a1);
        actors.add(a2);
        actors.add(a3);
        actors.add(a4);
    }

    @Override
    public String toString() {
        String string=new String();
        for (Actor a : this.getActors()) {
            string += a.toString();
        }
        return string;
    }


    public Actors addActor(String nameActor) {
        Actors actors = new Actors();
        actors.initializeActors();
        for (Actor a : this.getActors()) {
            if (a.getName().equals(nameActor)) {
                System.out.print("Vous avez choisi " + a.getName()+" comme acteur(e)\n");
                this.addActor(a);
            }
        }
        return this;
    }


}
