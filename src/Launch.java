import java.util.Scanner;

public class Launch {

    private boolean keepRunning = true;
    private Scanner scanner = new Scanner(System.in);
    Movie currentMovie;

    ScriptwritersBuilding scriptwritersBuilding = new ScriptwritersBuilding();
    ActorsBuilding actorsBuilding = new ActorsBuilding();
    MovieSet movieSet = new MovieSet();
    PostProdBuilding postProd = new PostProdBuilding();

    void initialize(Studio studio, MenuBar menuBar){
        System.out.println("Nom du studio : ");
        String studioName = scanner.nextLine();
        studio.setName(studioName);
        System.out.println("Le nom du studio est : " + studio.getName());

        System.out.println("Budget du studio : ");
        int budgetStudio = checkNumber();
        menuBar.setBudget(budgetStudio);
        System.out.println("Le budget du studio est : " + menuBar.getBudget()+ " €");
    }

    void loop(){
        while (keepRunning){
            System.out.println("Que voulez vous faire?");
            menu();
            int choice = checkNumber();
            this.launchAction(choice);
        }
    }
/*
    private String checkString(){
        String word ="";
        boolean isWord = true;
        while (isWord) {
            try {
                word = scanner.nextLine();
                if (word.length() >= 1 && word.length() <= 20) {
                    isWord = false;
                } else {
                    throw new StringLengthException("'" + word + "' doit être compris entre 1 et 20 caractères.");
                }
            } catch (StringLengthException e) { //il faut gérer l'exception
                System.out.println("Mauvaise longueur de la chaîne de caractères: " + word);
            }
        }
        return word;
    }
*/
    private int checkNumber() {
        int number = 0;
        //String input = scanner.nextLine();
        boolean isNumber = true;
        while (isNumber) {
            try {
                number = Integer.parseInt(scanner.next());
                isNumber = false;
            } catch (NumberFormatException e) {
                System.out.println("Vous devez entrer un nombre entier !");
            } finally {
                scanner.nextLine();
            }
        }
        return number;
    }

    private void launchAction(int choice){
        switch (choice){
            case 1:
                currentMovie=scriptwritersBuilding.launchScriptwriter(); //TODO ajouter le sciptwriter
                //System.out.print(currentMovie);
                break;
            case 2:
                if (currentMovie==null) {
                    System.out.print("Rendez-vous dans le bureau des scénaristes\n");
                }
                else {
                actorsBuilding.launchActBuild(currentMovie);
                }
                //System.out.print(currentMovie);
                break;
            case 3:
                movieSet.launchMovieSet(); //TODO passer en argument le film en production
                break;
            case 4:
                postProd.launchPostProd(); //TODO passer en argument le film en production
                break;
            case 5:
                boolean keepRunningQuit = true;
                while (keepRunningQuit) {
                    System.out.println("Etes-vous sûr de vouloir quitter le jeu ? (O/n)");
                    char choiceQuit = scanner.next().charAt(0);
                    if (choiceQuit == 'O') {
                        this.quitApp();
                        break;
                    } else if (choiceQuit == 'n') {
                        break;
                    } else {
                        System.out.println("Veuiller écrire O pour quitter le jeu ou n pour continuer.");
                    }
                }
                break;
            default:
                System.out.println("Ce batiment n'existe pas !");
                break;
        }
    }

    private void quitApp(){
        System.out.println("Au revoir !");
        keepRunning = false;
    }

    private void menu() {
        System.out.println("1 - Bureau des scénaristes\n" +
                "2 - Bureau des acteurs\n" +
                "3 - Plateau de tournage\n" +
                "4 - Bureau de post-production\n" +
                "5 - Quitter le jeu");
    }
}
