package MultiProcess;

public class TestThread extends Thread{
    /**
     * ͨ���̳�Thread��ʵ�ֶ��߳�
     * ȱ�㣺����Ѿ��̳���һ���࣬���޷��ټ̳�Thrad��
     * @param args
     */


    public static void main(String[] args) {

        //ʵ�����̶߳���
        TestThread thread1 = new TestThread();
        thread1.start();//�����߳�
        TestThread thread2 = new TestThread();
        thread2.start();
    }

    //�߳���
    public void run(){

        for (int i=0; i<10; i++){
            System.out.println(this.getName() + ":" + i);
        }
    }




}
