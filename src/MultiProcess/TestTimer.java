package MultiProcess;

import java.util.Timer;
import java.util.TimerTask;

//����ʱ����
public class TestTimer {
    public static void main(String[] args) {
        Timer t1 = new Timer();//���嶨ʱ��
        MyTask task1 = new MyTask();//��������
        t1.schedule(task1, 3000);//3s��ִ��
    }
}

class MyTask extends TimerTask{

    public void run(){
        for (int i=0; i< 10; i++){
            System.out.println("task1:" + i);
        }
    }


}
