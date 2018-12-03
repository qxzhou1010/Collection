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
        //if ( !list.contains(tempList) )//ȥ��
       // {
            list.add( new ArrayList<>(tempList));
       // }
        //System.out.println(list);
        //�������
        for ( int i = start; i<nums.length; i++){
            /*
            ֻ��i++�ˣ��Ż���� i>start,��ʱ��i++��?
            ֻ��tempList.remove()��Ż᣻
            ��Ȼ����Ƚϵľ��� �µ�Ԫ�� �͸ո��Ƴ���Ԫ�� �Ƿ���ȣ���������������tempList.add,��������ͬ��tempList
            ��List�л������ͬ��Ԫ��
             */
            if (i>start && nums[i] == nums[i-1]) continue;//

            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i+1 );
            tempList.remove(tempList.size() - 1);
        }
    }
}
