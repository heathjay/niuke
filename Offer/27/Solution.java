import java.util.ArrayList;
public class Solution {
    /**
     * 字典序列全排
     */
    public ArrayList<String> Permutation1(String str) {
       ArrayList<String> res = new ArrayList<>();
       if(str.length() == 0) return res;
       char[] array = str.toCharArray();
       //必须得单调递增
       Arrays.sort(array);
       String s  = new String(array);
       res.add(s);
        while(true){
            s = nextString(s);
            if(!s.equals("finish")){
                res.add(s);
            }else{
                break;
            }
        }
        return res;
    }
    public String nextString(String str){
        char[] array = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        //定位
        for(; i >=0 && array[i] >= array[i+1];i--);
        if(i == -1) return "finish";
        int j = length - 1;
        for(; j >=0 && array[j] <= array[i]; j--);
        char temp = array[j];
        array[j] = array[i];
        array[i] = temp;

        for(int a = i+1, b = length - 1 ; a < b; a++,b--){
            temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
        return new String(array);
    }


    /**
     * 逆序递增进位法
     */
    HashMap<Character,Integer> system = new HashMap<>();
    HashMap<Integer, Character> chaAt = new HashMap<>();
    int[] q;
    int length;
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> r = new ArrayList<>();
        HashSet<String> res = new HashSet<>();
        if(str.length() == 0) return r;
        if(str.length() == 1){
            r.add(str);
            return r;
        }

        init(str);
        res.add(output());
        boolean tag = false;

        while(true){
            tag = increase();
            System.out.println(tag);
            for(int i = 1; i < length; i++){
                System.out.print(q[i]);
            }
            System.out.println();
            if(tag){
                String s = output();
                System.out.println(s);
                res.add(s);
            }else break;
        }
        r = new ArrayList<String>(res);
        Collections.sort(r);
        return r;
    }

    public void init(String str){
        length = str.length();
        char[] array = str.toCharArray();
        Arrays.sort(array);
        for(int i = 0; i < length; i++){
            charAt.put(i, array[i]);
        }

        for(int i = 0; i < length - 1;i++){
            if(array[i] < array[i+1]){
                system.put(array[i], length - 1);
            }
        }
        system.put(array[length-1],0);
        q = new int[length];
    }
    public boolean increase(){
        int i=length-1;
        q[i]++;
        while(i>0 && q[i] > system.get(chaAt.get(i))){
            i--;
            q[i]++;
            q[i+1]=0;
        }
        if(q[i] > system.get(chaAt.get(i))){
            return false;//overflow
        }
        return true;
    }
 
    public String output(){
        char [] array = new char[length];
        int [] mask = new int[length];
        for(int i=0; i<length; i++){
            char tmp = chaAt.get(i);
            int count = -1;
            int j = 0;
            for(j=0; j<length; j++){
                if(mask[j] == 0) count++;
                if(count == q[i]){
                    mask[j]=1;
                    array[j]=tmp;
                    break;
                }
            }
        }
        return new String(array);
    }

    /**
     * 邻位互换
     */        
    int[] dir;
    int l;
    char[] array;
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0) return res;
        init1(str);
        res.add(new String(array));
        while(move()){
            res.add(new String(array));
        }
        Collections.sort(res);
        return res;
    }
    public void init1(String str){
        l = str.length();
        dir = new int[l];
        array = str.toCharArray();
        Arrays.sort(array);
    }
    public boolean move(){
        int tag = -1;
        for(int i = 0; i < l; i++){
            int next = i;
            if(dir[i] == 0) next--;
            else next++;
            if(next == l || next == -1) continue;
            else if(array[i] > array[next]){
                if(tag == -1 || array[i] > array[tag]){tag =i;}
            }        
        }
        if(tag != -1){
            int next = tag;
            if(dir[tag] == 0) next--;
            else next ++;
            char tmp = array[tag];
            array[tag] = array[next];
            array[next] = tmp;
            int tmpp = dir[next];
            dir[next] = dir[tag];
            dir[tag] = tmpp;
            for(int i = 0; i < length; i++){
                if(array[i] > array[next]) dir[i] = (dir[i] + 1) % 2;
            }
            return true;
        }
        return false;
    }
}