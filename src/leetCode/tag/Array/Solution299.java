package leetCode.tag.Array;

public class Solution299 {
    public static void main(String[] args) {
//        String res;
//        String secret = "1807";
//        String guess = "7810";
//        res = getHint(secret, guess);
//        System.out.println(res);
        String a = "123";
        int b = Character.getNumericValue(a.charAt(1));

        int[] numbers = new int[10];
        for( int i=0; i<10;i++) {


            System.out.println(numbers[i]);
        }
    }


    public static String getHint(String secret, String guess) {
        int len = secret.length();
        int numA = 0;
        int numB = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(secret.charAt(i) == guess.charAt(j) && i==j){
                    numA++;
                    break;//跳出当前内层for循环
                }
                if(secret.charAt(i) == guess.charAt(j) ){
                    numB++;
                    break;
                }



            }
        }
        String res;
        res = String.format("%dA"+"%dB",numA,numB);

        return res;


    }


}
