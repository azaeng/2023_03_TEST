package Btn_Circle;

import javax.swing.*;
import java.awt.*;

class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);

        // 원하는 버튼 크기 설정
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        // 버튼 둥글게 만들기
        setContentAreaFilled(false);
        
     // 라벨의 폰트 크기 설정
        Font labelFont = getFont();
        setFont(labelFont.deriveFont(labelFont.getSize() + 4.0f));
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
        frame.setLayout(null); // 절대 위치 레이아웃으로 설정

        // 둥근 버튼 생성 및 속성 설정
        RoundButton roundButton = new RoundButton("Click me");
        roundButton.setBounds(100, 300, 100, 100); // 위치와 크기 설정
        roundButton.setForeground(Color.WHITE);
        roundButton.setBackground(Color.BLUE);

        // 프레임에 버튼 추가
        frame.add(roundButton);

        // 프레임 표시
        frame.setVisible(true);
    }
}