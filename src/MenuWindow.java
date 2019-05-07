import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JButton button = new JButton("START");
    private Panel pan = new Panel();
    private JLabel label = new JLabel("And Action !!!");

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

        button.addActionListener(this);

        Font police = new Font("Tahoma", Font.BOLD, 30);
        label.setFont(police);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent action) {
        //Lorsque l'on clique sur le bouton, on met à jour le JLabel
        this.compteur++;
        label.setText("Vous avez cliqué " + this.compteur + " fois");
    }


}
