import java.util.ArrayList;

public class PostProdBuilding extends  BuildingsMenu {

    public ArrayList<Movie> moviesDone;
    private boolean inPPBuilding;

    public void launchPostProd() {
        System.out.println("Bienvenue au bâtiment de la post-production !");
        inPPBuilding = true;
        while (inPPBuilding) {
            System.out.println("1: Afficher les caractéristiques du film\n" +
                    "2: Choisir un budget pour la publicité du film en cours\n3: Sortir du bâtiment");
            int choice = this.checkNumber();
            this.selectChoice(choice);
        }
    }

    private void selectChoice (int choice) {
        switch (choice){
            case 1: //afficher caractéristiques du film
                if (moviesDone == null) {
                    System.out.println("Aucun film n'a été commencé pour le moment");
                }
                else {
                    Movie lastMovie = moviesDone.get(moviesDone.size() - 1);
                    lastMovie.toString();
                }
                break;

            case 2://choisir un budget de pub
                if (moviesDone == null) {
                    System.out.println("Aucun film n'a été commencé pour le moment...\n");
                }
                else {
                    Movie lastMovie = moviesDone.get(moviesDone.size() - 1);
                    if (lastMovie.state == 1) {
                        System.out.println("Le tournage de " + lastMovie.getName() + " n'est pas encore fini, revenez "
                                + "plus tard pour choisir le budget pour la publicité du film");
                    } else {
                        System.out.println("Budget pour la publicité de " + lastMovie.getName() + " :");
                        int budgetStudio = checkNumber();
                        lastMovie.pubBudget = budgetStudio;
                        System.out.println("Le budget pour la publicité de " + lastMovie.getName() +
                                " est défini à " + lastMovie.pubBudget + " €");
                    }
                }
                break;
            case 3://quitter le bâtiment
                inPPBuilding = false;
                System.out.println("Vous avez quitté le bâtiment de post-production.");
                break;
        }
    }

}
