package Btn_Label;

import javax.swing.*;
import java.awt.*;

public class TwoContentsButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Two Contents Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button = new JButton();
        button.setLayout(new BorderLayout());

        JLabel label1 = new JLabel("Content 1");
        label1.setHorizontalAlignment(JLabel.CENTER);

        JLabel label2 = new JLabel("Content 2");
        label2.setHorizontalAlignment(JLabel.CENTER);

        button.add(label1, BorderLayout.NORTH);
        button.add(label2, BorderLayout.SOUTH);

        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
    }
}