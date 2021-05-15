class Solution {
    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < maxLen;i++){
            int x = i < a.length() ? (a.charAt(a.length()-1-i) - '0') : 0;
            int y = i < b.length() ? (b.charAt(b.length()-1-i) - '0') : 0;
            carry = x + y + carry;
            sb.append((char)(carry % 2 + '0'));
            carry = carry /2;

        }
        if(carry > 0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}