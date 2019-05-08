import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends Window {

    JLabel labelWindow = new JLabel("Menu");
    JLabel labelName = new JLabel("Nom du studio : ");
    JLabel labelBudget = new JLabel("Budget du studio : ");

    private JTextField studioName = new JTextField();
    private JTextField studioBudget = new JTextField();

    public MenuWindow(){
        super();
        this.menu();
    }

    public void menu(){
        this.panel = new JPanel();
        this.button = new JButton("START");
        this.pan = new Panel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setBackground(Color.WHITE);

        //place le texte au centre de la fenetre
        this.panel.add(this.pan, BorderLayout.CENTER); //centre sur l'horizontal
        this.panel.add(this.button, BorderLayout.SOUTH);  //place la phrase en bas

        this.button.setPreferredSize(new Dimension(10, 60));
        this.button.addActionListener(new ButtonListener());

        JPanel namePanel = new JPanel();
        Font police = new Font("Tahoma", Font.BOLD, 30);
        this.labelWindow.setFont(police);
        this.labelWindow.setForeground(Color.BLACK);
        this.labelWindow.setHorizontalAlignment(JLabel.CENTER);
        panel.add(this.labelWindow, BorderLayout.BEFORE_FIRST_LINE); //Affiche la phrase



        JPanel nameBox = new JPanel();
        Font policeBox = new Font("Arial", Font.BOLD, 14);
        studioName.setFont(policeBox);
        studioName.setPreferredSize(new Dimension(150, 30));
        studioName.setForeground(Color.BLUE);
        nameBox.setBackground(Color.WHITE);
        nameBox.add(labelName);
        nameBox.add(studioName);
        panel.add(nameBox, BorderLayout.LINE_START);


        JPanel budgetBox = new JPanel();
        studioBudget.setFont(policeBox);
        studioBudget.setPreferredSize(new Dimension(150, 30));
        studioBudget.setForeground(Color.BLUE);
        budgetBox.setBackground(Color.WHITE);
        budgetBox.add(labelBudget);
        budgetBox.add(studioBudget);
        panel.add(budgetBox, BorderLayout.LINE_END);

        frame.setContentPane(this.panel);





        run();
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            labelWindow.setText("Vous avez cliqué sur le bouton");
        }
    }
}