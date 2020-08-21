package 美妖薇儿.l4_闭锁;


public class NoCountDownLatch {
    //10个线程执行从0加到5000，要计算总共用了多少时间
    //然而主线程管球得你们搞啥子，开局就会输出 0秒，爆笑了
    public static void main(String[] args){
        NoLatchDemo ld = new NoLatchDemo();
        long start = System.currentTimeMillis();
        for (int i = 0;i<10;i++){
            new Thread(ld).start();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为："+(end - start)+"秒");
    }
}

class NoLatchDemo implements Runnable{
    public NoLatchDemo(){
    }
    @Override
    public void run() {
        for (int i = 0;i<5000;i++){
            if (i % 2 == 0){//50000以内的偶数
                System.out.println(i);
            }
        }
    }
}
