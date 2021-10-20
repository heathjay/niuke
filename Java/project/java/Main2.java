import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Main2{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int T = Integer.parseInt(sn.nextLine());
        for(int i = 1; i <= T; i++){
            int N = Integer.parseInt(sn.nextLine());
            int[] desk = new int[N];
            String s = sn.nextLine();
            int one = 0 , two = 0, zero = 0;
            PriorityQueue<Integer> ones = new PriorityQueue<>((o1, o2) -> o1-o2);
             PriorityQueue<Integer> zeros = new PriorityQueue<>((o1, o2) -> o1-o2);
            for(int j = 0; j < N ;j++){
                desk[j] = (int)(s.charAt(j) - '0');
                if(desk[j] == 0){
                   // zero++;
                    zeros.add(j);
                }
                else if(desk[j] == 1){ 
                    one++;
                    ones.add(j);
                }
                else if(desk[j] == 2) two++;
            }
            
            if(two == N) continue;
            int inNum = Integer.parseInt(sn.nextLine());
            String in = sn.nextLine();
            
            for(int j = 0 ; j < inNum; j++){
                char c = in.charAt(j);
                if(c == 'F'){
                    /*
                    if(zero == 0){
                        for(int k = 0; k < N; k++){
                            if(desk[k] == 1){
                                desk[k] = 2;
                                two++;
                                one--;
                                System.out.println(k+1);
                                break;
                            }
                        }
                    }else{
                      for(int k = 0; k < N; k++){
                            if(desk[k] == 0){
                                desk[k] = 1;
                                one++;
                                zero--;
                                System.out.println(k+1);
                                break;
                            }
                        }
                    }
                    */
                    if(zeros.isEmpty()){
                        int k = ones.poll();
                        System.out.println(k+1);
                       
                    }else{
                        int k = zeros.poll();
                        System.out.println(k+1);
                        ones.add(k);
                    }
                }else if(c == 'M'){
                    /*
                    if(one == 0){
                        for(int k = 0; k < N; k++){
                            if(desk[k] == 0){
                                desk[k] = 1;
                                one++;
                                zero--;
                                System.out.println(k+1);
                                break;
                            }
                        }
                    }else{
                        for(int k = 0; k < N; k++){
                            if(desk[k] == 1){
                                desk[k] = 2;
                                one--;
                                two++;
                                System.out.println(k+1);
                                break;
                            }
                        }
                    }
                    */
                    if(ones.isEmpty()){
                        int k = zeros.poll();
                        System.out.println(k+1);
                        ones.add(k);
                    }else{
                        System.out.println(ones.poll()+1);
                        
                    }
                }
            }
            
        }
    }
}