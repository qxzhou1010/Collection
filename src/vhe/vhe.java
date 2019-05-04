package vhe;

/**
 * 改进版VHE的java实现
 * 2019/02/10
 */

import java.math.BigInteger;





public class vhe {

    public static void main(String[] args) {
        BigInteger w = new BigInteger("100000000000000");
        System.out.println(w);
        BigInteger x = new BigInteger("10");
        System.out.println( w.multiply(x));


    }
}
