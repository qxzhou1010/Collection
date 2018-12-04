package leetCode.tag.Array;
import java.util.ArrayList;
import java.util.List;


public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 test = new CombinationSum3();
        int k = 3;
        int n = 9;
        List<List<Integer>> res;
        res = test.combinationSum3(k, n);
        System.out.println(res);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();//返回值
        int[] nums = {1,2,3,4,5,6,7,8,9};
        backTrack(list, new ArrayList<>(), nums, n, k,0 );
       return list;
    }

    private void backTrack( List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int k,int start){
        if(remain < 0 ) return;//边界条件
        else if ( remain == 0 && tempList.size() == k) list.add( new ArrayList<>(tempList));//正确解
        else{
            //深度搜索
            for ( int i = start; i<nums.length; i++){
                if ( i>start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                backTrack(list, tempList, nums, remain - nums[i],k,i+1 );//不包含自身
                tempList.remove(tempList.size() - 1);

            }

        }
    }



}
