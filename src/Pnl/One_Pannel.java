package Pnl;

import javax.swing.*;
import java.awt.*;

public class One_Pannel extends JFrame {
    private JPanel redPanel;

    public One_Pannel() {
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
    	One_Pannel frame = new One_Pannel();
    	frame.setVisible(true);
    }
}