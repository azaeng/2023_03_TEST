package Pnl;

import javax.swing.*;
import java.awt.*;

public class DualColorFrame extends JFrame {
    private JPanel redPanel;
    private JPanel bluePanel;

    public DualColorFrame() {
        setTitle("Dual Color Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setPreferredSize(new Dimension(200, 300));

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setPreferredSize(new Dimension(200, 300));

        setLayout(new BorderLayout());

        add(redPanel, BorderLayout.EAST);
        add(bluePanel, BorderLayout.WEST);
    }
    
    public static void main(String[] args) {
    	DualColorFrame frame = new DualColorFrame();
    	frame.setVisible(true);
    }
}