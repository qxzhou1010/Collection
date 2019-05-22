package MultiProcess;


/**
 * 线程相关基本方法
 */

public class TestThreadMethond {
    public static void main(String[] args) throws Exception {
        Runnable r = new MyThread();
        //定义线程对象，传入参数(线程名)
        Thread thread = new Thread(r, "Name test");
        thread.start();//启动线程
        //获取线程名称
        System.out.println("name:" + thread.getName());
        //线程暂停
        Thread.currentThread().sleep(5000);
        //判断线程是否还在运行
        System.out.println(thread.isAlive());
        System.out.println("end");

    }
}
class MyThread implements Runnable{
    public void run(){
        for (int i=0; i<10; i++){
            System.out.println(i);
        }
    }


}
