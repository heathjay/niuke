class Solution {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        int A = 0, B = 0;
        for(int i = 0 ; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                A++;
            }else{
                if(arr[secret.charAt(i) - '0']++ < 0){
                    B++;
                }
                if(arr[guess.charAt(i) - '0']-- > 0){
                    B++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(A).append('A').append(B).append('B');
    }
}