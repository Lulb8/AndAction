import java.util.ArrayList;

public class Console {

    public static void main(String[] args) {
        Studio studio = new Studio();
        studio.moviesDone = new ArrayList<Movie>();
        //MenuBar menuBar = new MenuBar();
        Launch launch = new Launch();
        int state=-1; //état du film: 0 si le tournage n'a pas commencé, 1 si il est en tournage, 2 s'il est fini

        launch.initialize(studio);//, menuBar
        launch.loop(studio);
    }
}
