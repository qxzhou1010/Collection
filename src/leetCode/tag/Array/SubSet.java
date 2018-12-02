package leetCode.tag.Array;
/*

78 Subsets
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        SubSet subSet = new SubSet();
        List<List<Integer>> test = new ArrayList<>();
        int[] nums = {1,2,3};
        test = subSet.subsets(nums);
        System.out.println(test);
    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums,0);
        // list = deleteDuplicates(list);
        return list;
    }


    private void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums,  int start){
            list.add( new ArrayList<>(tempList));
             //System.out.println(list);
            //Éî¶ÈËÑË÷
            for ( int i = start; i<nums.length; i++){
                tempList.add(nums[i]);
                backTrack(list, tempList, nums, i+1 );
               tempList.remove(tempList.size() - 1);
            }
        }
    }


