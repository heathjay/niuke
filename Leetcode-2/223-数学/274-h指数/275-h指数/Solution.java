class Solution {
    public int hIndex(int[] citations) {
        int i = 0;
        while(i < citations.length && citations[citations.length-1 - i] > i){
            i++;
        }
        return i;
    }
}