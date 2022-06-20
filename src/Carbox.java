import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Carbox implements Runnable {
    //汽车对立面的归为同组
    Car opposite, now,right;//当前车对面车右转车(这里有点乱写了，但是为了省事)
    int createTime;//创建时间
    int cbname;//车组的名字
    static Object lock = new Object();
    private int status;//状态
    //采用blockqueue是为了将来改进用
    BlockingQueue<String> nowblockingQueue = new ArrayBlockingQueue<>(30);
    BlockingQueue<String> rightblockingQueue=new ArrayBlockingQueue<>(30);
    public Carbox(Car opposite, Car now,Car right,int createTime, int cbname) {
        this.opposite = opposite;
        this.now = now;
        this.right=right;
        this.createTime = createTime;
        this.cbname = cbname;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void CarCreate(String car) throws InterruptedException {
        nowblockingQueue.put(car);
    }

    @Override
    public void run() {
        String filename = String.valueOf(Carbox.this.cbname) + ".txt";
        for (int i = 1; i < 50; i++) {
            try {
                CarCreate(now.getCar_Name());
                CarCreate(opposite.getCar_Name());
                rightblockingQueue.put(right.getCar_Name());
                Thread.sleep(createTime);//创建间隔时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!rightblockingQueue.isEmpty())
            {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
                    writer.append(rightblockingQueue.take() + "\r\n");
                    //System.out.println(name+"已经写入");
                    writer.flush();
                    writer.close();
                    Thread.sleep(1000);//通过1s
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (this.cbname == Control.panel.islight && !nowblockingQueue.isEmpty()) {
                try {
                   // System.out.println(nowblockingQueue.peek()+"出来");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
                    writer.append(nowblockingQueue.take() + "\r\n");
                    //System.out.println(name+"已经写入");
                    writer.flush();
                    writer.close();
                    Thread.sleep(1000);//通过1s
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
