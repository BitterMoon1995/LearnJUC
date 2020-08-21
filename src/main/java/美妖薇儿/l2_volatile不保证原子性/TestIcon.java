package 美妖薇儿.l2_volatile不保证原子性;

public class TestIcon {
    public static void main(String[] args){
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int x = 0;x < 10; x++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{
    //原子变量用CAS算法保证原子性
//    AtomicInteger i = new AtomicInteger();
    volatile int i = 0;
    public int getI(){
//        return i.getAndIncrement();
        return i++;//小问题：自增是原子操作吗？（笑嘻了）
    }
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getI());
    }
}