import java.util.Scanner;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
public class Main4{
   
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
         int a = sn.nextInt();
         int b = sn.nextInt();
         int c = sn.nextInt();
         int d = sn.nextInt();
        //搭配
         int e = sn.nextInt();
         int f = sn.nextInt();
         int g = sn.nextInt();
        
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(1, e));
        list.add(new Node(2, f));
        list.add((new Node(3, g)));
        
        Collections.sort(list, new Comparator<Node>(){
            public int compare(Node o1, Node o2){
                return o2.val - o1.val;
            }
        });
        for(int i = 0; i < 3; i++){
            System.out.println(list.get(i).val);
        }
        int sum = 0;
        while(!list.isEmpty()){
            Node node = list.get(0);
            if(node.op == 1){
                if(a == 0 || d == 0){
                    list.remove(node);
                }else{
                    while(a != 0 && d != 0){
                        a--;
                        d--;
                        sum += node.val;
                    }
                    System.out.println(sum);
                    list.remove(node);
                }
            }else if(node.op == 2){
                while(b != 0 && c != 0){
                    sum += node.val;
                    b--;
                    c--;
                }
                list.remove(node);
                System.out.println(sum);
            }else{
                while(c != 0 && d != 0){
                    sum += node.val;
                    c--;
                    d--;
                }
                list.remove(node);
                System.out.println(sum);
            }
        }
        
        System.out.println(sum);
    }
}
class Node{
    int val;
    int op;
    public Node(int op,int val){
        this.op = op;
        this.val = val;
    }
}