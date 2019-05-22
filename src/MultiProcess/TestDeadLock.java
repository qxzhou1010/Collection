package MultiProcess;

/**
 * ������������������
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

//�ں���
class Lipstick{

}
//������
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
                //��Ҫ�õ��ں����
                System.out.println(girl + "handle the lipstick");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (mirror) {
                    //��Ҫ�õ����ӵ���
                    System.out.println(girl + "hand the mirror");

                }
            }//ע���ͬ����İ�����ϵ��һ��ͬ����ͬʱ�����˶�����������������������
            //����취���ǲ���һ��ͬ����ͬʱ���ж��������

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
            }//ע���ͬ����İ�����ϵ��һ��ͬ����ͬʱ�����˶�����������������������

        }
    }
    void doMakeup02(){
        if (flag == 0){
            synchronized (lipstick) {
                //��Ҫ�õ��ں����
                System.out.println(girl + "handle the lipstick");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//һ��ͬ����ֻ������һ��������
                synchronized (mirror) {
                    //��Ҫ�õ����ӵ���
                    System.out.println(girl + "hand the mirror");

                }
            //ע���ͬ����İ�����ϵ��һ��ͬ����ͬʱ�����˶�����������������������
            //����취���ǲ���һ��ͬ����ͬʱ���ж��������

        }else {
            synchronized (mirror) {
                System.out.println(girl + "hand the mirror");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//һ��ͬ����ֻ������һ��������
                synchronized (lipstick) {
                    System.out.println(girl + "hand the lipstick");
                }


        }

    }

}
