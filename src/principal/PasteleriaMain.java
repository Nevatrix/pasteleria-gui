
package principal;

import javax.swing.SwingUtilities;
import vista.PasteleriaMenu;

public class PasteleriaMain {
    public static void main(String[] args) {
        
        PasteleriaMenu menu = new PasteleriaMenu();
        SwingUtilities.invokeLater(() -> menu.setVisible(true));
    }
}