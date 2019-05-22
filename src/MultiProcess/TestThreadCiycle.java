package MultiProcess;

public class TestThreadCiycle implements Runnable{
    /**
     * 终止进程的典型方法
     * 不用stop/destory方法，
     * 使用一个boolean型的变量
     * @param args
     */

    String name;
    boolean live = true;//标记变量，决定线程是否可以被终止

    public static void main(String[] args) {
        TestThreadCiycle ttc = new TestThreadCiycle("process A");
        Thread t1 = new Thread(ttc); //新生状态
        t1.start();
        for (int i=0; i<100; i++){
            System.out.println("Mian process" + i);
        }
        ttc.terminate();
        System.out.println("Stop");
    }

    public TestThreadCiycle(String name){
        super();
        this.name = name;
    }


    public void run(){
        int i=0;
        while (live){
            System.out.println(name + (i++));
        }

    }
    public void terminate(){
        live = false;
    }



}
