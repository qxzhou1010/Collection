package leetCode.tag.Array;

public class Solution122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int max = maxProfit(prices);
        System.out.println(max);
    }

    public static int maxProfit(int[] prices){
        int len = prices.length;
        if(len < 1) return 0;

        int peak = prices[0];
        int valley = prices[0];
        int max = 0;
        int i = 0;

        while( i < len - 1){
            while( i < len - 1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];
            while( i<len-1 && prices[i] <= prices[i+1])
                i++;
            peak = prices[i];

            max += peak - valley;

        }
        return max;
    }

}
