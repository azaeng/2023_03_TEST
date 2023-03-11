package Test_01;

import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String[] arg) {
    	
    	//프레임 생성
    	JFrame frm = new JFrame("음료 키오스크");
    	
    	//프레임 크기 설정(가로, 세로)
        frm.setSize(800, 1000);
        
        //프레임 화면 가운데 배치
        frm.setLocationRelativeTo(null);
        
        //프레임이 닫혔을 때 메모리에서 제거
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 레이아웃 설정
        frm.getContentPane().setLayout(null);
        
        //버튼 생성
        JButton btn = new JButton("주문하시려면 화면을 터치해주세요");
        
        // 버튼 위치와 크기 설정 (가로위치, 세로위치, 가로길이, 세로길이)
        btn.setBounds(30, 831, 724, 100);
        
        // 버튼의 글자 폰트, 굵기, 크기 설정
        btn.setFont(new Font("Aharoni", Font.PLAIN, 40));
        
        // 버튼 배경색 설정
        btn.setBackground(Color.WHITE);
        
        //프레임에 버튼 추가
        frm.add(btn);
        
        //프레임 보이도록 설정
        frm.setVisible(true);
    }
}