public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0) return 1.0;
        if( exponent < 0 ){
            base = 1 / base;
            exponent = -exponent;
        }
        double res = Power(base, exponent / 2);
        if(exponent & 1){
            return res * res * b;
        }else{
            return res * res;
        }

    }
}