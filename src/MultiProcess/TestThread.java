package MultiProcess;

public class TestThread extends Thread{
    /**
     * 通过继承Thread类实现多线程
     * 缺点：如果已经继承了一个类，则无法再继承Thrad类
     * @param args
     */


    public static void main(String[] args) {

        //实例化线程对象
        TestThread thread1 = new TestThread();
        thread1.start();//启动线程
        TestThread thread2 = new TestThread();
        thread2.start();
    }

    //线程体
    public void run(){

        for (int i=0; i<10; i++){
            System.out.println(this.getName() + ":" + i);
        }
    }




}
