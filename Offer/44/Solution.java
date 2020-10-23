/*
public class Solution {
    public String ReverseSentence(String str) {
        String[] ss = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length - 1; i >= 0; i--){
            sb.append(ss[i] + " ");
        }
        return sb.toString().strip();
    }
}

*/
public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return str;
        }
        char[] arr = str.toCharArray();
        reverse(arr, 0, str.length - 1);
        int start = 0;
        int end = 0;
        while(start < arr.length){
            if(arr[start] == ' '){
                start ++;
                end++;
            }else if(end == arr.length || arr[end] == ' '){
                reverse(arr,start,end - 1);
                end++;
                start = end;
            }else{
                end++;
            }
        }
        return String.valueOf(arr);
    }
    private void reverse(char[] arr, int begin, int end){
        while(begin<end){
           char temp = arr[begin];
           arr[begin] = arr[end];
           arr[end] = temp;
           begin++;
           end--;
        }
    }
}