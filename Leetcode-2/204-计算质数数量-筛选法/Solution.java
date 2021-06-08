class Solution {
    public int countPrimes1(int n) {
        int res = 0;
        for(int i = 2; i < n ;i++){
            res += isPrime(i) ? 1 : 0;
        }
        return res;
    }
    public boolean isPrime(int x){
        for(int i = 2; i * i <= x ; i++){
            if(x % i == 0) return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        int[] isPrimea = new int[n];
        Arrays.fill(isPrimea, 1);
        int res = 0;
        for(int i = 2; i < n; i++){
            if(isPrimea[i] == 1){
                res += 1;
                if((long) i * i < n){
                    for(int j = i * i ; j < n; j+=i){
                        isPrimea[j] = 0;
                    }
                }
            }
        }
        return res;
    }
}