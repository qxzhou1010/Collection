package MultiProcess;

public class TestThreadCiycle implements Runnable{
    /**
     * ��ֹ���̵ĵ��ͷ���
     * ����stop/destory������
     * ʹ��һ��boolean�͵ı���
     * @param args
     */

    String name;
    boolean live = true;//��Ǳ����������߳��Ƿ���Ա���ֹ

    public static void main(String[] args) {
        TestThreadCiycle ttc = new TestThreadCiycle("process A");
        Thread t1 = new Thread(ttc); //����״̬
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
