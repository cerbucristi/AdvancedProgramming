import javax.swing.*;

import java.awt.*;

import static java.awt.BorderLayout.CENTER;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(canvas, CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }


}
