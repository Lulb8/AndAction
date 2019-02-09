import java.io.IOException;

public class Console {

    public static void main(String[] args) {
        Studio studio = new Studio();
        MenuBar menuBar = new MenuBar();
        Launch launch = new Launch();

        launch.initialize(studio, menuBar);
        launch.loop();
    }
}
