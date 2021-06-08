class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len < k || len == 0)return null;
        Deque<Character> queue = new LinkedList<>();
        for(int i = 0; i < len;i++){
            char digit = num.charAt(i);
            while(!queue.isEmpty()  && )
        }
    }
}