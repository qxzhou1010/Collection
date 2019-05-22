package MultiProcess;

/**
 * 进程死锁及其解决方案
 */
public class TestDeadLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup();
        m1.girl = "Sunny";
        m1.flag = 0;
        Makeup m2 = new Makeup();
        m2.girl = "Mali";
        m2.flag = 1;
        m1.start();
        m2.start();

    }
}

//口红类
class Lipstick{

}
//镜子类
class Mirror{

}

class Makeup extends Thread{
    int flag;
    String girl;
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    public void run(){
//        doMakeup();
        doMakeup02();
    }

    void doMakeup(){
        if (flag == 0){
            synchronized (lipstick) {
                //需要得到口红的锁
                System.out.println(girl + "handle the lipstick");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (mirror) {
                    //需要拿到镜子的锁
                    System.out.println(girl + "hand the mirror");

                }
            }//注意个同步块的包含关系，一个同步块同时持有了多个对象锁，所以造成了死锁
            //解决办法就是不让一个同步块同时持有多个对象锁

        }else {
            synchronized (mirror) {
                System.out.println(girl + "hand the mirror");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lipstick) {
                    System.out.println(girl + "hand the lipstick");
                }
            }//注意个同步块的包含关系，一个同步块同时持有了多个对象锁，所以造成了死锁

        }
    }
    void doMakeup02(){
        if (flag == 0){
            synchronized (lipstick) {
                //需要得到口红的锁
                System.out.println(girl + "handle the lipstick");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//一个同步块只包含了一个对象锁
                synchronized (mirror) {
                    //需要拿到镜子的锁
                    System.out.println(girl + "hand the mirror");

                }
            //注意个同步块的包含关系，一个同步块同时持有了多个对象锁，所以造成了死锁
            //解决办法就是不让一个同步块同时持有多个对象锁

        }else {
            synchronized (mirror) {
                System.out.println(girl + "hand the mirror");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//一个同步块只包含了一个对象锁
                synchronized (lipstick) {
                    System.out.println(girl + "hand the lipstick");
                }


        }

    }

}
