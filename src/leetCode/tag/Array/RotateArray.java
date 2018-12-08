package leetCode.tag.Array;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        test.solution(nums, k);
        for (int i = 0; i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }
    public void solution(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }
   /* public void solution( int[] nums, int k){
        int[] temp;
        temp = new int[k];
        for (int i = k; i>0; i--){
            temp[k-i] = nums[nums.length - i];
        }
        for (int i = nums.length - k - 1; i>=0;i--){
            nums[i+k] = nums[i];
        }
        for (int i = 0; i<k;i++){
            nums[i] = temp[i];
        }
    }*/
    public void reverse( int[] nums, int start, int end){
        int temp;
        while (start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
