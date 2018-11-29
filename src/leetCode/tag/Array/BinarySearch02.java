package leetCode.tag.Array;
/*
 * 一个简单的二分查找
 * 2018/11/27
 */

public class BinarySearch02{
	public static void main(String[] args) {
		int[] nums = {1,3};
		int target = 1;
		BinarySearch02 test = new BinarySearch02();
		System.out.println( test.BS(nums, target));
		System.out.println( test.BS(nums, 0, 1, target));
	}
	public int BS( int[] nums, int target) {//对全体数组进行二分查找
		int low = 0;
		int high = nums.length - 1;
		int middle = (low + high)/2; 
		
		while( low<=high) {
			middle = (low + high)/2;
			if( nums[middle] == target) {
				return middle;
			}
			
			
			if( target > nums[middle]) {
				low = middle + 1;
			}else {
				high = middle;
			}
		}
			return -1;	
	}
	public int BS( int[] nums, int low, int high, int target) {//在nums数组的特定范围内运用二分查找
		int middle = (low + high)/2;

		while( low<=high) {
			middle = (low + high)/2;
			if( nums[middle] == target) {
				return middle;
			}
			if( target > nums[middle]) {
				low = middle + 1;
			}else {
				high = middle;
			}
		}
			return -1;
}
}

