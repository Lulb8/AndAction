import java.util.*;

public class ActorsBuilding extends BuildingsMenu {

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

    public void printActors(ArrayList<Actor> actors) {
        for (Actor a : actors) {
            System.out.print(getActor(a));
        }
    }

    public Actor getActor(Actor a) {
        return a;
    }

    public void printDirectors(ArrayList<Director> directors) {
        for (Director d : directors) {
            System.out.print(getDirector(d));
        }
    }

    public Director getDirector(Director d) {
        return d;
    }

    public ArrayList<Actor> setActors(Movie movie) {
        ArrayList<Actor> actorsChosen = new ArrayList<Actor>();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        actors = InitializeActors(actors);
        int nbActors = movie.getActors().size();
        int it = 0;
        boolean inLoop = true;
        do {
            System.out.print("Choisis un acteur en tapant son nom\n");
            printActors(actors);
            String name = sc.next();
            for (Actor a : actors) {
                if (a.getName().equals(name)) {
                    System.out.print("Vous avez choisi l'acteur " + a.getName()+"\n");
                    actorsChosen.add(getActor(a));
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
        boolean inLoop = true;
        do {
            System.out.print("Choisis un réalisateur en tapant son nom :\n");
            printDirectors(directors);
            String name = sc.next();
            for (Director d : directors) {
                if (d.getName().equals(name)) {
                    System.out.print("Vous avez choisi le réalisateur " + d.getName());
                    directorChosen = d;
                }
            }
            System.out.println("\nVoulez-vous changer le réalisateur de votre film ? (o/n)");
            String scan = sc.nextLine();
            inLoop = scan.equals("o");
        } while (inLoop);
        movie.setDirector(directorChosen);
        return directorChosen;
    }

    public void launchActBuild(Movie movie) {

        System.out.print("Bienvenue au bureau des acteurs !\n");
        boolean inPPBuilding = true;
        while (inPPBuilding) {
            System.out.print("Voici le réalisateur de votre film :\n");
            System.out.println(movie.getDirector()+"\n");
            System.out.print("Voici les acteurs de votre film :\n");
            System.out.println(movie.getActors()+"\n");

            if (movie.getDirector()==null) {
                System.out.println("Aucun réalisateur pour votre film n'a été choisi pour le moment.\n");
                setDirector(movie);
            }
            if (movie.getActors()==null) {
                System.out.println("Aucun acteurs pour votre film n'a été choisi pour le moment.");
                setActors(movie);
            }

             System.out.println("1. Changer le réalisateur de votre film?\n" +
                           "2. Changer les acteurs de votre film" +
                           "3. Quitter");
             switch (this.checkNumber()){
                 case 1:
                    setDirector(movie);break;
                 case 2:
                    setActors(movie);break;
                case 3:
                    inPPBuilding=false;break;
             }
        }
    }
}


