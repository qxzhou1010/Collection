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
    //��������
    Queue<Integer> largest = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
        public int compare(Integer t1, Integer t2){
            return t2 - t1;
        }
    });
    //������С��
    Queue<Integer> smallest = new PriorityQueue<>();



    public void addNum(int num){
        if (largest.isEmpty()){
            largest.add(num);
            return;
        }

        //������Ѻ���С��Ԫ�ظ�����ͬ
        if (largest.size() == smallest.size()){
            //�����Ԫ��С�����ѵĶѶ���ֱ�Ӽ�������
            if (num < largest.element()){
                largest.add(num);
            }else {
                //�����Ԫ�ش��ڵ������ѵĶѶ���������С��
                smallest.add(num);
            }
        }else if (largest.size() > smallest.size()){
            //������ѵ�Ԫ�ظ���������С��
            if (num > largest.element()){
                //�����Ԫ��С�����ѵĶѶ�
                //�������ѵĶѶ�������С�ѣ�Ȼ���Ƴ���Ȼ�����Ѽ�����Ԫ��
//                smallest.add(largest.element());
//                largest.remove();
//                largest.add(num);
                smallest.add(num);
            }else {
                //�����Ԫ�ش������ѵĶѶ���ֱ��push������С��
//                smallest.add(num);
                smallest.add(largest.element());
                largest.remove();
                largest.add(num);
            }

        }else {
            //������ѵ�Ԫ�ظ���С����С��

            //ע������������жϣ��������治̫һ������������Ǳ�֤���ѵ����Ԫ�� ��ҪС�� ��С�ѵ���СԪ�أ�����
            //ֻ�м�����������жϣ������test02�������Ż����ͨ��
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
