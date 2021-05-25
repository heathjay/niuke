class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        int len1 = vs1.length;
        int len2 = vs2.length;
        int len = Math.max(len1, len2);
        for(int i=0; i < len;i++){
            int x = i >= len1 ? 0 : Integer.parseInt(vs1[i]);
            int y = i >= len2 ? 0 : Integer.parseInt(vs2[i]);
            if(x > y){
                return 1;
            }else if(x <y){
                return -1;
            }else{
                continue;
            }
        }
        return 0;
    }
}