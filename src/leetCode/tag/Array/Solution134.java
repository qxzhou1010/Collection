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
            //��iΪ��㣬�����ж�ÿһ��i
            int j = i;
            int count = 0;
            int tank = gas[i];//tank�ĳ�ʼֵ
            while ( count < gas.length  ){
                //���ÿһ����㣬�ж��Ƿ����γɻ�·
                if (tank >= cost[j % gas.length]){
                    //ֻ�д�i��i+1��һ�ε�tank�������Ĳ��ܵ���һ��gasվ��
                    tank = tank - cost[ j%gas.length ] + gas[(j+1)%gas.length]; //�����j+1��վ��
                    j++;
                    count++;
                }
                else break;//��iΪ��㲻����ɻ�·������һ����㿪ʼ
            }
            if ( count == gas.length){ //�����ж�while���Ժ���ԭ������ѭ����
                return i;
            }
        }
        return -1;
    }
    public static int canCompleteCircuit02(int[] gas, int[] cost) {
        for (int i=0; i<gas.length; i++){
            //��iΪ��㣬�����ж�ÿһ��i
            int j = i;
            int count = 0;
            int tank = gas[i];//tank�ĳ�ʼֵ
            while ( count < gas.length  ){
                //���ÿһ����㣬�ж��Ƿ����γɻ�·
                if (tank >= cost[j % gas.length]){
                    //ֻ�д�i��i+1��һ�ε�tank�������Ĳ��ܵ���һ��gasվ��
                    tank = tank - cost[ j%gas.length ] + gas[(j+1)%gas.length]; //�����j+1��վ��
                    j++;
                    count++;
                }
                else break;//��iΪ��㲻����ɻ�·������һ����㿪ʼ
            }
            if ( count == gas.length){ //�����ж�while���Ժ���ԭ������ѭ����
                return i;
            }
        }
        return -1;
    }


}
