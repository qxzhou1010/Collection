package leetCode.Stack;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution215 {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k) {
        //�½�һ����С��(���ȶ���)
        Queue<Integer> queue = new PriorityQueue<>();

        //ά��һ����СΪk����С��
        //�Ƚ������ǰk��Ԫ�����
        for (int i =0; i<k;i++){
            queue.add(nums[i]);
        }

        //ʣ�µ�Ԫ�غ͵�ǰ�ĶѶ�Ԫ�����Ƚ�
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
