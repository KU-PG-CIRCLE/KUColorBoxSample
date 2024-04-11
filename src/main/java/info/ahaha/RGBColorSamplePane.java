package info.ahaha;

import info.ahaha.utils.TextBox;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RGBColorSamplePane extends TextBox implements DocumentListener {
    public RGBColorSamplePane(String title) {
        super(title);

        colorPanel = new JPanel();
        LineBorder border = new LineBorder(Color.BLACK,2,true);
        colorPanel.setBorder(border);
        colorPanel.setPreferredSize(new Dimension(50, 50));
        getField().getDocument().addDocumentListener(this);

        this.add(colorPanel);
    }

    public final JPanel colorPanel;

    @Override
    public void insertUpdate(DocumentEvent e) {
        var doc = e.getDocument();
        try {
            setPanelColor(doc.getText(0, doc.getLength()));
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        var doc = e.getDocument();
        try {
            setPanelColor(doc.getText(0, doc.getLength()));
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        var doc = e.getDocument();
        try {
            setPanelColor(doc.getText(0, doc.getLength()));
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void setPanelColor(String string) {
        var rgbText = string.split(" *, *");
        // 文字列から数値に変更
        var rgb = Arrays.stream(rgbText).map( str -> {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 0;
            }
        }).toList();
        if (rgb.size() < 3)
            return;
        colorPanel.setBackground(new Color(rgb.get(0), rgb.get(1), rgb.get(2)));
    }
}
