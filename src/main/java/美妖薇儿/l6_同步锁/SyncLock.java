package 美妖薇儿.l6_同步锁;

public class SyncLock {
    public static void main(String[] args) {
        Ticket0 td = new Ticket0();
        new Thread(td, "窗口1").start();
        new Thread(td, "窗口2").start();
        new Thread(td, "窗口3").start();
        new Thread(td, "窗口4").start();
    }
}

class Ticket0 implements Runnable {
    private int ticket = 100;
    @Override
//    public synchronized void run() {   //同步方法
    public void run() {
        synchronized (this){//同步代码块
            while (true) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + (--ticket));
                }
            }
        }
    }
}
