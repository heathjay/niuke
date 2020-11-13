import java.util.ArrayList;
import java.util.Arrays;

public class Solution{
    public ArrayList<String> Permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0)return res;
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        res.add(s);
        
        while(true){
            s = nextString(s);
            if(s == "finish"){
                break;
            }else{
                res.add(s);
            }
        }
    }

    public String nextString(String str){
        char[] array = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        for(;i >= 0 && array[i] >= array[i+1];i--);
        if(i == -1) return "finish";
        int j = length - 1;
        for(;j >=0 && array[j] <= array[i]; j--);
        char temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        for(int a = i + 1, b=length-1;a < b; a++,b--){
            temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
        return new String(array);
    }
}