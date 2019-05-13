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

    JLabel label = new JLabel("Jeu");

    public GameWindow() {
        super();
        game();
    }

    public void game() {
        this.panel = new JPanel();
        this.button = new JButton("START");
        this.pan = new Panel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setBackground(Color.WHITE);

        //place le texte au centre de la fenetre
        this.panel.add(this.pan, BorderLayout.CENTER); //centre sur l'horizontal
        this.panel.add(this.button, BorderLayout.SOUTH);  //place la phrase en bas

        this.button.setPreferredSize(new Dimension(10, 60));
        this.button.addActionListener(new ButtonListener());


        Font police = new Font("Tahoma", Font.BOLD, 30);
        this.label.setFont(police);
        this.label.setForeground(Color.BLACK);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.panel.add(new AfficheImage("game_background.png"));

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

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            label.setText("Vous avez cliqué sur le bouton");

        }
    }

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



    private static class MyCanvas extends JComponent implements MouseListener {
        private static final long    serialVersionUID    = 8845913940083986438L;
        // position de la première zone de limage que l'on veut (ici elle se trouve au pixel x=450, y=140 et s'étend sur width=450 et height=280)
        private static final Rectangle    ZONE_IMAGE_1 = new Rectangle(450, 140, 450, 280);
        // position de la première zone de limage que l'on veut (ici elle se trouve au pixel x=1100, y=140 et s'étend sur width=450 et height=280)
        private static final Rectangle    ZONE_IMAGE_2 = new Rectangle(1100, 140, 450, 280);
        // position de la première zone de limage que l'on veut (ici elle se trouve au pixel x=0, y=0 et s'étend sur width=10 et height=10)
        private static final Rectangle    ZONE_IMAGE_3 = new Rectangle(150, 500, 700, 350);
        // position de la première zone de limage que l'on veut (ici elle se trouve au pixel x=100, y=100 et s'étend sur width=30 et height=20)
        private static final Rectangle    ZONE_IMAGE_4 = new Rectangle(1180, 480, 550, 300);
        // image à dessiner
        private BufferedImage buff = null;



        public MyCanvas(BufferedImage img) {
            this.addMouseListener(this);
            this.buff = img;
        }

        public void paintComponent(Graphics g) {
            // dessine l'image
            g.drawImage(buff, 0, 0, buff.getWidth(), buff.getHeight(), this);
            // juste histoire de voir ou se trouvent les zones (plus facil pour le test ^^)
            g.setColor(Color.GREEN);
            g.drawRect(ZONE_IMAGE_1.x, ZONE_IMAGE_1.y, ZONE_IMAGE_1.width, ZONE_IMAGE_1.height);
            g.drawRect(ZONE_IMAGE_2.x, ZONE_IMAGE_2.y, ZONE_IMAGE_2.width, ZONE_IMAGE_2.height);
            g.drawRect(ZONE_IMAGE_3.x, ZONE_IMAGE_3.y, ZONE_IMAGE_3.width, ZONE_IMAGE_3.height);
            g.drawRect(ZONE_IMAGE_4.x, ZONE_IMAGE_4.y, ZONE_IMAGE_4.width, ZONE_IMAGE_4.height);
        }

        private void testLocation(Point mouse, Rectangle area, String text) {
            // test si la souris est dans les data de l'image
            if(area.contains(mouse))
                System.out.println(text + " - image");
            else
                System.out.println(text + " - !image");
        }

        public void mouseClicked(MouseEvent e) {
            //récupération de la position de la souri
            Point p = e.getPoint();
            testLocation(p, ZONE_IMAGE_1, "mouseClicked - data 1");
            testLocation(p, ZONE_IMAGE_2, "mouseClicked - data 2");
            testLocation(p, ZONE_IMAGE_3, "mouseClicked - data 3");
            testLocation(p, ZONE_IMAGE_4, "mouseClicked - data 4");
        }

        public void mousePressed(MouseEvent e) {
            //récupération de la position de la souri
            Point p = e.getPoint();
            testLocation(p, ZONE_IMAGE_1, "mousePressed - data 1");
            testLocation(p, ZONE_IMAGE_2, "mousePressed - data 2");
            testLocation(p, ZONE_IMAGE_3, "mousePressed - data 3");
            testLocation(p, ZONE_IMAGE_4, "mousePressed - data 4");
        }
        public void mouseReleased(MouseEvent e) {
            //récupération de la position de la souri
            Point p = e.getPoint();
            testLocation(p, ZONE_IMAGE_1, "mouseReleased - data 1");
            testLocation(p, ZONE_IMAGE_2, "mouseReleased - data 2");
            testLocation(p, ZONE_IMAGE_3, "mouseReleased - data 3");
            testLocation(p, ZONE_IMAGE_4, "mouseReleased - data 4");
        }

        public void mouseEntered(MouseEvent e) { }
        public void mouseExited(MouseEvent e) { }

    }
}

