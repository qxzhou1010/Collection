package z.qx.oo1203;

public class TestHash {
    public static void main(String[] args) {
        int h = 25860399;
        int length = 16;
        myHash(h, length);
    }

    /**
     *
     * @param h 任意整数
     * @param length 长度为2的整数幂
     * @return
     */
    public static  int myHash( int h, int length ){
        System.out.println(h&(length - 1));//取余和位运算效果一样
        System.out.println(h%length);
        return h&( length - 1);
    }


}
