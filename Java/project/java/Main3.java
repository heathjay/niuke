import java.util.Scanner;


public class Main3{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int N = Integer.parseInt(sn.nextLine());
        String inorder = sn.nextLine();
        char[] c = inorder.toCharArray();
        if(N == 0) System.out.println(0);
        else if(N == 1) System.out.println(0);
        System.out.println(dfs(c, 0, N-1));
    }
    
    static int dfs(char[] c, int index, int end){
        if(index == end || index > end){
            return 0;
        }
        if(index + 1 == end){
           
           
            return (c[index] - '0') * (c[end]- '0');

        }
        int sum = 0;
        if(index < end){
            int v = c[index] - '0';
            System.out.println(v);
            int min = Integer.MAX_VALUE, minindex = -1;
            for(int i = index + 1; i <= end; i++){
                int cnum = c[i] - '0';
                if(cnum < min){
                    min = cnum;
                    minindex = i;
                }
            }
            sum += v * min;
            int left = dfs(c, index+1, minindex-1);
            int right = dfs(c, minindex+1, end);
           
            sum = sum + left + right;
        }
        return sum;
    }
}