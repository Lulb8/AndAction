import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MovieSetWindow extends JInternalFrame {

    protected JInternalFrame internalFrame;
    private JPanel container = new JPanel();

    private static int x = 320;
    private static int y = 100;

    /**
     * Constructeur
     */
    public Movie MovieSetWindow(Movie currentMovie) {
        if (currentMovie!=null) {
        internalFrame = new JInternalFrame();
        this.setTitle("Bureau des acteurs et réalisateurs");
        this.setSize(1200, 800);
        this.setResizable(false); //Interdit la redimensionnement de la fenêtre
        this.setClosable(true);
        this.setLocation(x, y);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        Font police = new Font("Arial", Font.BOLD, 14);
        Font policeTitle = new Font("Arial", Font.BOLD, 22);

        //Titre du film
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.WHITE);
        Dimension panelTitleSize = new Dimension(500, 200);
        panelTitle.setPreferredSize(panelTitleSize);
        JLabel labelTitle = new JLabel("Le titre de votre film : "+ currentMovie.getName()); //recuperer le titre du film en cours
        labelTitle.setFont(policeTitle);
        panelTitle.add(labelTitle);
        container.add(panelTitle, BorderLayout.NORTH);

        //Panel de gauche
        JPanel panelTeam = new JPanel();
        Box boxTeam = Box.createVerticalBox();
        panelTeam.setBackground(Color.WHITE);

        //Equipe du film
        JLabel labelTeam = new JLabel("L'équipe de votre film : ");
        labelTeam.setFont(police);
        boxTeam.add(labelTeam);
        panelTeam.add(boxTeam);
        container.add(panelTeam, BorderLayout.WEST);
            //les acteurs
            JLabel labelActor = new JLabel("Les acteurs : "+currentMovie.getActors());
            labelActor.setFont(police);
            boxTeam.add(labelActor);
            panelTeam.add(boxTeam);
            //le scénariste
            JLabel labelSw = new JLabel("scénariste : "+currentMovie.getScriptwriterName());
            labelSw.setFont(police);
            boxTeam.add(labelSw);
            panelTeam.add(boxTeam);
            //le réalisateur
            JLabel labelDir = new JLabel("réalisateur : "+currentMovie.getDirector());
            labelDir.setFont(police);
            boxTeam.add(labelDir);
            panelTeam.add(boxTeam);
            //le genre
            JLabel labelG = new JLabel("Le genre du film : "+currentMovie.getGenre());
            labelG.setFont(police);
            boxTeam.add(labelG);
            panelTeam.add(boxTeam);
            //l'equipe
            JLabel labelTc = new JLabel("L'équipe technique : "+currentMovie.getTechnicalCrew());
            labelTc.setFont(police);
            boxTeam.add(labelTc);
            panelTeam.add(boxTeam);

        //Panel de droite
        JPanel panelState = new JPanel();
        Box boxState = Box.createVerticalBox();
        panelState.setBackground(Color.WHITE);

        //L'etat du film
        JLabel labelState = new JLabel("L'état de votre film : "+currentMovie.getState());
        labelState.setFont(police);
        boxState.add(labelState);
        panelState.add(boxState);
        container.add(panelState, BorderLayout.EAST);

        //Logo du building
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.WHITE);
        JLabel logo = new JLabel(new ImageIcon("MovieSetBuilding.png"));
        panelLogo.add(logo);
        container.add(panelLogo, BorderLayout.CENTER);

        //Bouton pour valider
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.WHITE);
        panelButton.setSize(200, 100);
        JButton button = new JButton("Le tournage est fini !");
        Dimension buttonSize = new Dimension(500, 100);
        button.setPreferredSize(buttonSize);
        button.setFont(policeTitle);
        panelButton.add(button);
        container.add(panelButton, BorderLayout.SOUTH);


        this.setContentPane(container);
        this.setVisible(true);

        }
        return currentMovie;
    }


    class ItemState implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            System.out.println("ComboBox événement sur : " + e.getItem());
        }
    }

    class ItemAction implements ActionListener {
        JComboBox combo;
        public ItemAction(JComboBox comboBox) {
            this.combo = comboBox;
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("ComboBox action sur " + combo.getSelectedItem());
        }
    }
}
