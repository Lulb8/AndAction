import java.util.ArrayList;

public class MovieSet extends  BuildingsMenu {

    private boolean inMovieSetBuilding;
    public ArrayList<Movie> movieFilming;


    public void launchMovieSet() {
        System.out.println("Bienvenue au plateau de tournage !");
        inMovieSetBuilding = true;
        while (inMovieSetBuilding) {
            System.out.println("1: Afficher les caractéristiques du film\n" +
                    "2: Sortir du bâtiment");
            int choice = this.checkNumber();
            this.selectChoice(choice);
        }
    }

    private void selectChoice(int choice) {
        switch (choice) {
            case 1: //afficher caractéristiques du film
                if (movieFilming == null) {
                    System.out.println("Aucun film n'a été commencé pour le moment");
                } else {
                    Movie currentMovie = movieFilming.get(movieFilming.size() - 1);
                    currentMovie.toString();
                }
                break;

            case 2: //quitter le bâtiment
                inMovieSetBuilding = false;
                System.out.println("Vous avez quitté le bâtiment de post-production.");
                break;
        }

    }

}
