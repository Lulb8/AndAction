import java.util.ArrayList;

public class PostProdBuilding extends  BuildingsMenu {

    public ArrayList<Movie> moviesDone;
    private boolean inPPBuilding;

    public void launchPostProd(Movie currentMovie, Studio studio) {
        System.out.println("Bienvenue au bâtiment de la post-production !");
        inPPBuilding = true;
        while (inPPBuilding) {
            System.out.println("1: Afficher les caractéristiques du film\n" +
                    "2: Choisir un budget pour la publicité du film en cours\n3: Sortir du bâtiment");
            int choice = this.checkNumber();
            this.selectChoice(choice, currentMovie, studio);
        }
    }

    private void selectChoice (int choice, Movie currentMovie, Studio studio) {
        switch (choice){
            case 1: //afficher caractéristiques du film
                    currentMovie.toString();
                break;

            case 2://choisir un budget de pub
                   if (currentMovie.state == 1) {
                       System.out.println("Le tournage de " + currentMovie.getName() + " n'est pas encore fini, revenez "
                               + "plus tard pour choisir le budget pour la publicité du film");
                   } else {
                       System.out.println("Le budget de votre studio est de " + studio.budget +"€.\nCombien d'argent" +
                               " souhaitez vous investir dans la publicité de " + currentMovie.getName() + " ?");
                       int budgetFilm = checkNumber();
                       if (studio.budget < budgetFilm) {
                           System.out.println("Vous n'avez pas suffisamment d'argent...");
                           selectChoice(2,currentMovie,studio);
                       } else {
                           currentMovie.pubBudget = budgetFilm;
                           studio.setBudget(studio.budget - budgetFilm);
                           System.out.println("Le budget pour la publicité de " + currentMovie.getName() +
                               " est défini à " + currentMovie.pubBudget + "€.\nIl vous reste " + studio.budget + "€ dans " +
                                   "votre studio.");
                           //moviesDone.add(currentMovie);
                           System.out.println("Votre film est fini ! Félicitations ! \nRetournez au bureau des scénaristes" +
                               "pour commencer un nouveau film.");
                         } }
                break;
            case 3://quitter le bâtiment
                inPPBuilding = false;
                System.out.println("Vous avez quitté le bâtiment de post-production.");
                break;
            default:
                System.out.println("Veuillez entrer un caractère valable !");
                break;
        }
    }

}
