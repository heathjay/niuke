import java.util.*;
import java.math.BigInteger;

public class Solution {
    /**
     * the number of 0
     * @param n long长整型 the number
     * @return long长整型
     */
    public long thenumberof0 (long n) {
        // write code here
        /*
        //超时
        BigInteger nFactorial = BigInteger.ONE;
        for(int i = 2; i <= n; i++){
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        int zeroCount = 0;
        while(nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }
        return zeroCount;
    }
    */
        int zeroCount = 0;
        for(int i = 5; i <= n; i+=5){
            int currentFactor = i;
            while(currentFactor % 5 == 0){
                zeroCount ++;
                currentFactor /=5;
            }
        
        }
        return zeroCount;
    }

}