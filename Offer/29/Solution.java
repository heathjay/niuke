public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length == 0 || k == 0) return res;
        Arrays.sort(input);
        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution_1(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if(k > len || k <= 0) return res;

        //前面k个进行排序
        for(int i = 1; i < k ; i++){
            int j = i -1;
            int tmp = input[i];
            while(j >= 0 && input[j] > tmp){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = tmp;
        }

        for(int i = k; i < input.length; i++){
            if(input[i] < input[k-1]){
                int newk = input[i];
                int j = k - 1;
                while(j >= 0 && input[j] > newk){
                    input[j+1] = input[j];
                    j--;
                }

                input[j+1] = newk;
            }
        }

        for(int i = 0; i < k ; i++){
            res.add(input[i]);
        }

        return res;
    }

}