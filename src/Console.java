import java.io.IOException;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) throws IOException {
        Studio studio = new Studio();
        MenuBar menuBar = new MenuBar();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom du studio : ");
        String studioName = scanner.nextLine();
        studio.setName(studioName);
        System.out.println("Le nom du studio est : ");
        System.out.println(studio.getName());


        System.out.println("Budget du studio : ");
        String budgetStudio = scanner.nextLine();
        menuBar.setBudget(Double.parseDouble(budgetStudio));
        System.out.println("Le budget du studio est : ");
        System.out.println(menuBar.getBudget());
    }
}
