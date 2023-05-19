package Btn_Img;

import java.awt.*;
import javax.swing.*;


public class Test extends JFrame {
	
	JPanel main_panel; // 버튼을 붙여질 메인 패널 선언

	JButton bt_img1;
	JButton bt_img2;
	
	ImageIcon img1 = new ImageIcon("./Button_Image/img1.jpg");
	ImageIcon img2 = new ImageIcon("./Button_Image/img2.jpg");
	
	
	public Test() {
		setTitle("JButton 이미지넣기 예제"); // 프레임 타이틀바 텍스트 지정
		//setExtendedState(JFrame.MAXIMIZED_BOTH); // 프레임 전체화면
		 setSize(1800,1000); // 프레임 크기 조정(픽셀)
		 setLocationRelativeTo(null); //프레임 가운데 조정
		// 프레임바 우측상단에 X버튼에 대한 강제종료 기능 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main_panel = new JPanel(); // 패널 객체화 / 기본배치관리자 FlowLayout
		main_panel.setBackground(Color.WHITE); // 패널 배경색 하얀색으로 설정
		
		bt_img1 = new JButton(img1);
		bt_img1.setRolloverIcon(img2); // 버튼에 마우스가 올라갈떄 이미지 변환
		bt_img1.setBorderPainted(false); // 버튼 테두리 설정해제
		bt_img1.setPreferredSize(new Dimension(300, 120)); // 버튼 크기 지정
		
		bt_img2 = new JButton(img2);
		bt_img2.setBorderPainted(false); // 버튼 테두리 설정해제
		bt_img2.setPreferredSize(new Dimension(300, 120)); // 버튼 크기 지정
		
		main_panel.add(bt_img1); // 패널에 버튼을 붙여준다
		main_panel.add(bt_img2);
		
		add(main_panel); // 메인 프레임에 메인패널을 붙여주는 작업
		
		setVisible(true); // 프레임 보이게 하기
	}
	
	public static void main(String[] args) {
		new Test();
	}
}