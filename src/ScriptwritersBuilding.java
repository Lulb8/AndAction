import java.util.Scanner;

public class ScriptwritersBuilding extends BuildingsMenu{


    private boolean inSwBuilding;
    Scanner scanner = new Scanner(System.in);
    Movie currentMovie = new Movie();

    public Movie launchScriptwriter() {
        System.out.println("Bienvenue au bâtiment des scénaristes !");
        inSwBuilding = true;
        while (inSwBuilding) {
            System.out.println("1: Choisir le titre du film\n2: Choisir un scénariste\n3: Sortir du bâtiment");
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
}
