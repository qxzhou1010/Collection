package leetCode.tag.Array;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
            Permutations2 test = new Permutations2();
            List<List<Integer>> res;
            int[] nums = {1,1,2};
            res = test.permute2(nums);
            System.out.println(res);
    }


    public List<List<Integer>> permute2( int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums,new boolean[nums.length]);
        return list;
     }
     public void backtrack( List<List<Integer>> list,  List<Integer> tempList, int[] nums,boolean[] used){
        if (tempList.size() == nums.length){
            list.add( new ArrayList<>( tempList));
        }else{
            for (int i= 0; i <nums.length ; i++) {
                if (used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1]) ) continue;
                used[i] = true;//记录nums数组上这个位置的元素是否在tempList中
                tempList.add( nums[i]);
                backtrack(list, tempList, nums,used);
                used[i] = false;//这里i位置的元素会被移除
                tempList.remove(tempList.size() - 1);
            }
        }
     }




}
