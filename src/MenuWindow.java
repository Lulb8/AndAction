import observer.Observer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends Window implements DocumentListener {

    JLabel labelWindow = new JLabel("Menu");
    JLabel labelName = new JLabel("Nom du studio : ");
    JLabel labelBudget = new JLabel("Budget du studio : ");

    JPanel budgetBox = new JPanel();
    JPanel nameBox = new JPanel();


    private Studio studio;

    private JTextField studioName = new JTextField();
    private JTextField studioBudget = new JTextField();

    public MenuWindow(Studio studio){
        super();
        this.menu(studio);
    }

    public void menu(Studio studio){
        this.panel = new JPanel();
        this.button = new JButton("START");
        this.pan = new Panel();
        this.panel.setLayout(new BorderLayout());
        this.panel.setBackground(Color.WHITE);

        //place le texte au centre de la fenetre
        this.panel.add(this.pan, BorderLayout.CENTER); //centre sur l'horizontal
        this.panel.add(this.button, BorderLayout.SOUTH);  //place la phrase en bas
        button.setEnabled(false);
        this.button.setPreferredSize(new Dimension(10, 60));
        this.button.addActionListener(new ButtonListener());


        JPanel namePanel = new JPanel();
        Font police = new Font("Tahoma", Font.BOLD, 30);
        this.labelWindow.setFont(police);
        this.labelWindow.setForeground(Color.BLACK);
        this.labelWindow.setHorizontalAlignment(JLabel.CENTER);
        panel.add(this.labelWindow, BorderLayout.BEFORE_FIRST_LINE); //Affiche la phrase


        //Nom du studio
        nameBox = new JPanel();
        studioName.getDocument().addDocumentListener(this);
        Font policeBox = new Font("Arial", Font.BOLD, 14);
        studioName.setFont(policeBox);
        studioName.setPreferredSize(new Dimension(150, 30));
        studioName.setForeground(Color.BLUE);
        nameBox.setBackground(Color.WHITE);
        nameBox.add(labelName);
        nameBox.add(studioName);
        panel.add(nameBox, BorderLayout.LINE_START);

        //Budget du studio
        budgetBox = new JPanel();
        studioBudget.getDocument().addDocumentListener(this);
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
        if (studioName.getText().length() == 0 || studioBudget.getText().length() == 0) {
            filled = false;
        }
        button.setEnabled(filled);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            labelWindow.setText("Vous avez cliqué sur le bouton");
            //studio.setName(studioName.getText());
            //studio.setBudget(Integer.parseInt(studioBudget.getText()));

            System.out.println("Nom : " + studioName.getText());
            System.out.println("Budget : " + studioBudget.getText());

        }
    }
}