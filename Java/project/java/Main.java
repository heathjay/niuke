import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int N = Integer.parseInt(sn.nextLine());
        int[] a = new int[N];
        for(int i = 0 ; i < N ;i++){
            a[i] = sn.nextInt();
        }
        
        boolean[] vis = new boolean[N];
        
        //按序号换位置
        int i = 0;
        int cnt = 0;
        while(i < N){
            if(a[i] >= 1 && a[i] <= N){
                while(a[i] >= 1 && a[i] <= N && a[i] != (i+1)){
                    vis[a[i]-1] = true;
                    cnt++;
                    int k = a[a[i] - 1];
                    k = a[i];
                    a[i] = k;
                }
                if(a[i] == (i+1)){
                    vis[i] = true;
                     cnt++;
                }
            }
            i++;
        }
        
        int[] tmp = new int[N-cnt];
        i = 0;
        int index = 0;
        while(i < N){
            if(!vis[i]){
                tmp[index] = a[i];
                index++;
            }
            i++;
        }
        
        Arrays.sort(tmp);
        index = 0;
        int sum=0;
        for(int j = 0 ; j < N; j++){
            if(!vis[j]){
                a[j] = tmp[index];
                sum+=Math.abs(j+1 - tmp[index]);
                index++;
                System.out.print(sum+" ");
            }
          
        }
        
        System.out.println(sum);
        
      
    }
}