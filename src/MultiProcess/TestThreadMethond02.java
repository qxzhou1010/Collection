package MultiProcess;

/**
 * 设置线程优先级
 */
public class TestThreadMethond02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread02(), "t1");
        Thread t2 = new Thread(new MyThread02(), "t2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
class MyThread02 extends Thread{
    public void run(){
        for (int i=0; i<10;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}
