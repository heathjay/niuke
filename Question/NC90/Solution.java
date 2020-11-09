import java.util.*;


public class Solution {
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    Stack<Integer> allData;
    Stack<Integer> minData;
    ArrayList<Integer> res = new ArrayList<>();
    public int[] getMinStack (int[][] op) {
        // write code here
        allData = new Stack<>();
        minData = new Stack<>();

        ArrayList<Integer> res = new ArrayList<>();
        for(int[] option:op){
            switch (option[0]) {
                case 1:
                    push(option[1]);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    int min = getMin();
                    res.add(min);
                default:
                    break;
            }
        }

        int[] result = new int[res.size()];
        for(int i = 0 ; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;
    }

    private void push(int num){
        allData.push(num);
        if(!minData.isEmpty()){
            minData.push((minData.peek() < num) ? minData.peek():num);
        }else{
            minData.push(num);
        }
    }

    private void pop(){
        allData.pop();
        minData.pop();
    }

    private int getMin(){
        return minData.peek();
    }
}