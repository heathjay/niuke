/*
import java.util.LinkedList;
public class Solution {
    //Insert one char from stringstream
   int[] charCnt = new int[128];
   LinkedList<Character> que = new LinkedList<>();
    public void Insert(char ch)
    {
        if(charCnt[ch]++ == 0){
            que.add(ch);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        Character CHAR = null;
        char c = 0;
        while((CHAR = que.peek()) != null){
            c = CHAR.charValue();
            if(charCnt[c] == 1) return c;
            else que.remove();
        }
        return '#';
    }
}


*/
import java.util.HashMap;
import java.util.LinkedList;
public class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    LinkedList<Character> list = new LinkedList<>();
    public void Insert(char ch){
        if(!map.containsKey(ch)){
            list.add(ch);
            map.put(ch,1);
        }else{
            map.put(ch,map.get(ch)+1);
        }
    }
    public char FirstAppearingOnce(){
       while(!list.isEmpty()){
           char c = list.peek();
           if(map.get(c) == 1){
               return c;
           }else{
               list.remove();
           }
       }
            return '#';
        }    
    
}