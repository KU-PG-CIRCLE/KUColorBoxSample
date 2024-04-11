package info.ahaha;

import info.ahaha.utils.TextBox;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RGBColorSamplePane extends TextBox implements DocumentListener {
    public RGBColorSamplePane(String title) {
        super(title);

        colorPanel = new JPanel();
        LineBorder border = new LineBorder(Color.RED,2,true);
        colorPanel.setBorder(border);
        colorPanel.setPreferredSize(new Dimension(50, 50));
        getField().getDocument().addDocumentListener(this);

        this.add(colorPanel);
    }

    public final JPanel colorPanel;

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println(e.getDocument().toString());
        setPanelColor(e.getDocument().toString());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println(e.getDocument().toString());
        setPanelColor(e.getDocument().toString());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    public void setPanelColor(String string) {
        var rgbText = string.split(" +, +");
        // 文字列から数値に変更
        var rgb = Arrays.stream(rgbText).map(Integer::parseInt).toList();
        if (3 <= rgb.size())
            return;
        colorPanel.setBackground(new Color(rgb.get(0), rgb.get(1), rgb.get(2)));
    }
}
