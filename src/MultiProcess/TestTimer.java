package MultiProcess;

import java.util.Timer;
import java.util.TimerTask;

//任务定时调度
public class TestTimer {
    public static void main(String[] args) {
        Timer t1 = new Timer();//定义定时器
        MyTask task1 = new MyTask();//定义任务
        t1.schedule(task1, 3000);//3s后执行
    }
}

class MyTask extends TimerTask{

    public void run(){
        for (int i=0; i< 10; i++){
            System.out.println("task1:" + i);
        }
    }


}
