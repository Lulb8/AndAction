import java.util.ArrayList;

public class PostProdBuilding  {

    public ArrayList<Movie> moviesDone = null;

    public void launchPostProd() {
        System.out.println("Welcome to Post Production Building");
    }

    private void printMovieInfo() {
        if (moviesDone == null) {
            System.out.println("Aucun film n'a été commencé pour le moment");
        }
        else {
            Movie lastMovie = moviesDone.get(moviesDone.size() - 1);
            lastMovie.toString();
        }

    }

}
