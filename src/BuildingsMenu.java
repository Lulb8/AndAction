import java.util.Scanner;

public class BuildingsMenu extends Buildings
{
    /**
     * Operation
     *
     * @return String
     */
    /*public String getActionsName (  )
    {
    }*/

    private Scanner scanner = new Scanner(System.in);

    public int checkNumber() {
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
}