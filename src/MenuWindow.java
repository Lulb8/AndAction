import javax.swing.*;

public class MenuWindow {

    private static String studioName = null;
    private static String studioBudget = null;
    private static int studioBudgetInt = 0;

    public MenuWindow(Studio studio){
        JOptionPane jop, jop2;
        jop2 = new JOptionPane();
        if (studioName == null && studioBudget == null) {
            jop = new JOptionPane();
            studioName = jop.showInputDialog(null, "Quel est le nom de votre studio ?", "Mon studio - Nom du studio", JOptionPane.QUESTION_MESSAGE);
            //studio.setName(studioName);

            // verification nombre entier
            boolean isNumber = true;
           while (isNumber) {
                try {
                    studioBudget = jop.showInputDialog(null, "Quel est le budget de votre studio ?", "Mon studio - Budget du studio", JOptionPane.QUESTION_MESSAGE);
                    studioBudgetInt = Integer.parseInt(studioBudget);
                    isNumber = false;
                } catch (NumberFormatException e) {
                    System.out.println("Vous devez entrer un nombre entier !"); //remplacer par message d'erreur
                    JOptionPane.showMessageDialog(null,"Vous devez entrer un nombre entier !", "Error Int", JOptionPane.ERROR_MESSAGE);
                }
           }
        }
        jop2.showMessageDialog(null, "Le nom de votre studio est " + studioName + " et le budget est le " + studioBudget + " €.", "Mon studio", JOptionPane.INFORMATION_MESSAGE);
    }
}