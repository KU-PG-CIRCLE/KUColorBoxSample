package info.ahaha.utils;

import javax.swing.*;

public class TextBox extends JPanel {
    public TextBox(String title) {
        label = new JLabel(title);
        field = new JTextField(10);

        this.add(label);
        this.add(field);
    }

    private final JLabel label;
    private final JTextField field;

    public JLabel getLabel() {
        return label;
    }

    public JTextField getField() {
        return field;
    }
}
