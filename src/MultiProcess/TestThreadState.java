package MultiProcess;


import org.apache.batik.ext.awt.geom.ShapeExtender;

/**
 * ��ͣ�߳�ִ�е����ַ���
 * sleep : ������ʱ�䵽�˽������
 * yield: ֱ�ӽ������()
 */
public class TestThreadState {
    public static void main(String[] args) {
//        StateThread thread1 = new StateThread();
////        thread1.start();
////        StateThread thread2 = new StateThread();
////        thread2.start();
        StateThrea01 threa01 = new StateThrea01();
        threa01.start();
        StateThrea01 threa02 = new StateThrea01();
        threa02.start();

    }


}

//ʵ�ֶ��߳�
class StateThread extends Thread{
    public void run(){
        for (int i=0; i<100;i++){
            System.out.println(this.getName() + ":" + i);
            try {
                Thread.sleep(2000);//�����ֳ���sleep����,����ͣ��
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

}

class StateThrea01 extends Thread{
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println(this.getName() + "��" + i);
            Thread.yield();//�߳̽�����У�û��ͣ��
        }
    }



}