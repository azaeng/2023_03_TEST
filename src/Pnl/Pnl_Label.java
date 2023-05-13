package Pnl;

import javax.swing.*;
import java.awt.*;

public class Pnl_Label extends JFrame {
    private JPanel redPanel;

    public Pnl_Label() {
        setTitle("Pnl_Label");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 500, 500);
        redPanel.setLayout(null);

        JLabel lbl = new JLabel("안녕");
        lbl.setBounds(0, 0, 150, 100);
        lbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 70));
        redPanel.add(lbl);

        setLayout(null);
        add(redPanel);
    }

    public static void main(String[] args) {
    	Pnl_Label frame = new Pnl_Label();
    	frame.setVisible(true);
	}
}