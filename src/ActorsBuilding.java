import java.util.*;

public class ActorsBuilding {

    Scanner sc = new Scanner(System.in);

    public ArrayList<Actor> InitializeActors(ArrayList<Actor> actors) {
        Actor a1 = new Actor(), a2 = new Actor(), a3 = new Actor(), a4 = new Actor();
        a1.createActor("Nom1",1000,"red-haired");
        a2.createActor("Nom2",500,"blond-haired");
        a3.createActor("Nom3",1100,"tall");
        a4.createActor("Nom4",850,"fit and black-haired");
        actors.add(a1);
        actors.add(a2);
        actors.add(a3);
        actors.add(a3);
        return actors;
    }

    public int getNbActor(Movie movie) {  //TODO à déduire des acteurs choisis
        System.out.print("Choisis un nombre d'acteurs pour ton film");
        int nb = sc.nextInt();
        movie.setNumberOfActors(nb);
        return nb;
    }

    public ArrayList<Actor> setActors(Movie movie, int nb, ArrayList<Actor> actors) {
        ArrayList<Actor> actorsChosen = new ArrayList<Actor>();
        int i =movie.actors.size();
        while (i<nb) {
            System.out.print("Choisis un acteur en tapant son nom\n"+ actors);
            String name = sc.next();
            for (Actor a : actors)
                if (a.name.equals(name)) {
                    System.out.print("Vous avez choisi l'acteur " + a.name);
                    actorsChosen.add(a);
                    i =movie.actors.size();
                }
        }
        movie.actors=actorsChosen;
        return actorsChosen;
    }

}
