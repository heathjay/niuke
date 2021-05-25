
class Solution {
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int i  = 0;
        while(i < n){
            int sumOfGas = 0 , sumOfCost = 0;
            int cnt = 0;
            while(cnt < n){
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if(sumOfCost > sumOfGas){
                    break;
                }
                cnt++;
            }
            if(cnt == n){
                return i;
            }else{
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i = 0; i < len; i++){
            spare += gas[i] - cost[i];
            if(spare < minSpare){
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 :(minIndex + 1) % len;


    }
}