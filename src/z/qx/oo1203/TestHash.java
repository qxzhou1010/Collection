package z.qx.oo1203;

public class TestHash {
    public static void main(String[] args) {
        int h = 25860399;
        int length = 16;
        myHash(h, length);
    }

    /**
     *
     * @param h ��������
     * @param length ����Ϊ2��������
     * @return
     */
    public static  int myHash( int h, int length ){
        System.out.println(h&(length - 1));//ȡ���λ����Ч��һ��
        System.out.println(h%length);
        return h&( length - 1);
    }


}
