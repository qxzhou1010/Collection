package MultiProcess;


import org.apache.batik.ext.awt.geom.ShapeExtender;

/**
 * 暂停线程执行的两种方法
 * sleep : 阻塞，时间到了进入就绪
 * yield: 直接进入就绪()
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

//实现多线程
class StateThread extends Thread{
    public void run(){
        for (int i=0; i<100;i++){
            System.out.println(this.getName() + ":" + i);
            try {
                Thread.sleep(2000);//调用现场的sleep方法,明显停顿
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

}

class StateThrea01 extends Thread{
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println(this.getName() + "：" + i);
            Thread.yield();//线程交替进行，没有停顿
        }
    }



}