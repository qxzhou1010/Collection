package leetCode.tag.Array;
/*
46 Permute
2018/12/5
 */

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        Permute test = new Permute();
        int[] nums = {1,2,3};
        List<List<Integer>> res;
        res = test.permute(nums);
        System.out.println(res);

    }
    public List<List<Integer>> permute( int[] nums ){
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(),nums);
        return list;

    }
    public void backtrack( List<List<Integer>> list,  List<Integer> tempList, int[] nums){
        if ( tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        }else{
            for (int i = 0; i < nums.length ; i++) {
                if ( tempList.contains( nums[i])) continue;
                tempList.add( nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }

    }


}
