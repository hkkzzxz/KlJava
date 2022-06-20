import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class box implements Runnable{
    light opposite,now;//对面灯，当前灯
    int greentime;//绿灯亮的时间
    int name; //灯组的名字
    boolean status; //状态
    static Object lock=new Object();
    public box(light opposite, light now, int greentime, boolean status,int name) {
        this.opposite = opposite;
        this.now = now;
        this.greentime = greentime;
        this.name = name;
        this.status = status;
    }
    public void setgreentime(int greentime)
    {
        this.greentime=greentime;
    }
    public int getgreentime() {
        return this.greentime;
    }
    public void change()
    {
        this.status=!(this.status);
        lightstatues();
    }
    public void lightstatues() {
        opposite.setlight(this.status);
        now.setlight(this.status);
    }
    @Override
    public void run()
    {
        while (true)
        {
            synchronized (lock)
            {
                if (box.this.name == Control.panel.islight) {           //使用辅助变量实现进程按顺序循环
                    System.out.println("now is: "+name);
                change();
                    Control.panel.repaint();
                try {
                    Thread.sleep(greentime);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notifyAll();                //唤醒其他进程
                change();
                Control.panel.LampChange();
                System.out.println(Klpanel.islight);
                Control.panel.repaint();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
            try {
                lock.wait();           //挂起进程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            }
        }
    }
}
