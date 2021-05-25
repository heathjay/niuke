class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

       
        while(columnNumber != 0){
           int remainder = columnNumber % 26 == 0 ? 26 : columnNumber % 26 ;
           char res = (char) (64+ remainder);
           res.insert(0,res);
           columnNumber = (columnNumber - remainder) / 26;
        }
        return sb.toString();
    }
}