package MultiProcess;


/**
 * �����̵߳�����
 * �߳�A�������ڼ䣬���Ե����߳�B��join()���������߳�B���߳�A���ϡ�
 * �������߳�A�ͱ���ȴ��߳�Bִ����Ϻ󣬲��ܼ���ִ�С�������ʾ���У�
 * ���ְ��̡߳�Ҫ���̣����������ˡ������̡߳�ȥ���̣�����ȴ��������̡߳�������ϣ����ְ��̡߳����ܼ������̡�
 */

public class TestThreaJoin {
    public static void main(String[] args) {
        System.out.println("a story about buying cigratee");
        Thread father = new Thread(new FatherThread());
        father.start();
    }


}

class FatherThread implements Runnable{

    public void run(){
        System.out.println("�ְ�����̣������̳�����");
        System.out.println("�ְ��ö���ȥ�������ɽ");
        Thread son = new Thread(new SonThread());
        son.start();
        System.out.println("�ְֵȶ������̻���");
        try {
            son.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("�ְֳ���ȥ�Ҷ�������ȥ��");
            // ����JVM�������0���ʾ��������������Ƿ�0���ʾ����������
            System.exit(1);
        }
        System.out.println("�ְָ��˵Ľӹ��̿�ʼ�飬������Ǯ���˶���");

    }
}
class SonThread implements Runnable{
    public void run() {
        System.out.println("���ӳ���ȥ����");
        System.out.println("����������Ҫ10����");
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("��" + i + "����");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�������̻�����");
    }

}
