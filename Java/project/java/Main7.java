import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
class Node{
    int val;
    char c;
    public Node(){
        
    }
    public Node(int val, char c){
        this.val = val;
        this.c = c;
    }
}
public class Main7{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        String s = sn.nextLine().trim();
        int len = s.length();
        if(len == 0){
            System.out.println("");
            return;
        }
        int[] cnt = new int[52];
        char[] cs = s.toCharArray();
        for(int i = 0; i < len; i++){
            char c = cs[i];
            if(c >= 'a' && c <= 'z'){
                cnt[c-'a'] ++;
            }else if(c >= 'A' && c <= 'Z'){
                cnt[c - 'A' + 26] ++;
            }
        }
        //加入list
        ArrayList<Node> res = new ArrayList<>();
        for(int i = 0; i < 52; i++){
            if(cnt[i] != 0){
                Node node;
                if(i < 26){
                    node = new Node(cnt[i], (char)(i + 'a'));
                }else{
                    node = new Node(cnt[i], (char)(i -26 + 'A'));
                }
                res.add(node);
            }
        }
        
        //排序
        Collections.sort(res, new Comparator<Node>(){
               public int compare(Node o1, Node o2){
            		if(o1.val > o2.val){
                        return -1;
                    }else if(o1.val == o2.val){
                        if((o1.c >= 'A' && o1.c <= 'Z') && (o2.c >= 'a' && o2.c <= 'z')){
                            return -1;
                        }else if((o2.c >= 'A' && o2.c <= 'Z') && (o1.c >= 'a' && o1.c <= 'z')){
                            return 1;
                        }else {
                            if((int)(o2.c - o1.c) > 0){
                                return -1;
                            }else{
                                return 0;
                            }
                        }
                    }else{
                        return 1;
                    }
            		
        		}
			});
			int size = res.size();
			StringBuilder sb = new StringBuilder();
            for(int i = 0; i < size; i++){
                Node node =res.get(i);
                int cntc = node.val;
                char ch = node.c;
                for(int j = 0; j < cntc ; j++){
                    sb.append(ch);
                }
            }
			System.out.println(sb.toString());
        
    }
}