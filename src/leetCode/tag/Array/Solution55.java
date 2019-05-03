package leetCode.tag.Array;

public class Solution55 {
    public static void main(String[] args) {
        int[] nums ={1,1,2,2,0,1,1};
        System.out.println(canJump(nums));



    }
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1) return true;

        for(int i=0; i<len-1; i++){
            int max = nums[i]; //把当前值作为最大的step
            if(max >= (len - 1 - i)) return true;
            else if (max > 0)
            {
                for(int j=i+1; j<= max; j++){
                    if( nums[j] >= (len - 1 -j)) return true;

                }
            }
            else return false;

        }
        return false;
    }


}
