import java.util.ArrayList;

public class MovieSet extends  BuildingsMenu {

    private boolean inMovieSetBuilding;
    public ArrayList<Movie> movieFilming;

    public void launchMovieSet() {
        System.out.println("Bienvenue au plateau de tournage !");
        inMovieSetBuilding = true;
        while (inMovieSetBuilding) {
            System.out.println("1: Afficher les caractéristiques du film\n"
                    + "2: Sortir du bâtiment");
            int choice = this.checkNumber();
            this.selectChoice(choice);
        }
    }

    private void selectChoice(int choice) {
        switch (choice) {
            case 1: //afficher caractéristiques du film
                Movie currentMovie = movieFilming.get(movieFilming.size() - 1); //TODO Recuperer le film créé dans les autres batiments
                currentMovie.toString(); //TODO
                if (currentMovie == null) {
                    System.out.println("Aucun film n'a été commencé pour le moment");
                } else {
                    System.out.println("Le titre du film est : " + currentMovie.getName()
                            + "\nSon statut est : " + currentMovie.getState()
                            + "\nLe genre du film est : " + currentMovie.getGenre()
                            + "\nLe nombre d'acteurs du film est : " + currentMovie.getNumberOfActors()
                            + "\nLe réalisateur du film est : " + currentMovie.getDirector()
                            + "\nL'équipe du film est : " + currentMovie.getTechnicalCrew());
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
