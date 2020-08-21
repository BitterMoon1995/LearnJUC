package 美妖薇儿.l1_内存可见性;

public class TestVolatile {
    public static void main(String[] args){ //这个线程是用来读取flag的值的
        DemoThread demoThread = new DemoThread();
        Thread thread = new Thread(demoThread);
        thread.start();
        //由于多个线程对于共享内存的不可见性，也就是不同线程之间无法直接访问其他线程工作内存中的变量
        //DemoThread对于flag值的改变并不会同步到MainThread的工作内存中，
        //MainThread中的flag值还是"毛腊肉猪狗不如"
        while (true){
                if (demoThread.flag.equals("习近平全家死绝永世不得超生")) {
                    System.out.println("主线程读取到的flag = " + demoThread.flag);
                    break;
                }
        }
        //艺能之synchronized   保证（变量复合操作的）原子性、内存可见性。但是太慢了
//        while (true){
//            synchronized (demoThread)
//            {
//            if (demoThread.flag.equals("习近平全家死绝永世不得超生")) {
//                System.out.println("主线程读取到的flag = " + demoThread.flag);
//                break;
//            }
//            }
//        }

        
    }
}
class DemoThread implements Runnable{ //这个线程是用来修改flag的值的
//    public String flag = "毛腊肉猪狗不如";
    //新艺能之volatile  通过设置内存屏障，保证了可见性（同步）。
    //不加锁，不阻塞线程，所以不保证原子性。比synchronized轻量
    public volatile String flag = "毛腊肉猪狗不如";

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = "习近平全家死绝永世不得超生";
        System.out.println("DemoThread线程修改后的flag = " + flag);
    }
}