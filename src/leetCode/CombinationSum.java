package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		int[] nums = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = new ArrayList<>();
		res = test.combinationSum( nums, target);
		System.out.println(res);
 	}
 	public List<List<Integer>> combinationSum(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backTrack( List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
		if(remain < 0) return;
		else if ( remain == 0) list.add( new ArrayList<>(tempList));
		else{
			for ( int i = start; i<nums.length; i++){
				tempList.add(nums[i]);
				backTrack(list, tempList, nums, remain - nums[i],i );
				tempList.remove(tempList.size() - 1);
			}
		}

	}

}
