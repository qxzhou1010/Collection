package MultiProcess;

public class TestThread2 implements Runnable {
    /**
     * 通过Runnable接口实现多线程
     * 实现这个接口的同时，还可以继承多个类，此种方法实现多线程更加通用
     * @param args
     */
    public static void main(String[] args) {
        //创建对象，把实现了Runnable接口的对象作为参数传入
        Thread thread1 = new Thread(new TestThread2());
        thread1.start();
        Thread thread2 = new Thread( new TestThread2());
        thread2.start();

    }

    public void run(){
        for (int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
