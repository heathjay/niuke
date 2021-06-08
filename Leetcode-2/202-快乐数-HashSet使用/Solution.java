class Solution {
    private int getNext(int n) {
        int res = 0;
        while(n!=0){
            res += (n % 10) * (n % 10);
            n = n/ 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}