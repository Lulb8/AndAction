import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ActorsBuildingWindow extends JInternalFrame {

    protected JInternalFrame internalFrame;
    private JPanel container = new JPanel();
    private JPanel panelButton;
    private JButton button;
    JComboBox comboActor;
    private JComboBox comboDirector;
    private JComboBox comboTC;

    private Actor actor = new Actor();
    private Actors actorsChosen=new Actors();
    private Director directorChosen = new Director();
    private TechnicalCrew technicalCrew = new TechnicalCrew();

    private static int x = 320;
    private static int y = 100;

    /**
     * Constructeur
     */
    public void ActorsBuildingWindow(Movie currentMovie) {
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
        JLabel labelTitle = new JLabel("Le titre de votre film : " + currentMovie.getName()); //recuperer le titre du film en cours   + currentMovie.getName()
        labelTitle.setFont(policeTitle);
        panelTitle.add(labelTitle);
        container.add(panelTitle, BorderLayout.NORTH);

        //Panel de gauche
        JPanel panelAD = new JPanel();
        Box boxAD = Box.createVerticalBox();
        panelAD.setBackground(Color.WHITE);

        //Choix de l'acteur
        JLabel labelActor = new JLabel("L'acteur de votre film : ");
        labelActor.setFont(police);
        String[] actors = {"Bad Pitt", "Robert Downey Senior", "Michael J.Box", "Nathalie Porthomme", "Angelina Moche","Morgan Jailman"};
        comboActor = new JComboBox(actors);
        comboActor.addItemListener(new ItemState());
        comboActor.addActionListener(new ItemAction(comboActor));
        comboActor.setPreferredSize(new Dimension(100, 20));
        comboActor.setForeground(Color.blue);
        boxAD.add(labelActor);
        boxAD.add(comboActor);
        boxAD.add(Box.createRigidArea(new Dimension(0,150))); //espacement entre les 2 composants

        //Choix du réalisateur
        JLabel labelDirector = new JLabel("Le réalisateur de votre film : ");
        labelDirector.setFont(police);
        String[] directors = {"Luc Buisson", "Steven Playberg", "Christopher L'Âne", "James Cameroun"};
        comboDirector = new JComboBox(directors);
        comboDirector.addItemListener(new ItemState());
        comboDirector.addActionListener(new ItemAction(comboDirector));
        comboDirector.setPreferredSize(new Dimension(100, 20));
        comboDirector.setForeground(Color.blue);
        boxAD.add(labelDirector);
        boxAD.add(comboDirector);
        panelAD.add(boxAD);
        container.add(panelAD, BorderLayout.WEST);

        //Panel de droite
        JPanel panelTC = new JPanel();
        Box boxTC = Box.createVerticalBox();
        panelTC.setBackground(Color.WHITE);

        //Choix de l'equipe technique
        JLabel labelTC = new JLabel("L'équipe technique de votre film : ");
        labelTC.setFont(police);
        String[] technicalCrew = {"Brigade spéciale", "L'Araignée", "CamérAvengers","Equipe Tecktonic"};
        comboTC = new JComboBox(technicalCrew);
        comboTC.addItemListener(new ItemState());
        comboTC.addActionListener(new ItemAction(comboTC));
        comboTC.setPreferredSize(new Dimension(100, 20));
        comboTC.setForeground(Color.blue);
        boxTC.add(labelTC);
        boxTC.add(comboTC);
        panelTC.add(boxTC);
        container.add(panelTC, BorderLayout.EAST);

        //Logo du building
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.WHITE);
        JLabel logo = new JLabel(new ImageIcon("ActorsBuilding.png"));
        panelLogo.add(logo);
        container.add(panelLogo, BorderLayout.CENTER);

        //Bouton pour valider
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.WHITE);
        panelButton.setSize(200, 100);
        JButton button = new JButton("Valider le casting !");
        button.addActionListener(new ButtonListener());
        Dimension buttonSize = new Dimension(500, 100);
        button.setPreferredSize(buttonSize);
        button.setFont(policeTitle);
        panelButton.add(button);
        container.add(panelButton, BorderLayout.SOUTH);

            this.setContentPane(container);
        this.setVisible(true);
        }
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

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            actor.setName(String.valueOf(comboActor.getSelectedItem()));
            actorsChosen.addActor(actor);
            //currentMovie.setActors(actors);
            //currentMovie.setActors(this.setActors());
            directorChosen.setName(String.valueOf(comboDirector.getSelectedItem()));
            //currentMovie.setDirector(director);
            technicalCrew.setName(String.valueOf(comboTC.getSelectedItem()));
            //currentMovie.setTechnicalCrew(technicalCrew);
            System.out.println(getActors() + " " +getDirector() + " " +getTechnicalCrew()); //affichage console
            setVisible(false);
        }
    }

    public Actors getActors() {
        return actorsChosen;
    }

    public Director getDirector() {
        return directorChosen;
    }

    public TechnicalCrew getTechnicalCrew() {
        return technicalCrew;
    }

}
