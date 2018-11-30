package leetCode.tag.Array;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 test = new CombinationSum2();
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = new ArrayList<>();
        res = test.combinationSum(nums, target);
        System.out.println(res);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums, target, 0);
       // list = deleteDuplicates(list);
        return list;
    }

    private void backTrack( List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return;//边界条件
        else if ( remain == 0) list.add( new ArrayList<>(tempList));//正确解
        else{
            //深度搜索
            for ( int i = start; i<nums.length; i++){
                if ( i>start && nums[i] == nums[i-1]) continue;

                tempList.add(nums[i]);
                backTrack(list, tempList, nums, remain - nums[i],i + 1 );//不包含自身
                tempList.remove(tempList.size() - 1);

        }

    }
    }

    private List<List<Integer>> deleteDuplicates( List<List<Integer>> list){
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            if ( !res.contains(list.get(i))){
                res.add( list.get(i));
            }
        }
        return res;
    }




}
