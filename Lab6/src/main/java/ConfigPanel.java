import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;


    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        dotsLabel = new JLabel("Number of dots:");

        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        linesLabel = new JLabel("Line probability:");

        Double[] comboItems = new Double[11];
        for (int i = 1; i <= 10; i++) {
            comboItems[i] = (double) i / 10;
        }

        linesCombo = new JComboBox<>(comboItems);

        linesCombo.setSelectedItem(1.0);


        createButton = new JButton("New game");

        this.createButton.addActionListener(this::newGame);

        //create the rest of the components
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }

    private void newGame(ActionEvent actionEvent) {
        this.frame.canvas.createBoard();
    }

}
