package Pnl;

import javax.swing.*;
import java.awt.*;

public class One_Panel extends JFrame {
    private JPanel redPanel;

    public One_Panel() {
        setTitle("One Pannel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 500, 500);

        setLayout(null);
        add(redPanel);
    }

    public static void main(String[] args) {
    	One_Panel frame = new One_Panel();
    	frame.setVisible(true);
    }
}