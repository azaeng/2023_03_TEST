package Circle_Move;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CircleAnimation extends JPanel implements ActionListener {

    private int x = 0;
    private int y = 150;
    private int radius = 50;
    private int velX = 3;
    private int width = 600;
    private int height = 300;

    public CircleAnimation() {
        setPreferredSize(new Dimension(width, height));

        // 10밀리초마다 애니메이션을 업데이트하도록 타이머 설정
        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 원 그리기
        g.setColor(Color.RED);
        g.fillOval(x, y, radius, radius);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 원의 위치 업데이트
        x += velX;

        // 원이 화면의 오른쪽 가장자리를 벗어나면 왼쪽 가장자리로 감쌉니다.
        if (x > width) {
            x = -radius;
        }

        // 업데이트된 원 위치를 표시하도록 패널을 다시 칠합니다.
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Animation");
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CircleAnimation());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}