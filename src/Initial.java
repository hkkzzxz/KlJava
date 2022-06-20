import javax.swing.*;
import java.awt.*;

public class Initial extends JPanel{
    Boolean isLive=true;
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 420,450);
        g.setColor(Color.red);
        g.setFont(new Font("微软雅黑", Font.BOLD, 30));
            g.drawString("多线程红绿灯模拟", 80, 150);
    }
}
