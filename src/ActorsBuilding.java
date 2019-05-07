import java.util.*;

public class ActorsBuilding extends BuildingsMenu{

    private boolean inSwBuilding;
    Scanner scanner = new Scanner(System.in);
    Actors actorsChosen=new Actors();
    Actors actors;



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

    public Actors setActors() {
        actors=new Actors();
        actors.InitializeActors();
        actorsChosen = new Actors();
        //int nbActors = movie.actors.size();
        //int it = 0;
        boolean inLoop = true;
        do {
            System.out.print("Choisis un acteur en tapant son nom\n"+ actors);
            String name = scanner.next();
            for (Actor a : actors.getActors()) {
                if (a.getName().equals(name)) {
                    System.out.print("Vous avez choisi l'acteur " + a.getName()+"\n");
                    actorsChosen.addActor(a);
                    //it+=1;
                }
            }
            System.out.println("Voulez-vous ajouter un nouvel acteur (o/n)"+actorsChosen.toString());
            /*
            inLoop = scanner.nextLine().equals("o");
             */
            inLoop=false;
        } while (/*it<nbActors &&*/ inLoop);
        return actorsChosen;
    }

    public Director setDirector(Movie movie) {
        Director directorChosen = new Director();
        ArrayList<Director> directors = new ArrayList<Director>();
        directors = InitializeDirectors(directors);
        System.out.println(directors);
        boolean inLoop = true;
        do {
            System.out.print("Choisis un réalisateur en tapant son nom :\n");
            printDirectors(directors);
            String name = scanner.next();
            for (Director d : directors) {
                if (d.name.equals(name)) {
                    System.out.print("Vous avez choisi le réalisateur " + d.getName());
                    directorChosen = d;
                }
            }
            System.out.println("Voulez-vous changer le réalisateur de votre film ? (o/n)");
            inLoop = scanner.nextLine().equals("o");
        } while (inLoop);
        movie.setDirector(directorChosen);
        return directorChosen;
    }

    public Movie launchActBuild(Movie currentMovie) {
        System.out.print("Bienvenue au bureau des acteurs !\n");
        inSwBuilding = true;
        while (inSwBuilding) {
            System.out.println("1: Choisir des acteurs\n2: Choisir un réalisateur\n3: Sortir du bâtiment");
            int choice = this.checkNumber();
            this.selectChoice(choice,currentMovie);
        }
        return currentMovie;
        //System.out.print("\nVoici le réalisateur de votre film :\n");
            //System.err.println("Aucun réalisateur choisi");
            //setDirector(movie);
        }

    private void selectChoice (int choice,Movie currentMovie) {
        switch (choice){
            case 1: //choisir les acteurs
                /*
                System.out.println("Quelle est le titre de votre film ?");
                String title = scanner.next();
                System.out.println("Le titre de votre nouveau film est " + title);
                currentMovie.setName(title);
                currentMovie.setState(0);
                */
                //if ((currentMovie.getState())==0) {
                if (!currentMovie.getName().equals(null)) {
                currentMovie.setActors(this.setActors());  }
                /*
                }
                else if (currentMovie.getState()==1) {
                    System.out.print("Votre film est en tournage");
                }
                else {
                    System.out.print("Rendez-vous au bureau des scénaristes pour créer ton film");

                }
                */
                break;

            case 2://choisir un scénariste
                System.out.println("Quelle est le scénariste de votre film ?");
                String swName = scanner.next();
                System.out.println("Le titre de votre nouveau scénariste est " + swName);

                break;
            case 3://quitter le bâtiment
                inSwBuilding = false;
                System.out.println("Vous avez quitté le bâtiment des scénaristes.");
                break;
            default:
                System.out.println("Veuillez entrer un caractère valable !");
                break;
        }
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


