package Btn_Circle;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
//import java.awt.geom.Ellipse2D;

class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);

        // 원하는 버튼 크기 설정
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        // 버튼 둥글게 만들기
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }
    
    @Override
    public boolean contains(int x, int y) {
        int radius = Math.min(getWidth(), getHeight()) / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int distX = centerX - x;
        int distY = centerY - y;
        return (distX * distX + distY * distY) <= (radius * radius);
    }
}

public class RoundButton_main {
    public static void main(String[] args) {
        // 프레임 생성 및 속성 설정
        JFrame frame = new JFrame("Round Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null); // 화면 중앙에 프레임 배치
        frame.setLayout(new FlowLayout()); // 흐름 레이아웃 사용

        // 둥근 버튼 생성 및 속성 설정
        RoundButton roundButton = new RoundButton("Click me");
        roundButton.setPreferredSize(new Dimension(300, 300)); // 크기 설정
        roundButton.setForeground(Color.WHITE);
        roundButton.setBackground(Color.BLUE);

        // 프레임에 버튼 추가
        frame.add(roundButton);

        // 프레임 표시
        frame.setVisible(true);
    }
}