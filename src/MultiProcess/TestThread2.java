package MultiProcess;

public class TestThread2 implements Runnable {
    /**
     * ͨ��Runnable�ӿ�ʵ�ֶ��߳�
     * ʵ������ӿڵ�ͬʱ�������Լ̳ж���࣬���ַ���ʵ�ֶ��̸߳���ͨ��
     * @param args
     */
    public static void main(String[] args) {
        //�������󣬰�ʵ����Runnable�ӿڵĶ�����Ϊ��������
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
