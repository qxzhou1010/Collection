package MultiProcess;

import leetCode.Stack.TestJavaQue;

import java.util.IdentityHashMap;

/**
 * 测试线程同步
 * 多个线程操作同一个对象，这里未使用线程同步,
 * 可以运行程序发现结果很荒谬
 */
public class TestSync {
    public static void main(String[] args) {
        Account a1 = new Account(100, "zqx");
        Drawing02 draw1 = new Drawing02(80, a1);//定义线程取钱
        Drawing02 draw2 = new Drawing02(80, a1);
        draw1.start();
        draw2.start();
    }
}

/**
 * 银行账户类
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
 * 取钱操作，未实现线程同步
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
        System.out.println(this.getName() + "--账户余额" + account.money);
        System.out.println(this.getName() + "--总共取了" + expenseTotal);

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
        System.out.println(this.getName() + "--余额" + account.money);
        System.out.println(this.getName() + "--总共取了" + expenseTotal);


    }



}
