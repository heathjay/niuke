import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int m = sn.nextInt();
        if(n <=2 || m <= 1) {
            System.out.println(0);
            return;
        }
        List<Integer>[] arrs = new List[m+1];
        for(int i = 0; i <= m; i++){
            arrs[i] = new ArrayList<Integer>();
        }
        while(sn.hasNextLine()){
            String[] t = sn.nextLine().trim().split(" ");
            if(t.length == 3){
                int index = Integer.parseInt(t[0])-1;
                int next = Integer.parseInt(t[2])-1;
                arrs[index].add(next);
            }      
        }
        int count =0;
        for(int i =0 ; i <= m; i++){
            if(arrs[i].size() == 2){
                    if(arrs[arrs[i].get(0)].size()==0 && arrs[arrs[i].get(1)].size()==0){
                        count++;
                    }
            }
        }
        System.out.println(count);
        
        
    }
}