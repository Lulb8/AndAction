import java.util.ArrayList;

public class PostProdBuilding extends  BuildingsMenu {

    public ArrayList<Movie> moviesDone;

    public void launchPostProd() {
        System.out.println("Welcome to the Post Production Building");
        printMovieInfo();
        System.out.println("0: Sortir du bâtiment");


    }

    private void printMovieInfo() {
            if (moviesDone == null) {
                System.out.println("Aucun film n'a été commencé pour le moment");
            }
            else {
                Movie lastMovie = moviesDone.get(moviesDone.size() - 1);
                if (lastMovie.state == 1) {
                    System.out.println("Le tournage de " + lastMovie.getName() + " n'est pas encore fini, revenez "
                            + "plus tard pour choisir le budget pour la publicité du film");
                } else {
                    System.out.println("1: Afficher les caractéristiques du film");
                    System.out.println("2: Choisir un budget pour la publicité de " + lastMovie.getName());
                }
        }

    }

}
