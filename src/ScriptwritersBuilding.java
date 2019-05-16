import java.util.Scanner;

public class ScriptwritersBuilding extends BuildingsMenu{


    private boolean inSwBuilding;
    Scanner scanner = new Scanner(System.in);
    Movie currentMovie = new Movie();

    public Movie launchScriptwriter() {
        System.out.println("Bienvenue au bâtiment des scénaristes !");
        inSwBuilding = true;
        while (inSwBuilding) {
            System.out.println("1: Choisir le titre du film\n2: Choisir un scénariste\n3: Choisir un genre\n4: Sortir du bâtiment");
            int choice = this.checkNumber();
            this.selectChoice(choice);
        }
        return currentMovie;
    }

    private void selectChoice (int choice) {
        switch (choice){
            case 1: //choisir le titre du film
                System.out.println("Quelle est le titre de votre film ?");
                String title = scanner.next();
                System.out.println("Le titre de votre nouveau film est " + title);
                currentMovie.setName(title);
                currentMovie.setState(0);
                break;

            case 2://choisir un scénariste
                Scriptwriter scriptwriter = new Scriptwriter();
                System.out.println("Quelle est le scénariste de votre film ?");
                String swName = scanner.next();
                System.out.println("Le nom de votre nouveau scénariste est " + swName);
                scriptwriter.setName(swName);
                currentMovie.setScriptwriter(scriptwriter);
                currentMovie.setState(0);
                break;

            case 3://choisir un genre
                //currentMovie.setGenres(this.setGenres());
                //currentMovie.setState(0);
                System.out.println("Quelle est le genre de votre film ?");
                String genre = scanner.next();
                System.out.println("Le genre de votre film est " + genre);
                currentMovie.setGenre(genre);
                currentMovie.setState(0);
                break;

            case 4://quitter le bâtiment
                inSwBuilding = false;
                System.out.println("Vous avez quitté le bâtiment des scénaristes.");
                break;

            default:
                    System.out.println("Veuillez entrer un caractère valable !");
                    break;
        }

  /*      private Actors setActors(){
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
          //  } while (/*it<nbActors &&*/ //inLoop);
           // return actorsChosen;
        }
    }


/*
    public ArrayList<Scriptwriter> InitializeScriptwriter(ArrayList<Scriptwriter> scriptwriters) {
    System.out.println("Choisissez votre scénariste");
        Scriptwriter a = new Scriptwriter(),b = new Scriptwriter(), c = new Scriptwriter();
        a.createScriptwriter("Nom1",1000,"ACTION");
        b.createScriptwriter("Nom2",500,"COMEDY");
        c.createScriptwriter("Nom3",1100,"ADVENTURE")
        Scriptwriters.add(a1);
        Scriptwriters.add(a2);
        Scriptwriters.add(a3);
        return scriptwriters;
    }
*/

