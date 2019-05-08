import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Window extends JFrame {

    protected JPanel panel = new JPanel();
    protected JButton button = new JButton("START");
    protected Panel pan = new Panel();
    //protected JLabel label = new JLabel(); //"And Action !!!"
    protected Clock clock;
    protected JFrame frame;

    /**
     * Constructeur
     */
    public Window() {
        frame = new JFrame();
        frame.setTitle("And Action !!!");
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null); //Centre la fenetre
        frame.setResizable(false); //Interdit la redimensionnement de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        //place le texte au centre de la fenetre
        panel.add(pan, BorderLayout.CENTER); //centre sur l'horizontal
        panel.add(button, BorderLayout.SOUTH);  //place la phrase en bas*/

        /*button.setPreferredSize(new Dimension(10, 60));
        button.addActionListener(new ButtonListener());


        Font police = new Font("Tahoma", Font.BOLD, 30);
        label.setFont(police);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER); //Affiche la phrase

        frame.setContentPane(panel);*/
        /*frame.setVisible(true);
        menuBar(); //on affiche la barre de menu
        this.clock.run();*/
    }

    /*class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            //abel.setText("Vous avez cliqué sur le bouton");
        }
    }*/

    public void menuBar(){
        JMenuBar menuBar = new JMenuBar();
        //File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem exit = new JMenuItem("Quitter");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Quitter le jeu");
        exit.addActionListener((even)-> System.exit(0));
        fileMenu.add(exit);
        menuBar.add(fileMenu);
        //Clock
        JMenu menuClock = new JMenu();
        //JMenuItem clock = new JMenuItem(); //pour ajouter un sous-menu sous l'horloge
        //menuClock.add(clock); //pour ajouter un sous-menu sous l'horloge
        menuBar.add(Box.createHorizontalGlue()); //Place l'horloge sur la droite de la barre
        menuBar.add(menuClock);
        //On met la barre sur la fenetre
        frame.setJMenuBar(menuBar);

        //On initialise l'horloge
        this.clock = new Clock();
        //On place un écouteur sur l'horloge
        this.clock.addObservateur(new Observateur(){
            public void update(String hour) {
                menuClock.setText(hour);
            }
        });
    }

    public void run(){
        frame.setVisible(true);
        menuBar(); //on affiche la barre de menu
        this.clock.run();
    }
}
