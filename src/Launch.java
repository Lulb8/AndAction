import java.util.EmptyStackException;
import java.util.Scanner;

public class Launch {

    private boolean keepRunning = true;
    private Scanner scanner = new Scanner(System.in);

    void initialize(Studio studio, MenuBar menuBar){
        System.out.println("Nom du studio : ");
        String studioName = scanner.nextLine();
        studio.setName(studioName);
        System.out.println("Le nom du studio est : " + studio.getName());

        System.out.println("Budget du studio : ");
        int budgetStudio = checkNumber();
        menuBar.setBudget(budgetStudio);
        System.out.println("Le budget du studio est : " + menuBar.getBudget());
    }

    void loop(){
        while (keepRunning){
            System.out.println("Que voulez vous faire?");
            int choice = checkNumber();
            this.launchAction(choice);
        }
    }

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
            } catch (StringLengthException e) {
                System.out.println("Mauvaise longueur de la chaîne de caractères: " + word);
            }
        }
        return word;
    }

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
                return number;
            }
        }
    }

    private void launchAction(int choice){
        switch (choice){
            case 1:
                System.out.println("1");break;
            case 2:
                System.out.println("2");break;
            case 3:
                System.out.println("3");break;
            case 4:
                System.out.println("4");break;
            case 5:
                System.out.println("5");break;
            case 6:
                this.quitApp();break;
            default:
                System.out.println("Ce batiment n'existe pas !");break;
        }
    }

    private void quitApp(){
        System.out.println("Au revoir !");
        keepRunning = false;
    }
}
