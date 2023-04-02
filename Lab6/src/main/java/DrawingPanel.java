
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame mainFrame) {
        this.frame = mainFrame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//                //TODO...
//                repaint();
//            }
//        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {

        Random random = new Random();
        double p;
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length; j++) {
                p = random.nextDouble();
                if (p <= edgeProbability) {
                    graphics.setColor(Color.BLACK);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }


    }

    private void drawVertices() {

        for (int i = 0; i < numVertices; i++) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i] - 5, y[i] - 5, 15, 15);
        }
    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}
