import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends Window {

    //JLabel label = new JLabel("Jeu");
    private static int xy = 10;


    public GameWindow() {
        super();
        game();
    }

    public void game() {
        this.panel = new JPanel();
        //this.button = new JButton("START");
        //this.pan = new Panel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setBackground(Color.WHITE);

        //place le texte au centre de la fenetre
        //this.panel.add(this.pan, BorderLayout.CENTER); //centre sur l'horizontal
        //this.panel.add(this.button, BorderLayout.SOUTH);  //place la phrase en bas

        //this.button.setPreferredSize(new Dimension(10, 60));
        //this.button.addActionListener(new ButtonListener());


        //Font police = new Font("Tahoma", Font.BOLD, 30);
        //this.label.setFont(police);
        //this.label.setForeground(Color.BLACK);
        //this.label.setHorizontalAlignment(JLabel.CENTER);
        //this.panel.add(new AfficheImage("game_background.png"));

        //this.panel.add(this.label, BorderLayout.CENTER); //Affiche la phrase

        //this.frame.setContentPane(panel);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("game_background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.frame.setContentPane(new MyCanvas(img));

        run();
    }

/*
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            label.setText("Vous avez cliqué sur le bouton");
        }
    }
*/
/*
    class AfficheImage extends JPanel {
        Image eau;

        AfficheImage(String s) {
            eau = getToolkit().getImage(s);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(eau, 0, 0, getWidth(), getHeight(), this);
        }
    }
*/


    private static class MyCanvas extends JComponent implements MouseListener {
        // position de la première zone
        private static final Rectangle AREA_1 = new Rectangle(450, 140, 450, 280);
        // position de la deuxieme zone
        private static final Rectangle AREA_2 = new Rectangle(1100, 140, 450, 280);
        // position de la troisieme zone
        private static final Rectangle AREA_3 = new Rectangle(150, 500, 700, 350);
        // position de la quatrieme zone
        private static final Rectangle AREA_4 = new Rectangle(1180, 480, 550, 300);
        // image à dessiner
        private BufferedImage buff = null;

        public MyCanvas(BufferedImage img) {
            this.addMouseListener(this);
            this.buff = img;
        }

        public void paintComponent(Graphics g) {
            g.drawImage(buff, 0, 0, buff.getWidth(), buff.getHeight(), this); // dessine l'image
            g.setColor(Color.GREEN); //couleur de la zone
            g.drawRect(AREA_1.x, AREA_1.y, AREA_1.width, AREA_1.height);
            g.drawRect(AREA_2.x, AREA_2.y, AREA_2.width, AREA_2.height);
            g.drawRect(AREA_3.x, AREA_3.y, AREA_3.width, AREA_3.height);
            g.drawRect(AREA_4.x, AREA_4.y, AREA_4.width, AREA_4.height);
        }

        private void testLocation(Point mouse, Rectangle area, String nameBuilding) {
            // test si la souris est dans les data de l'image
            if (area.contains(mouse)) {
                this.add(new MiniFenetre(nameBuilding));
            } else {
                System.out.println("La case n'a pas été cliqué.");
            }
        }

        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint(); //récupération de la position de la souris
            testLocation(p, AREA_1, "Bureau des acteurs et réalisateurs");
            testLocation(p, AREA_2, "Bureau de la post-production");
            testLocation(p, AREA_3, "Plateau de tournage");
            testLocation(p, AREA_4, "Bureau des scénaristes");
        }

        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) { }
        public void mouseExited(MouseEvent e) { }
    }

    static class MiniFenetre extends JInternalFrame {
        public MiniFenetre(String nameBuilding) {
            this.setTitle("Fenetre N°" + nameBuilding);
            this.setClosable(true);
            this.setResizable(true);
            this.setSize(150, 80);
            this.setLocation(xy, xy);
            this.setVisible(true);
        }
    }
}

