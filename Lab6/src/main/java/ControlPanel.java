import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {

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
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    //TODO: implemet the other methods
}
