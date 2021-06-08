class Solution {
    public boolean wordPattern(String pattern, String s) {
        int plen = pattern.length();
        String[] strs = s.trim().split(" ");
        int slen = strs.length;
        if(plen != slen) return false;

        Map<Character, String>  p2s= new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();

        for(int i = 0 ; i < plen; i++){
           if(p2s.size() != s2p.size()){
               return false;
           }
            if(p2s.containsKey(pattern.charAt(i)) && !strs[i].equals(p2s.get(pattern.charAt(i)))  ){
                return false;
            }
            if(s2p.containsKey(strs[i]) && s2p.get(strs[i]) != pattern.charAt(i)){
                return false;
            }
           p2s.put(pattern.charAt(i),strs[i]);
           s2p.put(strs[i], pattern.charAt(i));
        }
        return true;
    }
}