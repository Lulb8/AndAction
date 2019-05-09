import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background extends JPanel {

    private String filePath;

    public Background(String background){
        this.filePath = background;
    }

    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("game_background.png"));
            //g.drawImage(img, 0, 0, this);
            //Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*
    public class ImageFond extends JFrame {
        private Container c;
        private JPanel imagePanel;
        private String filePath;

        public ImageFond(String filePath) {
            super("Image de fond");
            this.filePath = filePath;
            initialize();
        }

        private void initialize() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            c = getContentPane();
            imagePanel = new JPanel() {
                public void paint(Graphics g) {
                    try {
                        BufferedImage image = ImageIO.read(new File(filePath));
                        g.drawImage(image, 0, 0, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            imagePanel.setPreferredSize(new Dimension(640, 480));
            c.add(imagePanel);
        }

        public static void main(String[] args) {
            String imagePath = "C:/bellucci.jpg";
            ImageFond fond = new ImageFond(imagePath);
            fond.pack();
            fond.setVisible(true);
        }
    }*/
}
