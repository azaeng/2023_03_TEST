package Event;

import javax.swing.*;

public class Event extends JFrame {

    JButton btn1 = new JButton("왼쪽");
    JButton btn2 = new JButton("오른쪽");
    JLabel lbl = new JLabel();

    public Event() {
        setTitle("버튼 이벤트 생성");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btn1.setBounds(30, 170, 122, 30);
        btn1.addActionListener(event -> {
            lbl.setText("나는 왼쪽!!");
        });

        btn2.setBounds(182, 170, 122, 30);
        btn2.addActionListener(event -> {
            lbl.setText("나는 오른쪽!!");
        });

        lbl.setBounds(30, 200, 274, 50);
        lbl.setText("버튼을 누르세요!!");
        lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬

        add_btn(); // 프레임에 구성 요소를 추가하는 메서드 호출
    }

    public void add_btn() {
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(lbl);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Event frame = new Event();
            frame.setVisible(true);
        });
    }
}