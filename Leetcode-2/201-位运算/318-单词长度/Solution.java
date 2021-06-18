class Solution {
    public int bitNumber(char ch){
        return (int)ch - (int)'a';
    }
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] marks = new int[len];
        int[] lens = new int[len];

        for(int i = 0; i < len ; i++){
            int bimask = 0;
            for(char ch : words[i].toCharArray()){
                bimask |= 1 << bitNumber(ch);
            }
            marks[i] = bimask;
            lens[i] = words[i].length();
        }

        int maxVal = 0;
        for(int i = 0 ; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if((marks[i] & marks[j]) == 0){
                    maxVal =  Math.max(maxVal, lens[i] * lens[j]);
                }
            }
        }
        return maxVal;
    }
}