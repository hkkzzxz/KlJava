import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control extends JFrame implements ActionListener {
    static Klpanel panel;
    JMenuBar jmb;
    JMenu jm1, jm2;
    JMenuItem jmi1, jmi2,jmi3;
    Initial sp;
    Control(){
        this.setTitle("traffic");
        this.setSize(420,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jmb=new JMenuBar();

        jm1=new JMenu("控制");
        jm2=new JMenu("设置");

        jmi1=new JMenuItem("开始模拟");
        jmi1.addActionListener(this);
        jmi2=new JMenuItem("退出模拟");
        jmi2.addActionListener(this);
        jmi3=new JMenuItem("更改绿灯时间");
        jmi3.addActionListener(this);

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm2.add(jmi3);
        jmb.add(jm1);
        jmb.add(jm2);

        this.setJMenuBar(jmb);
        sp=new Initial();
        this.setContentPane(sp);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jmi1) {
            sp.isLive=false;
            this.remove(sp);
            panel = new Klpanel();
            this.setContentPane(panel);
            this.setVisible(true);
        }else if(e.getSource()==jmi2) {
            System.exit(0);
        }
        else if (e.getSource() == jmi3) {
            if(Control.panel==null)
                JOptionPane.showMessageDialog(this, "请开始模拟再进行设置", "错误", JOptionPane.INFORMATION_MESSAGE);
            else new setting();
        }
    }
    public static void main(String[] args) {
        new Control();
    }
}
