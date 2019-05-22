package MultiProcess;

import leetCode.Stack.TestJavaQue;

import java.util.IdentityHashMap;

/**
 * �����߳�ͬ��
 * ����̲߳���ͬһ����������δʹ���߳�ͬ��,
 * �������г����ֽ���ܻ���
 */
public class TestSync {
    public static void main(String[] args) {
        Account a1 = new Account(100, "zqx");
        Drawing02 draw1 = new Drawing02(80, a1);//�����߳�ȡǮ
        Drawing02 draw2 = new Drawing02(80, a1);
        draw1.start();
        draw2.start();
    }
}

/**
 * �����˻���
 */
class Account{
    int money;
    String name;
    public Account(int money, String name){
        super();
        this.money = money;
        this.name = name;
    }
}

/**
 * ȡǮ������δʵ���߳�ͬ��
 */
class Drawing extends Thread{
    int drawingNum;
    Account account;
    int expenseTotal;
    public Drawing(int drawingNum, Account account){
        super();
        this.drawingNum = drawingNum;
        this.account = account;
    }

    public void run(){
        if (account.money - drawingNum < 0){
            return;
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        account.money -= drawingNum;
        expenseTotal += drawingNum;
        System.out.println(this.getName() + "--�˻����" + account.money);
        System.out.println(this.getName() + "--�ܹ�ȡ��" + expenseTotal);

    }




}

class Drawing02 extends Thread{
    int drawingNum;
    Account account;
    int expenseTotal;
    public Drawing02(int drawingNum, Account account){
        super();
        this.drawingNum = drawingNum;
        this.account = account;
    }
    public void run(){

        draw();

    }
    void draw(){
        synchronized (account){
            if (account.money - drawingNum < 0){
                System.out.println("the money is less");
                return;
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            account.money -= drawingNum;
            expenseTotal += drawingNum;
        }
        System.out.println(this.getName() + "--���" + account.money);
        System.out.println(this.getName() + "--�ܹ�ȡ��" + expenseTotal);


    }



}
