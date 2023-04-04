package graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

public class ControlPanel extends JPanel implements Serializable{

    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadtBtn = new JButton("Load");
    JButton savetBtn = new JButton("Save");
    JButton resettBtn = new JButton("Reset");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        setLayout(new GridLayout(1, 4));
        add(loadtBtn);
        add(savetBtn);
        add(resettBtn);
        add(exitBtn);

        exitBtn.addActionListener(this::exitGame);
        savetBtn.addActionListener(this::saveGame);
        loadtBtn.addActionListener(this::loadGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveGame(ActionEvent e) {

        RenderedImage rendImage = frame.canvas.image;
        File file = new File("game.png");
        try {
            ImageIO.write(rendImage, "png", file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void loadGame(ActionEvent e) {

        
    }
}
