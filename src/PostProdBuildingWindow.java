import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PostProdBuildingWindow extends JInternalFrame {

    protected JInternalFrame internalFrame;
    private JTextField jTextField = new JTextField();
    private JPanel container = new JPanel();

    private static int x = 320;
    private static int y = 100;

    /**
     * Constructeur
     */
    public PostProdBuildingWindow() {
        internalFrame = new JInternalFrame();
        this.setTitle("Bureau de la post-production");
        this.setSize(1200, 800);
        this.setResizable(false); //Interdit la redimensionnement de la fenêtre
        this.setClosable(true);
        this.setLocation(x, y);

        //container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        Font police = new Font("Arial", Font.BOLD, 14);
        Font policeTitle = new Font("Arial", Font.BOLD, 22);

        //Titre du film
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.WHITE);
        Dimension panelTitleSize = new Dimension(500, 200);
        panelTitle.setPreferredSize(panelTitleSize);
        JLabel labelTitle = new JLabel("Le titre de votre film : "); //recuperer le titre du film en cours
        labelTitle.setFont(policeTitle);
        panelTitle.add(labelTitle);
        container.add(panelTitle, BorderLayout.NORTH);

        //Panel de gauche
        JPanel panelAd = new JPanel();
        Box boxAd = Box.createVerticalBox();
        panelAd.setBackground(Color.WHITE);

        //Choix du budget pub
        Dimension panelAdSize = new Dimension(500, 200);
        panelAd.setPreferredSize(panelAdSize);
        JLabel labelAd = new JLabel("Le budget pub de votre film : ");
        labelAd.setFont(police);
        jTextField.setFont(police);
        jTextField.setPreferredSize(new Dimension(150, 30));
        jTextField.setForeground(Color.BLUE);
        boxAd.add(labelAd);
        boxAd.add(jTextField);
        panelAd.add(boxAd);
        container.add(panelAd, BorderLayout.WEST);

        //Panel de droite
        JPanel panelFeature = new JPanel();
        //Box boxFeature = Box.createVerticalBox();
        panelFeature.setBackground(Color.WHITE);

        //Resumé des caractéristiques du film en cours
        JLabel labelFeature = new JLabel("Les caractéristiques de votre film : ");
        labelFeature.setFont(police);
        panelFeature.add(labelFeature);
        container.add(panelFeature, BorderLayout.EAST);


        //Logo du building
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.WHITE);
        JLabel logo = new JLabel(new ImageIcon("PostProdBuilding.png"));
        panelLogo.add(logo);
        container.add(panelLogo, BorderLayout.CENTER);

        //Bouton pour valider
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.WHITE);
        panelButton.setSize(200, 100);
        JButton button = new JButton("Sortir le film !");
        Dimension buttonSize = new Dimension(500, 100);
        button.setPreferredSize(buttonSize);
        button.setFont(policeTitle);
        panelButton.add(button);
        container.add(panelButton, BorderLayout.SOUTH);


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
