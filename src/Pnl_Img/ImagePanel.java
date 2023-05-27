package Pnl_Img;

import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        loadImage(imagePath);
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
    }

    private void loadImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel imagePanel = new ImagePanel("./Button_Image/img.jpg");
        frame.getContentPane().add(imagePanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}