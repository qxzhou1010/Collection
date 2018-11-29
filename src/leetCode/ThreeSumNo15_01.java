package leetCode;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;;
public class ThreeSumNo15_01 {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums); //排序
		
		for( int i=0; i<nums.length - 2; i++) { //遍历整个数组  -2的原因是因为后面要加两个数
			
			if(i>0 && nums[i] == nums[i-1]) {  //跳过相同项 这里的逻辑是和 上一个自己比较
				continue;
			}
			int j = i +1; // 从i后一个开始
			int k = nums.length - 1; //从数组最后一个元素
			int target = -nums[i]; // j + k 要等于 -i
			while( j < k) {
				if(nums[j] + nums[k] == target) {
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j-1]) j++;//跳过相同项 这里的逻辑是和 上一个自己比较
					while (j < k && nums[k] == nums[k+1]) k--;//跳过相同项 这里的逻辑是和 上一个自己比较
				}else if( nums[j] + nums[k] > target) { // 大了 要减小 (这里是升序数组)
					k--;
				}else {// 小了要增大
					j++; 
				}
			}
		}
		System.out.print(res.toString());
		
	}

}
