class Solution {
    public String reverseWords(String s) {
        if(s == null) return s;
        String[] strings = s.trim().split("\\s+");
        int len = strings.length;
        StringBuilder sb = new StringBuilder();
        for(int i = len-1; i > 0; i--){
            sb.append(strings[i]).append(" ");
        }
        sb.append(strings[0]);
        return sb.toString();

    }
}