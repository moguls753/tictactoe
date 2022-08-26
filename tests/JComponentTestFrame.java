import javax.swing.JComponent;
import javax.swing.JFrame;

public class JComponentTestFrame extends JFrame {

    public JComponentTestFrame(JComponent component) {
        add(component);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
