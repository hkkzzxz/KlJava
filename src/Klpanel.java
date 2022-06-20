import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Klpanel extends JPanel {
    light lSW,lSN,lSE,lEN,lEW,lES,lNW,lNS,lNE,lWN,lWE,lWS;      //十二个灯
    box box1,box2,box3,box4;                      //四组信号灯
    Car ClSW,ClSN,ClSE,ClEN,ClEW,ClES,ClNW,ClNS,ClNE,ClWN,ClWE,ClWS;//十二个方向的车
    static Carbox Cbox1,Cbox2,Cbox3,Cbox4;//四组车
    static int islight;//实现进程循环的辅助变量
    Random r=new Random();
    static public ArrayList<light> lightlist= new ArrayList<light>();   //使用list方便遍历每个灯//方便遍历每个车
    public  Klpanel() {
        // TODO Auto-generated constructor stub
        lSW=addlist(lSW, 212, 316, false);
        lSN=addlist(lSN, 242, 316, false);
        lSE=addlist(lSE, 272, 316, true);
        lEN=addlist(lEN, 316, 116, true);
        lEW=addlist(lEW, 316, 146, false);
        lES=addlist(lES, 316, 176, false);
        lNW=addlist(lNW,116 , 70, true);
        lNS=addlist(lNS, 146, 70, false);
        lNE=addlist(lNE, 176, 70, false);
        lWN=addlist(lWN, 70, 212, false);
        lWE=addlist(lWE, 70, 242, false);
        lWS=addlist(lWS, 70, 272, true);
        ClSW=new Car("CLSW");
        ClSN=new Car("CLSN");
        ClSE=new Car("ClSE");
        ClEN=new Car("ClEN");
        ClEW=new Car("ClEW");
        ClES=new Car("ClES");
        ClNW=new Car("ClNW");
        ClNS=new Car("ClNS");
        ClNE=new Car("ClNE");
        ClWN=new Car("ClWN");
        ClWE=new Car("ClWE");
        ClWS=new Car("ClWS");
        box1=new box(lNE,lSW,2000,false,0);
        box2=new box(lWE,lEW,2000,false,1);
        box3=new box(lWN,lES,2000,false,2);
        box4=new box(lNS,lSN,2000,false,3);
        Cbox1=new Carbox(ClNE,ClSW,ClNW,2000,0);
        Cbox2=new Carbox(ClWE,ClEW,ClWS,2000,1);
        Cbox3=new Carbox(ClWN,ClES,ClEN,2000,2);
        Cbox4=new Carbox(ClNS,ClSN,ClSE,2000,3);
        islight = 0 ;

//创建四条线程
        Thread t1=new Thread(box1);
        Thread t2=new Thread(box2);
        Thread t3=new Thread(box3);
        Thread t4=new Thread(box4);
        Thread t5=new Thread(Cbox1);
        Thread t6=new Thread(Cbox2);
        Thread t7=new Thread(Cbox3);
        Thread t8=new Thread(Cbox4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
    light addlist(light a,int x,int y,boolean sta) {
        a=new light(x,y,sta);
        lightlist.add(a);
        return a;
    }
    public void LampChange() {
        islight=(islight+1)%4;
    }
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.darkGray);        //画路
        g.fillRect(0, 100, 400, 6);
        g.fillRect(0, 300, 400, 6);
        g.fillRect(100, 0, 6, 400);
        g.fillRect(300, 0, 6, 400);
        g.setColor(Color.gray);
        g.fillRect(0, 200, 400, 2);
        g.fillRect(200, 0, 2, 400);
        g.setColor(Color.blue);

        g.setColor(Color.black);         //画信号灯板
        g.fillRect(202,306, 100, 40);
        g.fillRect(306,106, 40, 100);
        g.fillRect(106,60, 100, 40);
        g.fillRect(60,202,40, 100);
        light temp;
        for(int i=0;i<lightlist.size();i++) {       //画灯
            temp=lightlist.get(i);
            if(temp.isStatus())
                g.setColor(Color.green);
            else
                g.setColor(Color.RED);
            g.fillOval(temp.getX(), temp.getY(), 20, 20);
        }
    }
}
