package z.qx.oo1128;

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLast34 {

    public static void main(String[] args) {
        FindFirstAndLast34 test = new FindFirstAndLast34();
        List arrayList = new ArrayList<>();
        int[] nums = {1,1,2};
        int target = 1;
        int[] res = {-1,-1};
        res = test.searchRange(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int low = 0;
        int high = nums.length - 1;
        int middle = (low + high)/2;
        if(nums.length==0){
            return res;
        }
        if(nums.length == 1){
            if(nums[0] == target){
                res[0] = 0;
                res[1] = 0;
                return res;
            }
            return res;
        }

        if(nums[0] == target && nums[ nums.length - 1] == target){
            res[0] = 0;
            res[1] = nums.length - 1;
            return res;
        }


        // if(nums.length == 2){
        //     if( nums[0] == target && nums[1] == target){
        //         res[0] = 0;
        //         res[1] = 1;
        //          return res;
        //      }
        //  }
        // if( nums.length > 2)



        while( low<high) {
            if(nums[middle] == target) {
                break;
            }

            if( target > nums[middle]) {
                low = middle + 1;
                middle = (low + high)/2;
            }else {
                high = middle;
                middle = (low + high)/2;
            }
        }

        if(nums[middle] == target) {
            if( middle < nums.length - 1 && middle >0){//防止上溢和下溢
                int up = middle;
                while( up <= nums.length - 1)
                {   if (nums[up] == target) {
                    res[1] = up;
                }
                    up++;


              /*  if(nums[middle + 1] == target) {//当有一段连续的值，就不能仅仅只验证两个了
                    res[0] = middle ;
                    res[1] = middle+1;
                    return res;
                }*/
                }
                int down = middle;
                while( down >= 0){
                    if (nums[down] == target) {
                        res[0] = down;
                    }
                    down--;

                }

                 /*if(nums[middle - 1] == target){
                    res[0] = middle -1;
                    res[1] = middle;
                    return res;*/
                return res;
            }
            //若middle在两个端点，则直接返回
            res[0] = middle;
            res[1] = middle;
            return res;

        }
        return res;
    }


}
