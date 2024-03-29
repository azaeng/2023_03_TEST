package Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ex12 extends JFrame{
    Ex12(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new DrawingPanel());
        this.setSize(300, 300);
        this.setVisible(true);
    }
    
    class DrawingPanel extends JPanel{
        DrawingThread th;
        Rectangle r = new Rectangle(0,0,0,0);
        
        DrawingPanel(){
            this.addMouseListener(new MyMouseListener());
            th=new DrawingThread(this);
            th.start();
        }
        
        public void setObj(int x, int y, int w, int h){
            r.x=x;
            r.y=y;
            r.width=w;
            r.height=h;
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(r.width==0||r.height==0){
                return;
            }
            g.setColor(Color.MAGENTA);
            g.fillOval(r.x, r.y, r.width, r.height);//사각형의 크기의 내접하는 원을 생성
        }
        
        class MyMouseListener implements MouseListener{

            @Override
            public void mouseClicked(MouseEvent me) {}

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {
                setTitle("Make Drawing to Start");
                th.wakeup();//마우스가 프레임내로 들어오면 스레드를 실행시킨다.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setTitle("Make Drawing to Pause");
                th.pause();//마우스가 프레임밖으로 나가면 스레드를 일시정지 시킨다.
            }

        }
    }
    
    class DrawingThread extends Thread{
        boolean running =true;
        Object obj=new Object();
        DrawingPanel p;
        
        DrawingThread(DrawingPanel p){
            this.p=p;
        }      
        public void wakeup(){
            running=true;//실행중인 상태 표시
            synchronized(obj){
                obj.notify();
            }
        }    
        public void pause(){
            running=false;//실행중이지 않은 상태 표시
        }       
        public void run(){
            try{
                synchronized(obj){
                    obj.wait();//실행중이면 스레드를 기다리게한다.
                }
            }
            catch(Exception e){return;}
            
            while(true){
                if(p.isValid()){//패널이 만들어져있다면
                    if(!running){//타원만들기 스레드가 실행중이지 않으면
                        try{
                            synchronized(obj){
                                obj.wait();//기다린다.
                            }
                        }
                        catch(Exception e){return;}
                    }
                    //타원크기정보를 랜덤으로 생성
                    int x=(int)(Math.random()*p.getWidth());
                    int y=(int)(Math.random()*p.getHeight());
                    int w=(int)(Math.random()*100)+1;
                    int h=(int)(Math.random()*100)+1;
                    //타원크기정보를 보내 만들게 한다.
                    p.setObj(x, y, w, h);
                    p.repaint();
                }
                try{
                    Thread.sleep(300);
                }
                catch(Exception e){return;}
            }
        }
    }  
}

public class Circle {
    public static void main(String[] args) {
        new Ex12();
    }
}