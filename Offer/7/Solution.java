public class Solution {
    public int Fibonacci1(int n) {
        if ( n <= 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public int Fibonacci2(int n) {
        int ans[] = new int[40];
        ans[0] = 1;
        ans[1] = 1;
        for(int i = 2; i <=n; i++){
            ans[i] = ans[i-1] + ams[i-2];
        }
        return ans[n];
    }

    public int Fibonacci3(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int sum = 0;
        int two = 0;
        int one = 1;
        for(int i = 2; i <= n ; i++){
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int sum = 1;
        int one = 0;
        for(int i = 2; i <= n; i++){
            sum = one + sum;
            one = sum - one;
        }
        return sum;
    }
}