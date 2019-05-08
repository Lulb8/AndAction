import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends Window {

    JLabel label = new JLabel("And Action !!!");

    public StartMenu(){
        super();
        welcome();
    }

    public void welcome(){
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        //place le texte au centre de la fenetre
        panel.add(pan, BorderLayout.CENTER); //centre sur l'horizontal
        panel.add(button, BorderLayout.SOUTH);  //place la phrase en bas

        button.setPreferredSize(new Dimension(10, 60));
        button.addActionListener(new ButtonListener());


        Font police = new Font("Tahoma", Font.BOLD, 30);
        label.setFont(police);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER); //Affiche la phrase

        frame.setContentPane(panel);

        run();
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            label.setText("Vous avez cliqué sur le bouton");
        }
    }
}
