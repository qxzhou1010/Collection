package MultiProcess;


/**
 * 测试线程的联合
 * 线程A在运行期间，可以调用线程B的join()方法，让线程B和线程A联合。
 * 这样，线程A就必须等待线程B执行完毕后，才能继续执行。如下面示例中，
 * “爸爸线程”要抽烟，于是联合了“儿子线程”去买烟，必须等待“儿子线程”买烟完毕，“爸爸线程”才能继续抽烟。
 */

public class TestThreaJoin {
    public static void main(String[] args) {
        System.out.println("a story about buying cigratee");
        Thread father = new Thread(new FatherThread());
        father.start();
    }


}

class FatherThread implements Runnable{

    public void run(){
        System.out.println("爸爸想抽烟，发现烟抽完了");
        System.out.println("爸爸让儿子去买包红塔山");
        Thread son = new Thread(new SonThread());
        son.start();
        System.out.println("爸爸等儿子买烟回来");
        try {
            son.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("爸爸出门去找儿子跑哪去了");
            // 结束JVM。如果是0则表示正常结束；如果是非0则表示非正常结束
            System.exit(1);
        }
        System.out.println("爸爸高兴的接过烟开始抽，并把零钱给了儿子");

    }
}
class SonThread implements Runnable{
    public void run() {
        System.out.println("儿子出门去买烟");
        System.out.println("儿子买烟需要10分钟");
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("第" + i + "分钟");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("儿子买烟回来了");
    }

}
