import observer.Observer;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame {

    protected JPanel panel; //= new JPanel();
    protected JButton button;// = new JButton("START");
    protected Panel pan;// = new Panel();
    //protected JLabel label = new JLabel(); //"And Action !!!"
    protected Clock clock;
    protected JFrame frame;

    protected JTabbedPane tab;

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
    }

    public void menuBar(){
        JMenuBar menuBar = new JMenuBar();
        //Fichier
        JMenu fileMenu = new JMenu("Fichier");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem exit = new JMenuItem("Quitter");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Quitter le jeu");
        exit.addActionListener((even)-> System.exit(0));
        fileMenu.add(exit);
        menuBar.add(fileMenu);
        //A propos
        JMenu about = new JMenu("A propos");
        about.setMnemonic(KeyEvent.VK_F);
        JMenuItem team = new JMenuItem("L'équipe");
        team.setMnemonic(KeyEvent.VK_E);
        about.add(team);
        JMenuItem help = new JMenuItem("Aide");
        help.setMnemonic(KeyEvent.VK_E);
        about.add(help);
        menuBar.add(about);
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
        this.clock.addObservateur(new Observer(){
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
