package leetCode.tag.Array;

public class Solution26 {
    public static void main(String[] args) {

        int[] nums = {1,1,2};
        int length = removeDuplicates(nums);
        System.out.println(length);

    }

    public static int removeDuplicates(int[] nums){
        int index = 1;
        int value = nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i] != value){
                nums[index++] = nums[i];
                value = nums[i];

            }

        }


        return index;
    }


}
