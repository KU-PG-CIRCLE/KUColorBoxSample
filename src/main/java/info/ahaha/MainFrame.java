package info.ahaha;

import info.ahaha.utils.TextBox;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainFrame instance;

    public static void main(String[] args) {
        String title = "main";
        if (0 < args.length)
            title = args[0];

        instance = new MainFrame(title);
    }

    TextBox rgbColorBox;

    public MainFrame(String title) {
        // 継承元(JFrame)の初期化(コンストラクタを実行)
        super(title);

        // 表示
        this.setVisible(true);
        // バツボタンでフレームを削除
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        rgbColorBox = new TextBox("R, G, B");

        getContentPane().add(rgbColorBox);
    }
}