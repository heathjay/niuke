import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
public class Main10{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        String[] ps = sn.nextLine().trim().split(" ");
        int n = Integer.parseInt(ps[0]);
        int p = Integer.parseInt(ps[1]);
        int q = Integer.parseInt(ps[2]);
        
        HashSet<Integer> a = new HashSet<>();
        ps = sn.nextLine().trim().split(" ");
        for(int i = 0; i < p; i++){
            a.add(Integer.parseInt(ps[i]));
        }
        
        ps = sn.nextLine().trim().split(" ");
        HashSet<Integer> b = new HashSet<>();
       int comm = 0;
        for(int i = 0 ; i < q; i++){
            int num = Integer.parseInt(ps[i]);
            if(a.contains(num)){
                a.remove(num);
                comm++;
            }else{
                b.add(num);
            }
        }
        
        System.out.print(a.size());
        System.out.print(" ");  
        System.out.print(comm);
        System.out.print(" ");  
        System.out.print(b.size());
        
    }
}