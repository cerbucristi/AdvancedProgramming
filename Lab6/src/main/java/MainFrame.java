import javax.swing.*;

import static java.awt.BorderLayout.CENTER;

public class MainFrame extends JFrame {

    DrawingPanel canvas;

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER

        //invoke the layout manager
        pack();
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }


}
