package MultiProcess;

/**
 * �̲߳���ʵ���������ߣ����������⣡
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
    //��ͷ�����ĵ���Դ
    int id;
    Mantou(int id){
        this.id = id;
    }

}

//������
class SyncStack{
    int index = 0;
    Mantou[] ms = new Mantou[10];//���û������Ĵ�С

    public synchronized void push(Mantou m){
        while (index == ms.length){ //˵������������
            try {
                //wait���̻߳Ὣ���е����ͷţ���������״̬
                //����������Ҫ��������߳̽�������
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        //�����ڵ�ǰ����ȴ����еȴ��ĵ�һ���߳�
        //notifyAll�����������̳߳صȴ����߳�
        this.notify();
        ms[index] = m;
        index++;
    }
    public synchronized Mantou pop(){
        while (index == 0){//��������Ϊ��
            try {
                //ֹͣ����
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

//�������߳�
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

