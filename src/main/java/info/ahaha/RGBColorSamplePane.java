package info.ahaha;

import info.ahaha.utils.TextBox;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Arrays;

public class RGBColorSamplePane extends TextBox implements DocumentListener {
    public RGBColorSamplePane(String title) {
        super(title);

        colorPanel = new JPanel();
        // colorPanel.setBorder(new );
        colorPanel.setPreferredSize(new Dimension(50, 50));
        getField().getDocument().addDocumentListener(this);

        this.add(colorPanel);
    }

    public final JPanel colorPanel;

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    public void setPanelColor(String string) {
        var rgbText = string.split(" +, +");
        // 文字列から数値に変更
        // var rgb = Arrays.stream(rgbText).map(Integer::parseInt).collect();
        // colorPanel.setBackground(new Color(rgb[0], rgb[1], rgb[2]));
    }
}
