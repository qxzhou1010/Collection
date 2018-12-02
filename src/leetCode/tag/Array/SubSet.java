package leetCode.tag.Array;
/*

78 Subsets
 */

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        //test.add(nums);
        System.out.println(test);
    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;
        backTrack(list, new ArrayList<>(), nums, target, 0);
        // list = deleteDuplicates(list);
        return list;
    }


    private void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return;//边界条件
        else if ( remain == 0) list.add( new ArrayList<>(tempList));//正确解
        else{
            //深度搜索
            for ( int i = start; i<nums.length; i++){
                tempList.add(nums[i]);

                backTrack(list, tempList, nums, remain - nums[i],i );
                tempList.remove(tempList.size() - 1);
            }
        }

    }




}
