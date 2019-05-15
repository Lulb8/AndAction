import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ScriptwritersBuildingWindow extends JInternalFrame {

    protected JInternalFrame internalFrame;
    private JTextField jTextField = new JTextField();
    private JPanel container = new JPanel();

    private static int x = 320;
    private static int y = 100;

    /**
     * Constructeur
     */
    public ScriptwritersBuildingWindow() {
        internalFrame = new JInternalFrame();
        this.setTitle("Fenêtre du bureau des scénaristes");
        this.setSize(1200, 800);
        this.setResizable(false); //Interdit la redimensionnement de la fenêtre
        this.setClosable(true);
        this.setLocation(x, y);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        Font police = new Font("Arial", Font.BOLD, 14);

        //Titre du film
        JPanel panelTitle = new JPanel();
        JLabel labelTitle = new JLabel("Le titre de votre film : ");
        labelTitle.setFont(police);
        jTextField.setFont(police);
        jTextField.setPreferredSize(new Dimension(150, 30));
        jTextField.setForeground(Color.BLUE);
        panelTitle.add(labelTitle);
        panelTitle.add(jTextField);
        container.add(panelTitle, BorderLayout.NORTH);

        //Choix du scénariste
        JPanel panelSw = new JPanel();
        JLabel labelSw = new JLabel("Le scénariste de votre film : ");
        labelSw.setFont(police);
        String[] sw = {"Option 1", "Option 2", "Option 3", "Option 4"};
        JComboBox comboSw = new JComboBox(sw);
        comboSw.addItemListener(new ItemState());
        comboSw.addActionListener(new ItemAction(comboSw));
        comboSw.setPreferredSize(new Dimension(100, 20));
        comboSw.setForeground(Color.blue);
        panelSw.add(labelSw);
        panelSw.add(comboSw);
        container.add(panelSw, BorderLayout.WEST);


        //Choix du genre
        JPanel panelGenre = new JPanel();
        JLabel labelGenre = new JLabel("Le genre de votre film : ");
        labelGenre.setFont(police);
        String[] genre = {"Action", "Drame", "Horreur", "SF"};
        JComboBox comboGenre = new JComboBox(genre);
        comboGenre.addItemListener(new ItemState());
        comboGenre.addActionListener(new ItemAction(comboGenre));
        comboGenre.setPreferredSize(new Dimension(100, 20));
        comboGenre.setForeground(Color.blue);
        panelGenre.add(labelGenre);
        panelGenre.add(comboGenre);
        container.add(panelGenre, BorderLayout.EAST);








        this.setContentPane(container);
        this.setVisible(true);
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
