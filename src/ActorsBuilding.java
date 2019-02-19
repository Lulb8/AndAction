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
        actors.add(a4);
        return actors;
    }

    public ArrayList<Director> InitializeDirectors(ArrayList<Director> directors) {
        Director d1 = new Director(), d2 = new Director(), d3 = new Director();
        d1.createDirector("Nom1",1000);
        d2.createDirector("Nom2",500);
        d3.createDirector("Nom3",1100);
        directors.add(d1);
        directors.add(d2);
        directors.add(d3);
        return directors;
    }

    public ArrayList<Actor> setActors(Movie movie) {
        ArrayList<Actor> actorsChosen = new ArrayList<Actor>();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        actors = InitializeActors(actors);
        int nbActors = movie.actors.size();
        int it = 0;
        boolean inLoop = true;
        do {
            System.out.print("Choisis un acteur en tapant son nom\n"+ actors);
            String name = sc.next();
            for (Actor a : actors) {
                if (a.name.equals(name)) {
                    System.out.print("Vous avez choisi l'acteur " + a.name);
                    actorsChosen.add(a);
                    it+=1;
                }
            }
            System.out.println("Voulez-vous ajouter un nouvel acteur (o/n)");
            inLoop = sc.nextLine().equals("o");
        } while (it<nbActors && inLoop);
        movie.setActors(actorsChosen);
        return actorsChosen;
    }

    public Director setDirector(Movie movie) {
        Director directorChosen = new Director();
        ArrayList<Director> directors = new ArrayList<Director>();
        directors = InitializeDirectors(directors);
        int nbActors = movie.actors.size();
        boolean inLoop = true;
        do {
            System.out.print("Choisis un réalisateur en tapant son nom :\n"+ directors);
            String name = sc.next();
            for (Director d : directors) {
                if (d.name.equals(name)) {
                    System.out.print("Vous avez choisi le réalisateur " + d.name);
                    directorChosen = d;
                }
            }
            System.out.println("Voulez-vous changer le réalisateur de votre film ? (o/n)");
            inLoop = sc.nextLine().equals("o");
        } while (inLoop);
        movie.setDirector(directorChosen);
        return directorChosen;
    }

    public void launchActBuild(Movie movie) {
        System.out.print("Bienvenue au bureau des acteurs !\n");
        try {
            if (movie.director==null) {
                setDirector(movie);
            }
            else {
                System.out.print("\nVoici le réalisateur de votre film :\n");
                System.out.print(movie.getDirector());
            }
            if (movie.actors.size()==0) {
                setActors(movie);
            }
            else {
                System.out.print("\nVoici les acteurs de votre film :\n");
                System.out.print(movie.actors);
            }
        } catch (Exception e) {
            System.err.println("error");
        }
    }

}
