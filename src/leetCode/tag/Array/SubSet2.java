package leetCode.tag.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {

    public static void main(String[] args) {
        SubSet2 test = new SubSet2();
        int[] nums = {1,2,2};
        List<List<Integer>> list;
        list = test.subsets(nums);
        System.out.println(list);
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums,0);
        // list = deleteDuplicates(list);
        return list;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums,  int start){
        //if ( !list.contains(tempList) )//去重
       // {
            list.add( new ArrayList<>(tempList));
       // }
        //System.out.println(list);
        //深度搜索
        for ( int i = start; i<nums.length; i++){
            /*
            只有i++了，才会出现 i>start,何时会i++呢?
            只有tempList.remove()后才会；
            显然这里比较的就是 新的元素 和刚刚移除的元素 是否相等，如果相等且运行了tempList.add,则会出现相同的tempList
            则List中会出现相同的元素
             */
            if (i>start && nums[i] == nums[i-1]) continue;//

            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i+1 );
            tempList.remove(tempList.size() - 1);
        }
    }
}
