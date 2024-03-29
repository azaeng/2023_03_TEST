package Btn_Shape;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class SwingAPIEx extends JFrame{
    JButton b1 ,b2, b3, b4;
    SwingAPIEx(){
        this.setTitle("Swing공통 메소드");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        b1= new JButton("위치와 크기 정보");
        b2= new JButton("모양정보");
        b3= new JButton("작동하지 않는 버튼");
        b4= new JButton("숨기기/보이기");
        b1.addActionListener(new MyActionListener());
        this.add(b1);
        
        b2.setOpaque(true);
        b2.setForeground(Color.MAGENTA);
        b2.setBackground(Color.YELLOW);
        b2.setFont(new Font("고딕체", Font.ITALIC, 20));
        b2.addActionListener(new MyActionListener());
        this.add(b2);
        
        b3.setEnabled(false);
        b3.addActionListener(new MyActionListener());
        this.add(b3);
        
        b4.addActionListener(new MyActionListener());
        this.add(b4);
        
        this.setSize(600,100);
        this.setVisible(true);
    }
   
    class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source=e.getSource();
            
            if(source==b1){
                System.out.println("버튼의 위치와 크기");
                System.out.println("위치=("+b1.getX()+","+b1.getY()+")");
                System.out.println("크기=("+b1.getWidth()+","+b1.getHeight()+")");
                
                JPanel c=(JPanel)b2.getParent();
                System.out.println("컨텐트팬의 위치와 크기");
                System.out.println("위치=("+c.getX()+","+c.getY()+")");
                System.out.println("크기=("+c.getWidth()+","+c.getHeight()+")");
            }
            else if(source==b2){
                System.out.println("폰트="+b2.getFont());
                System.out.println("배경색="+b2.getBackground());
                System.out.println("글자색"+b2.getForeground());
            }
            else{
                if(b1.isVisible()){
                    b1.setVisible(false);
                    b2.setVisible(false);
                    b3.setVisible(false);
                }
                else{
                    b1.setVisible(true);
                    b2.setVisible(true);
                    b3.setVisible(true);
                }
            }
        }
        
    }
}
public class Btn_shape {

    public static void main(String[] args) {
        new SwingAPIEx();
    }
    
}