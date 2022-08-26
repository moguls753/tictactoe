package foo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TicTacToeBoardPanel extends JPanel implements IView, IInputDevice {

    IModel model;
    private double scale;
    private IMoveListener iml;

    public TicTacToeBoardPanel(IModel model) {
        this.model = model;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(450, 450));
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int column = (int) (e.getX() / scale / 100);
                int row = (int) (e.getY() / scale / 100);
                if (column <= 2 && column >= 0 && row <= 2 && row >= 0 && iml != null) {
                    iml.moveOccurred(row, column);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        configureGraphicsForUsageOfUserCoordinateSystem(g2);
        drawGrid(g2);
        drawFieldStates(g2);
    }

    private void drawFieldStates(Graphics2D g2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (model.getFieldState(j, i)) {
                case CIRCLE:
                    g2.drawOval((i * 100)+10, (j * 100)+10, 100-20, 100-20);
                    break;
                case CROSS:
                    g2.drawLine((i * 100)+10, (j * 100)+10, i * 100 + 100-10, j * 100 + 100-10);
                    g2.drawLine(i * 100 + 100-10, j * 100+10, i * 100+10, j * 100 + 100-10);
                    break;
                default:
                    break;
                }
            }
        }
    }

    private void drawGrid(Graphics2D g2) {
        g2.drawLine(100, 0, 100, 300);
        g2.drawLine(200, 0, 200, 300);
        g2.drawLine(0, 100, 300, 100);
        g2.drawLine(0, 200, 300, 200);
        g2.drawRect(0, 0, 300, 300);
    }

    private void configureGraphicsForUsageOfUserCoordinateSystem(Graphics2D g2) {
        double sx = getWidth() / 300.0;
        double sy = getHeight() / 300.0;
        scale = Math.min(sx, sy);
        AffineTransform transform = AffineTransform.getScaleInstance(scale, scale);
        g2.transform(transform);
    }

    @Override
    public void refresh() {
        repaint();
    }

    @Override
    public void setMoveListener(IMoveListener iml) {
        this.iml = iml;

    }
}
