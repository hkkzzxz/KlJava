import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class setting extends JFrame implements ActionListener {
    JLabel label1,label2,label3,label4,label5;//四个组件
    JTextField jTextField1,jTextField2,jTextField3,jTextField4,jTextField5;//四个修改框
    JButton jButton1,jButton2;//确认取消键
    int time1,time2,time3,time4,time5;//四个时间对应四个修改框中的值
    public setting(){
        label1=new JLabel("南北左转：");
        label2=new JLabel("东西直行：");
        label3=new JLabel("东西左转：");
        label4=new JLabel("南北直行：");
        label5=new JLabel("生成时间");
        time1=Control.panel.box1.getgreentime();
        time2=Control.panel.box2.getgreentime();
        time3=Control.panel.box3.getgreentime();
        time4=Control.panel.box4.getgreentime();
        time5=Klpanel.Cbox1.getCreateTime();
        jTextField1=new JTextField(String.valueOf(time1));
        jTextField2=new JTextField(String.valueOf(time2));
        jTextField3=new JTextField(String.valueOf(time3));
        jTextField4=new JTextField(String.valueOf(time4));
        jTextField5=new JTextField(String.valueOf(time5));
        jButton1=new JButton("确定");
        jButton1.addActionListener(this);
        jButton2=new JButton("取消");
        jButton2.addActionListener(this);

        this.setLayout(new GridLayout(6,2,10,5));//设置行列间距
        this.add(label1);
        this.add(jTextField1);
        this.add(label2);
        this.add(jTextField2);
        this.add(label3);
        this.add(jTextField3);
        this.add(label4);
        this.add(jTextField4);
        this.add(label5);
        this.add(jTextField5);
        this.add(jButton1);
        this.add(jButton2);

        this.setLocationRelativeTo(null);//生成swing居中
        this.setSize(200, 200);//窗口大小
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==jButton1)
         {
             if(jTextField1.getText().length()==0||jTextField2.getText().length()==0||jTextField3.getText().length()==0||jTextField4.getText().length()==0)
                 JOptionPane.showMessageDialog(this, "请输入完整数据！", "错误", JOptionPane.INFORMATION_MESSAGE);
             else {
                 Control.panel.box1.setgreentime(Integer.parseInt(jTextField1.getText()));
                 Control.panel.box2.setgreentime(Integer.parseInt(jTextField2.getText()));
                 Control.panel.box3.setgreentime(Integer.parseInt(jTextField3.getText()));
                 Control.panel.box4.setgreentime(Integer.parseInt(jTextField4.getText()));
                 Klpanel.Cbox1.setCreateTime(Integer.parseInt(jTextField5.getText()));
                 Klpanel.Cbox2.setCreateTime(Integer.parseInt(jTextField5.getText()));
                 Klpanel.Cbox3.setCreateTime(Integer.parseInt(jTextField5.getText()));
                 Klpanel.Cbox4.setCreateTime(Integer.parseInt(jTextField5.getText()));
                 this.dispose();
             }
         }else if(e.getSource()==jButton2){
             this.dispose();
         }
         }
    }
