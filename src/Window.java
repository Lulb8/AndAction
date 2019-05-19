import observer.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Window extends JFrame {

    protected JPanel panel;
    protected JButton button;
    protected Panel pan;
    protected Clock clock;
    protected JFrame frame;

    /**
     * Constructeur
     */
    public Window() {
        frame = new JFrame();
        frame.setTitle("And Action !!!");
        frame.setSize(1870,1050); //1870,1050 : taille à l'origine, actuellement le reglage est a 80%  1496,840
        frame.setLocationRelativeTo(null); //Centre la fenetre
        frame.setResizable(false); //Interdit la redimensionnement de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void menuBar(){
        JMenuBar menuBar = new JMenuBar();
        //Menu
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_F);
        //Mon studio
        JMenuItem myStudio = new JMenuItem("Mon Studio");
        myStudio.setMnemonic(KeyEvent.VK_E);
        myStudio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
                String studioName = jop.showInputDialog(null, "Quel est le nom de votre studio ?","Mon studio - Nom du studio", JOptionPane.QUESTION_MESSAGE);
                String studioBudget = jop.showInputDialog(null, "Quel est le budget de votre studio ?","Mon studio - Budget du studio", JOptionPane.QUESTION_MESSAGE);
                jop2.showMessageDialog(null, "Le nom de votre studio est " + studioName + " et le budget est le " + studioBudget + "€.", "Mon studio", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.add(myStudio);
        //Quitter
        JMenuItem exit = new JMenuItem("Quitter");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Quitter le jeu");
        exit.addActionListener((even)-> System.exit(0));
        menu.add(exit);
        menuBar.add(menu);
        //A propos
        JMenu about = new JMenu("A propos");
        about.setMnemonic(KeyEvent.VK_F);
        //L'équipe
        JMenuItem team = new JMenuItem("L'équipe");
        team.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "L'équipe :\nSarah\nLucie\nEmma\nEmmy\nJessica", "L'équipe du jeu", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        about.add(team);
        //Aide
        JMenuItem help = new JMenuItem("Aide");
        help.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                jop.showConfirmDialog(null, "Bienvenue dans le jeu \"And Action !!!\"\n Dans ce jeu vous allez pouvoir diriger votre propre studio de cinéma.\n"
                        + "Pour commencer à jouer, vous devez choisir le nom et le budget de votre studio en cliquant sur le bouton Menu>Mon Studio présent dans labarre supérieure.\n"
                        + "Une fois ceci fait, il est maintenant temps de créer votre premier film en cliquant sur le bureau des scénaristes.\n"
                        + "Il vous sera possible de choisir le titre, le genre et le scénariste de votre film. Maintenant, il faut un acteur, un réalisateur et une équipe technique pour tourner votre chef d'oeuvre.\n"
                        + "C'est bon, le scénario est prêt, l'acteur a répété son texte et le réalisateur s'apprête à dire \"And Action !!!\", ça veut maintenant dire qu'il est temps de se diriger vers le plateau de tournage.\n"
                        + "Le clap de fin a retentit et il faut diffuser ce chef d'oeuvre dans les salles obscures mais votre film doit se faire connaître et c'est pour ça que l'équipe marketing existe, donc dépêchez vous de rejoindre le bureau de post-production.\n"
                        + "\nMaintenant que votre premier film est fini, vous pouvez lancer la production de votre prochain blockbuster !", "Aide", JOptionPane.CLOSED_OPTION);
            }
        });
        about.add(help);
        menuBar.add(about);
        //Horloge
        JMenu menuClock = new JMenu();
        about.setMnemonic(KeyEvent.VK_F);
        JMenuItem play = new JMenuItem("Play");
        menuClock.add(play);
        JMenuItem pause = new JMenuItem("Pause");
        menuClock.add(pause);
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
