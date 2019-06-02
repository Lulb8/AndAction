import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ScriptwritersBuildingWindow extends JInternalFrame implements DocumentListener {

    protected JInternalFrame internalFrame;
    private JTextField movieTitle = new JTextField();
    private JPanel container = new JPanel();
    private JComboBox comboGenre;
    private JComboBox comboSw;
    private JPanel panelButton;
    private JButton button;

    private static int x = 320;
    private static int y = 100;

    Scriptwriter scriptwriter=new Scriptwriter();

    public Movie currentMovie = new Movie();

    /**
     * Constructeur
     */
    public Movie ScriptwritersBuildingWindow(Studio studio) {
        //currentMovie = new Movie();
        internalFrame = new JInternalFrame();
        this.setTitle("Bureau des scénaristes");
        this.setSize(1200, 800);
        this.setResizable(false); //Interdit la redimensionnement de la fenêtre
        this.setClosable(true);
        this.setLocation(x, y);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        Font police = new Font("Arial", Font.BOLD, 14);
        Font policeTitle = new Font("Arial", Font.BOLD, 22);

        //Titre du film
        //movieTitle.setText("Titre de mon film");
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.WHITE);
        Dimension panelTitleSize = new Dimension(500, 200);
        panelTitle.setPreferredSize(panelTitleSize);
        JLabel labelTitle = new JLabel("Le titre de votre film : ");
        labelTitle.setFont(police);
        movieTitle.setFont(police);
        movieTitle.setPreferredSize(new Dimension(150, 30));
        movieTitle.setForeground(Color.BLUE);
        movieTitle.getDocument().addDocumentListener(this);
        panelTitle.add(labelTitle);
        panelTitle.add(movieTitle);
        container.add(panelTitle, BorderLayout.NORTH);

        currentMovie.setState(0);
        currentMovie.setName(movieTitle.getText());

        //Choix du scénariste
        JPanel panelSw = new JPanel();
        panelSw.setBackground(Color.WHITE);
        JLabel labelSw = new JLabel("Le scénariste de votre film : ");
        labelSw.setFont(police);
        String[] sw = {"Machin", "Truc", "Bidule", "Chouette"};
        comboSw = new JComboBox(sw);
        comboSw.addItemListener(new ItemState());
        comboSw.addActionListener(new ItemAction(comboSw));
        comboSw.setPreferredSize(new Dimension(100, 20));
        comboSw.setForeground(Color.blue);
        panelSw.add(labelSw);
        panelSw.add(comboSw);
        container.add(panelSw, BorderLayout.WEST);

        int i =comboSw.getItemCount();
        scriptwriter.setName(sw[i-1]);

        currentMovie.setScriptwriter(scriptwriter);

        //Choix du genre
        JPanel panelGenre = new JPanel();
        panelGenre.setBackground(Color.WHITE);
        JLabel labelGenre = new JLabel("Le genre de votre film : ");
        labelGenre.setFont(police);
        String[] genre = {"Action", "Drame", "Horreur", "SF"};
        comboGenre = new JComboBox(genre);
        comboGenre.addItemListener(new ItemState());
        comboGenre.addActionListener(new ItemAction(comboGenre));
        comboGenre.setPreferredSize(new Dimension(100, 20));
        comboGenre.setForeground(Color.blue);
        panelGenre.add(labelGenre);
        panelGenre.add(comboGenre);
        container.add(panelGenre, BorderLayout.EAST);

        //Logo du building
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.WHITE);
        JLabel logo = new JLabel(new ImageIcon("SwBuilding.png"));
        panelLogo.add(logo);
        container.add(panelLogo, BorderLayout.CENTER);

        //Bouton pour valider
        panelButton = new JPanel();
        panelButton.setBackground(Color.WHITE);
        panelButton.setSize(200, 100);
        button = new JButton("Valider le scénario !");
        button.setEnabled(false);
        Dimension buttonSize = new Dimension(500, 100);
        button.addActionListener(new ButtonListener());
        button.setPreferredSize(buttonSize);
        button.setFont(policeTitle);
        panelButton.add(button);
        container.add(panelButton, BorderLayout.SOUTH);


        this.setContentPane(container);
        this.setVisible(true);
        return currentMovie;
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        scanTextFields();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        scanTextFields();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    private void scanTextFields() {
        boolean filled = true;
        if (movieTitle.getText().length() == 0) {
            filled = false;
        }
        button.setEnabled(filled);
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
            Scriptwriter scriptwriter = new Scriptwriter();
            scriptwriter.setName(String.valueOf(comboSw.getSelectedItem()));
            currentMovie.setName(movieTitle.getText());
            currentMovie.setGenre(String.valueOf(comboGenre.getSelectedItem()));
            currentMovie.setScriptwriter(scriptwriter);
            System.out.println(currentMovie.getName() + " " + currentMovie.getGenre() + " " + currentMovie.getScriptwriterName()); //affichage console
            setVisible(false);
        }
    }


}
