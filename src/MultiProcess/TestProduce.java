package MultiProcess;

/**
 * 线程并发实例，生产者，消费者问题！
 */
public class TestProduce {
    public static void main(String[] args) {
        SyncStack syncStack = new SyncStack();
        Producer p = new Producer(syncStack);
        Consumer consumer = new Consumer(syncStack);
        p.start();
        consumer.start();

    }
}


class Mantou{
    //馒头，消耗的资源
    int id;
    Mantou(int id){
        this.id = id;
    }

}

//缓冲区
class SyncStack{
    int index = 0;
    Mantou[] ms = new Mantou[10];//设置缓冲区的大小

    public synchronized void push(Mantou m){
        while (index == ms.length){ //说明缓冲区满了
            try {
                //wait后，线程会将持有的锁释放，进入阻塞状态
                //这样其他需要获得锁的线程将会获得锁
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        //唤醒在当前对象等待池中等待的第一个线程
        //notifyAll唤醒所有在线程池等待的线程
        this.notify();
        ms[index] = m;
        index++;
    }
    public synchronized Mantou pop(){
        while (index == 0){//如果缓冲池为空
            try {
                //停止消费
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        this.notify();
        index--;
        return ms[index];
    }

}

//生产者线程
class Producer extends Thread{
    SyncStack syncStack = null;

    public Producer(SyncStack syncStack){
        this.syncStack = syncStack;
    }

    public void run(){
        for (int i=0; i< 10; i++){
            System.out.println("produce: " + i );
            Mantou mantou = new Mantou(i);
            syncStack.push(mantou);
        }
    }

}
class Consumer extends Thread{
    SyncStack syncStack = null;
    public Consumer(SyncStack syncStack){
        this.syncStack = syncStack;
    }

    public void run(){
        for (int i=0; i<10; i++){
            Mantou mantou = syncStack.pop();
            System.out.println("consume:" + i);
        }
    }

}

