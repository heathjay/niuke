import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class input{
    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        int T = Integer.parseInt(sn.nextLine());
        
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(sn.nextLine());
            int res=0;
            Set<Integer> set[] = new HashSet[n+1];
            set[0] = new HashSet<Integer>();
            int index = 0;
            for(int j =0 ; j < n;j++){
                String[] t = sn.nextLine().trim().split(" ");
                int num1= Integer.parseInt(t[0]);
                int num2 = Integer.parseInt(t[1]);
                
                if(set[0].contains(num1) && set[0].contains(num2)) continue;
                if(set[0].contains(num1) || set[0].contains(num2)){
                    for(int k = 1; k <=index;k++){
                        
                        if(set[k].contains(num1)){
                            set[k].add(num2);
                            set[0].add(num2);
                        }else if(set[k].contains(num2)){
                            set[k].add(num1);
                            set[0].add(num1);
                        }
                    }
                }
                if(!set[0].contains(num1) && !set[0].contains(num2)){
                    index++;
                    set[index]=new HashSet<Integer>();
                    set[index].add(num1);
                    set[index].add(num2);
                    set[0].add(num1);
                    set[0].add(num2);
                }
            }
            System.out.println(index);
            for(int k =1; k <= index;k++){
                res = Math.max(set[k].size(),res);
            }
            System.out.println(res);
        }
    }
}