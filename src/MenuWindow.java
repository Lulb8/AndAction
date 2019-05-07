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

    private int compteur = 0;


    /**
     * Constructeur
     */
    public MenuWindow() {
        this.setTitle("And Action !!!");
        this.setSize(600,500);
        this.setLocationRelativeTo(null); //Centre la fenetre
        this.setResizable(false); //Interdit la redimensionnement de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(pan, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        button.setPreferredSize(new Dimension(10, 60));
        button.addActionListener(new ButtonListener());


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
        panel.add(label, BorderLayout.NORTH);

        this.setContentPane(panel);
        this.setVisible(true);
        this.clock.run();
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            label.setText("Vous avez cliqué sur le bouton");
        }
    }
}
