package leetCode.tag.Array;

public class RemoveDuplicatesSorted2 {
    public static void main(String[] args) {
            RemoveDuplicatesSorted2 test = new RemoveDuplicatesSorted2();
            int[] nums = {1,1,1,2,2,3};
            int res = 0;
            res = test.solution(nums);
            System.out.println(res);
    }
    public int solution( int[] nums){
        int i = 0;
        for (int n: nums){
            if (i<2 || n > nums[i - 2]){
                nums[i++] = n;
            }
        }
        return i;
    }




}
