package leetCode.tag.Array;

public class Solution134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i=0; i<gas.length; i++){
            //以i为起点，依此判断每一个i
            int j = i;
            int count = 0;
            int tank = gas[i];//tank的初始值
            while ( count < gas.length  ){
                //针对每一个起点，判断是否能形成回路
                if (tank >= cost[j % gas.length]){
                    //只有从i到i+1这一段的tank大于消耗才能到下一个gas站点
                    tank = tank - cost[ j%gas.length ] + gas[(j+1)%gas.length]; //到达第j+1个站点
                    j++;
                    count++;
                }
                else break;//以i为起点不能完成回路，从下一个起点开始
            }
            if ( count == gas.length){ //这里判断while是以何种原因跳出循环的
                return i;
            }
        }
        return -1;
    }
    public static int canCompleteCircuit02(int[] gas, int[] cost) {
        for (int i=0; i<gas.length; i++){
            //以i为起点，依此判断每一个i
            int j = i;
            int count = 0;
            int tank = gas[i];//tank的初始值
            while ( count < gas.length  ){
                //针对每一个起点，判断是否能形成回路
                if (tank >= cost[j % gas.length]){
                    //只有从i到i+1这一段的tank大于消耗才能到下一个gas站点
                    tank = tank - cost[ j%gas.length ] + gas[(j+1)%gas.length]; //到达第j+1个站点
                    j++;
                    count++;
                }
                else break;//以i为起点不能完成回路，从下一个起点开始
            }
            if ( count == gas.length){ //这里判断while是以何种原因跳出循环的
                return i;
            }
        }
        return -1;
    }


}
