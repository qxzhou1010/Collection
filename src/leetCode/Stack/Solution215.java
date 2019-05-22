package leetCode.Stack;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution215 {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k) {
        //新建一个最小堆(优先队列)
        Queue<Integer> queue = new PriorityQueue<>();

        //维护一个大小为k的最小堆
        //先将数组的前k个元素入堆
        for (int i =0; i<k;i++){
            queue.add(nums[i]);
        }

        //剩下的元素和当前的堆顶元素做比较
        for (int i=k; i<nums.length; i++){
            if (nums[i] > queue.element()){
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return queue.element();

    }
    public static int findKthLargest02(int[] nums, int k){
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i<nums.length; i++){
            if (queue.size()<k){
                queue.add(nums[i]);
            }else {
                if (nums[i] > queue.element()){
                    queue.remove();
                    queue.add(nums[i]);
                }

            }

        }
        return queue.element();

    }




}
