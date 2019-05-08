import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {

    private JPanel panel = new JPanel();
    private JButton button = new JButton("START");
    private Panel pan = new Panel();
    private JLabel label = new JLabel("And Action !!!");
    private Clock clock;
    private JMenuBar menuBar;
    private JFrame frame;

    private int compteur = 0;

    /**
     * Constructeur
     */
    public MenuWindow() {
        frame = new JFrame();
        frame.setTitle("And Action !!!");
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null); //Centre la fenetre
        frame.setResizable(false); //Interdit la redimensionnement de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        //place le texte au centre de la fenetre
        panel.add(pan, BorderLayout.CENTER); //centre sur l'horizontal
        panel.add(button, BorderLayout.SOUTH);  //place la phrase en bas

        button.setPreferredSize(new Dimension(10, 60));
        button.addActionListener(new ButtonListener());


        //On initialise l'horloge
        //this.clock = new Clock();
        //On place un écouteur sur l'horloge
        /*this.clock.addObservateur(new Observateur(){
            public void update(String hour) {
                label.setText(hour);
            }
        });*/

        menuBar();

        //On initialise l'horloge
        this.clock = new Clock();
        //On place un écouteur sur l'horloge
        this.clock.addObservateur(new Observateur(){
            public void update(String hour) {
                label.setText(hour);
            }
        });


        Font police = new Font("Tahoma", Font.BOLD, 30);
        label.setFont(police);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setVisible(true);
        this.clock.run();
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            label.setText("Vous avez cliqué sur le bouton");
        }
    }

    public void menuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem();
        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }
}
