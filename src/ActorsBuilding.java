import java.util.*;

public class ActorsBuilding extends BuildingsMenu{

    private boolean inSwBuilding;
    Scanner scanner = new Scanner(System.in);
    Actors actorsChosen=new Actors();
    Actors actors=new Actors();
    ArrayList<Director> directors= new ArrayList<>();


    public Movie launchActBuild(Movie currentMovie) {
        if (currentMovie.getState()==0) {
            actors.initializeActors();
        }
        directorsAvailable(directors);
        System.out.print("Bienvenue au bureau des acteurs !\n");
        inSwBuilding = true;
        while (inSwBuilding) {
                System.out.println("1: Choisir des acteurs\n2: Choisir un réalisateur\n3: Sortir du bâtiment");
                int choice = this.checkNumber();
                this.selectChoice(choice,currentMovie);
        }
        return currentMovie;
    }

    private void selectChoice (int choice,Movie currentMovie) {
        switch (choice){
            case 1: //choisir les acteurs
                currentMovie.setActors(this.setActors());
                currentMovie.setState(10);
                break;

            case 2://choisir un réalisateur
                currentMovie.setDirector(setDirector());
                break;
            case 3://quitter le bâtiment
                inSwBuilding = false;
                System.out.println("Vous avez quitté le bâtiment des acteurs.");
                break;
            default:
                System.out.println("Veuillez entrer un caractère valable !");
                break;
        }
    }

    private Actors setActors() {
        //int nbActors = movie.actors.size();
        //int it = 0;
        boolean inLoop = true;
        do {
            System.out.print(actors.toString()+"    Choisis un acteur en tapant son nom.\n");
            String name = scanner.next();
            Actor actorChosen = new Actor();
            for (Actor a : actors.getActors()) {
                if (a.getName().equals(name)) {
                    System.out.print("Vous avez choisi " + a.getName()+" comme acteur(e)\n");
                    actorsChosen.addActor(a);
                    //it+=1;
                    actorChosen=a;
                }
            }
            actors.removeActor(actorChosen);
            System.out.println("Voulez-vous ajouter un nouvel acteur (o/n)");
            inLoop = scanner.next().equals("o");
        } while (/*it<nbActors &&*/ inLoop);
        return actorsChosen;
    }

    private Director setDirector() {
            System.out.print(directors +"    Choisis un réalisateur en tapant son nom.\n");
            String name = scanner.next();
            Director directorChosen = new Director();
            for (Director d : directors) {
                if (d.getName().equals(name)) {
                    System.out.print("Vous avez choisi " + d.getName()+" comme réalisateur(e)\n");
                    directorChosen = d;
                }
            }
        return directorChosen;
    }

    public ArrayList<Director> directorsAvailable(ArrayList<Director> directors) {
        Director d1 = new Director(), d2 = new Director(), d3 = new Director();
        d1.createDirector("Nom1",1000);
        d2.createDirector("Nom2",500);
        d3.createDirector("Nom3",1100);
        directors.add(d1);
        directors.add(d2);
        directors.add(d3);
        return directors;
    }

        /*
            if (movie.getActors().size()==0) {
                setActors(movie);
            }
            else {
                System.out.print("\nVoici les acteurs de votre film :\n");
                System.out.print(movie.actors);
            }
     */

/*
        if (movie.getDirector()==null) {
                System.out.println("Aucun réalisateur pour votre film n'a été choisi pour le moment.");
                setDirector(movie);
                }
                if (movie.getActors()==null) {
                System.out.println("No actors");
                */
}


