package MultiProcess;


/**
 * �߳���ػ�������
 */

public class TestThreadMethond {
    public static void main(String[] args) throws Exception {
        Runnable r = new MyThread();
        //�����̶߳��󣬴������(�߳���)
        Thread thread = new Thread(r, "Name test");
        thread.start();//�����߳�
        //��ȡ�߳�����
        System.out.println("name:" + thread.getName());
        //�߳���ͣ
        Thread.currentThread().sleep(5000);
        //�ж��߳��Ƿ�������
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
