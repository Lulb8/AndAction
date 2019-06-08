import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends Window {

    public GameWindow(Studio studio) {
        super();
        game();
    }

    public void game() {
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setBackground(Color.WHITE);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("game_background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.frame.setContentPane(new MyCanvas(img));

        //musique qui joue pendant le jeu:
        File musicFile = new File("PST_IntoTheWoods.wav");
        Sound music = new Sound();
        music.PlaySound(musicFile);

        run();
    }

    private static class MyCanvas extends JComponent implements MouseListener {
        // position de la première zone
        private static final Rectangle AREA_1 = new Rectangle(450, 140, 450, 280);
        // position de la deuxieme zone
        private static final Rectangle AREA_2 = new Rectangle(1100, 140, 450, 280);
        // position de la troisieme zone
        private static final Rectangle AREA_3 = new Rectangle(150, 500, 700, 350);
        // position de la quatrieme zone
        private static final Rectangle AREA_4 = new Rectangle(1180, 480, 550, 300);
        // position de la cinquieme zone
        private static final Rectangle AREA_5 = new Rectangle(30, 120, 150, 300);
        // image à dessiner
        private BufferedImage buff = null;

        Studio studio;
        private Movie currentMovie;

        public MyCanvas(BufferedImage img) {
            this.addMouseListener(this);
            this.buff = img;
        }

        public void paintComponent(Graphics g) {
            g.drawImage(buff, 0, 0, buff.getWidth(), buff.getHeight(), this); // dessine l'image
            int alpha = 0; // 100% transparent
            Color transparent = new Color(255, 255, 255, alpha);
            g.setColor(transparent); //couleur du cadre
            g.drawRect(AREA_1.x, AREA_1.y, AREA_1.width, AREA_1.height);
            g.drawRect(AREA_2.x, AREA_2.y, AREA_2.width, AREA_2.height);
            g.drawRect(AREA_3.x, AREA_3.y, AREA_3.width, AREA_3.height);
            g.drawRect(AREA_4.x, AREA_4.y, AREA_4.width, AREA_4.height);
            g.drawRect(AREA_5.x, AREA_5.y, AREA_5.width, AREA_5.height);
        }

        ScriptwritersBuildingWindow scriptwritersBuilding = new ScriptwritersBuildingWindow();
        ActorsBuildingWindow actorsBuilding = new ActorsBuildingWindow();
        MovieSetWindow movieSet = new MovieSetWindow();
        PostProdBuildingWindow postProd = new PostProdBuildingWindow();
        private void testLocation(Point mouse, Rectangle area, String nameBuilding, int numBuilding) {
            if (area.contains(mouse)) {
                this.removeAll();
                switch (numBuilding) {
                    case 1:
                        this.add(actorsBuilding);
                        if (!currentMovie.equals(null)) {
                            actorsBuilding.ActorsBuildingWindow(currentMovie);
                            currentMovie.setActors(actorsBuilding.getActors());
                            currentMovie.setDirector(actorsBuilding.getDirector());
                            currentMovie.setTechnicalCrew(actorsBuilding.getTechnicalCrew());
                    }
                        break;
                    case 2:
                        this.add(postProd);
                        postProd.PostProdBuildingWindow(currentMovie);
                        currentMovie.setState(1);
                        break;
                    case 3:
                        this.add(movieSet);
                        currentMovie=movieSet.MovieSetWindow(currentMovie);
                        break;
                    case 4:
                        this.add(scriptwritersBuilding);
                        currentMovie=scriptwritersBuilding.ScriptwritersBuildingWindow(studio);
                        break;
                    case 5:
                        MenuWindow menuWindow = new MenuWindow(studio);
                        break;
                    default:
                        System.out.println("Ce batiment n'existe pas !!!");
                        break;
                }
            } else {
                System.out.println("La case " + nameBuilding + " n'a pas été cliqué.");
            }
        }

        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint(); //récupération de la position de la souris
            testLocation(p, AREA_1, "Bureau des acteurs et réalisateurs", 1);
            testLocation(p, AREA_2, "Bureau de la post-production", 2);
            testLocation(p, AREA_3, "Plateau de tournage", 3);
            testLocation(p, AREA_4, "Bureau des scénaristes", 4);
            testLocation(p, AREA_5, "Studio", 5);
        }

        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) { }
        public void mouseExited(MouseEvent e) { }
    }
}

