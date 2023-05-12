package Btn_RoundSquare;

import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class RoundSquareButton extends JButton {

    private int arcWidth;  // 둥근 모서리의 너비
    private int arcHeight; // 둥근 모서리의 높이
    
    // 버튼 크기 설정
    public RoundSquareButton(String label) {
        super(label);
        arcWidth = 20;
        arcHeight = 20;
        setContentAreaFilled(false);
    }

    // 마우스 클릭 시 버튼 색 변경
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray);
        } else {
            g.setColor(getBackground());
        }
        int x = 0;
        int y = 0;
        int w = getWidth() - 1;
        int h = getHeight() - 1;
        g.fillRoundRect(x, y, w, h, arcWidth, arcHeight);
        super.paintComponent(g);
    }

    // 
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        int x = 0;
        int y = 0;
        int w = getWidth() - 1;
        int h = getHeight() - 1;
        g.drawRoundRect(x, y, w, h, arcWidth, arcHeight);
    }

    @Override
    public boolean contains(int x, int y) {
        Shape shape = createShape();
        return shape.contains(x, y);
    }

    private Shape createShape() {
        int x = 0;
        int y = 0;
        int w = getWidth() - 1;
        int h = getHeight() - 1;
        int aw = arcWidth;
        int ah = arcHeight;
        return new RoundRectangle2D.Float(x, y, w, h, aw, ah);
    }
}

public class RoundSquareButtonMain {
    public static void main(String[] args) {
        // 프레임 생성 및 속성 설정
        JFrame frame = new JFrame("Round Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null); // 화면 중앙에 프레임 배치
        frame.setLayout(new FlowLayout()); // 흐름 레이아웃 사용

        // 둥근 버튼 생성 및 속성 설정
        RoundSquareButton rb = new RoundSquareButton("Click me");
        rb.setPreferredSize(new Dimension(100, 100));
        rb.setForeground(Color.WHITE);
        rb.setBackground(Color.BLUE);

        // 프레임에 버튼 추가
        frame.add(rb);

        // 프레임 표시
        frame.setVisible(true);
    }
}