import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends Window {

    JLabel label = new JLabel("Menu");

    public MenuWindow(){
        super();
        this.menu();
    }

    public void menu(){
        this.panel = new JPanel();
        this.button = new JButton("START");
        this.pan = new Panel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setBackground(Color.RED);

        //place le texte au centre de la fenetre
        this.panel.add(this.pan, BorderLayout.CENTER); //centre sur l'horizontal
        this.panel.add(this.button, BorderLayout.SOUTH);  //place la phrase en bas

        this.button.setPreferredSize(new Dimension(10, 60));
        this.button.addActionListener(new ButtonListener());


        Font police = new Font("Tahoma", Font.BOLD, 30);
        this.label.setFont(police);
        this.label.setForeground(Color.BLACK);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.panel.add(this.label, BorderLayout.CENTER); //Affiche la phrase

        frame.setContentPane(this.panel);

        run();
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            label.setText("Vous avez cliqué sur le bouton");
        }
    }
}