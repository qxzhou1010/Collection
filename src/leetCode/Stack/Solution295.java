package leetCode.Stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution295 {


    public static void main(String[] args) {

//        int[] test = {6,10,1,7,99,4,33};
        int[] test02 = {12,10,13,11,5,15,1,11,6,17,14,8,17,6,4,16,8,10,2,12,0};

        MedianFinder medianFinder = new MedianFinder();
        int num=0;
        for (int i:test02){
            num++;
            medianFinder.addNum(i);
            System.out.println(num+"elements:"+medianFinder.findMedian());

        }


    }
}

class MedianFinder{
    public MedianFinder(){

    }
    //定义最大堆
    Queue<Integer> largest = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
        public int compare(Integer t1, Integer t2){
            return t2 - t1;
        }
    });
    //定义最小堆
    Queue<Integer> smallest = new PriorityQueue<>();



    public void addNum(int num){
        if (largest.isEmpty()){
            largest.add(num);
            return;
        }

        //如果最大堆和最小堆元素个数相同
        if (largest.size() == smallest.size()){
            //如果新元素小于最大堆的堆顶，直接加入最大堆
            if (num < largest.element()){
                largest.add(num);
            }else {
                //如果新元素大于等于最大堆的堆顶，加入最小堆
                smallest.add(num);
            }
        }else if (largest.size() > smallest.size()){
            //如果最大堆的元素个数大于最小堆
            if (num > largest.element()){
                //如果新元素小于最大堆的堆顶
                //首先最大堆的堆顶加入最小堆，然后移除，然后最大堆加入新元素
//                smallest.add(largest.element());
//                largest.remove();
//                largest.add(num);
                smallest.add(num);
            }else {
                //如果新元素大于最大堆的堆顶，直接push进入最小堆
//                smallest.add(num);
                smallest.add(largest.element());
                largest.remove();
                largest.add(num);
            }

        }else {
            //如果最大堆的元素个数小于最小堆

            //注意这里的条件判断！！和上面不太一样！这个条件是保证最大堆的最大元素 都要小于 最小堆的最小元素！！！
            //只有加上这个条件判断，上面的test02这个数组才会测试通过
            if (num < largest.element() || num<smallest.element()){
                largest.add(num);
            }else {
                largest.add(smallest.element());
                smallest.remove();
                smallest.add(num);
            }

        }

    }
    public double findMedian(){
        if (largest.size() == smallest.size()){
            int res = largest.element() + smallest.element();
            return (double) res/2;

        }else if (largest.size() > smallest.size()){
            return largest.element();
        }else {
            return smallest.element();
        }

    }




}
