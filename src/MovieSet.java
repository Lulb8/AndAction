import java.util.ArrayList;

public class MovieSet extends  BuildingsMenu {

    private boolean inMovieSetBuilding;
    public ArrayList<Movie> movieFilming;
    int state;


    public void launchMovieSet(Movie currentMovie) {
        System.out.println("Bienvenue au plateau de tournage !");
        inMovieSetBuilding = true;
        while (inMovieSetBuilding) {
            System.out.println("1: Afficher les caractéristiques du film\n"
                    + "2: Sortir du bâtiment");
            int choice = this.checkNumber();
            int status = this.state;
            this.selectChoice(choice,status, currentMovie);
        }
    }

    private void selectChoice(int choice,int status, Movie currentMovie) {
        switch (choice) {
            case 1: //afficher caractéristiques du film
                //Movie currentMovie = movieFilming.get(movieFilming.size() - 1); //TODO Recuperer le film créé dans les autres batiments
                currentMovie.toString(); //TODO
                status = currentMovie.getState();

                if (currentMovie == null) {
                    System.out.println("Le statut du film est :"+status);
                    System.out.println("Aucun film n'a été commencé pour le moment");
                } else {
                    System.out.println(currentMovie.toString());
                    }

                break;

            case 2: //quitter le bâtiment
                inMovieSetBuilding = false;
                System.out.println("Vous avez quitté le plateau de tournage.");
                break;
            default:
                System.out.println("Veuillez entrer un caractère valable !");
                break;
        }
    }
}
