public class Solution {
    public boolean help(int[] seq, int start, int root){
        if(start >= root) return true;
        int key = seq[root];
        int i ;
        for(i = start; i < root; i++){
            if(seq[i] > key) break;
        }

        for(int j = i; j < root; j++){
            if(seq[j] < key){
                return false;
            }
        }

        return help(seq, start, i - 1) && help(seq, i, root-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length ==0) return false;
        return help(sequence, 0, sequence.length - 1);
    }
}