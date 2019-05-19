import javax.swing.*;

public class MenuWindow {

    private static String studioName = null;
    private static String studioBudget = null;

    public MenuWindow(Studio studio){
        JOptionPane jop, jop2;
        jop2 = new JOptionPane();
        if (studioName == null && studioBudget == null) {
            jop = new JOptionPane();
            studioName = jop.showInputDialog(null, "Quel est le nom de votre studio ?", "Mon studio - Nom du studio", JOptionPane.QUESTION_MESSAGE);
            studioBudget = jop.showInputDialog(null, "Quel est le budget de votre studio ?", "Mon studio - Budget du studio", JOptionPane.QUESTION_MESSAGE);
            //studio.setName(studioName);
        }
        jop2.showMessageDialog(null, "Le nom de votre studio est " + studioName + " et le budget est le " + studioBudget + " €.", "Mon studio", JOptionPane.INFORMATION_MESSAGE);
    }
}