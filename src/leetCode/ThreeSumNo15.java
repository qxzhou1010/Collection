package leetCode;
import java.util.List;
import java.util.ArrayList;;


public class ThreeSumNo15 {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		//List<List<Integer>> outer = threeSum(nums);
		
		//System.out.print());
		
		
	}
	
	public List<List<Integer>> threeSum(int[] nums){
		List<Integer> inner = new ArrayList<>();
		List<List<Integer>> outer = new ArrayList< List<Integer>>();
		   int len = nums.length;
	        for(int i=0; i<len-2;i++){
	            for(int j=i+1; j<len-1;j++){
	                for(int k=j+1;k<len;k++){
	                    if(nums[i] + nums[j] + nums[k] == 0){
	                        inner.add(nums[i]);
	                        inner.add(nums[j]);
	                        inner.add(nums[k]);
	                        outer.add(inner);
	                    }
	                    
	                }
	            }
	        }
	        return outer;
	}
}
