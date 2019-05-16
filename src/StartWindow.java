import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StartWindow extends JFrame implements ActionListener {

    protected JPanel panel;

    /**
     * Constructeur
     */
    public StartWindow() {
        this.setTitle("And Action !!! - Bienvenue");
        this.setSize(1496,840); //1870,1050 : taille à l'origine, actuellement le reglage est a 80%  1496,840
        this.setLocationRelativeTo(null); //Centre la fenetre
        this.setResizable(false); //Interdit la redimensionnement de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);


        panel.setBackground(Color.white);
        panel.setLayout(new BorderLayout());
        Font police = new Font("Arial", Font.BOLD, 14);
        Font policeTitle = new Font("Arial", Font.BOLD, 22);

        //Titre du Jeu
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(Color.WHITE);
        Dimension panelTitleSize = new Dimension(500, 200);
        panelTitle.setPreferredSize(panelTitleSize);
        JLabel labelTitle = new JLabel("AND ACTION !!!");
        labelTitle.setFont(policeTitle);
        panelTitle.add(labelTitle);
        panel.add(panelTitle, BorderLayout.NORTH);

        //Bouton pour valider
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.WHITE);
        panelButton.setSize(200, 100);
        JButton button = new JButton("Démarrer !");
        button.addActionListener(this);
        //button.addActionListener(new ButtonListener());
        Dimension buttonSize = new Dimension(500, 100);
        button.setPreferredSize(buttonSize);
        button.setFont(policeTitle);
        panelButton.add(button);
        panel.add(panelButton, BorderLayout.SOUTH);

        this.setContentPane(panel);
    }

    public void actionPerformed(ActionEvent action) {
        new GameWindow().setVisible(true);
        //this.setVisible(false);
    }

/*
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            new GameWindow().setVisible(true);
            //this.setVisible(false);
        }
    }*/
}
