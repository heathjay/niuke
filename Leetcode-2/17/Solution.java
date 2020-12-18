class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new  ArrayList<>();
        int len = digits.length();
        if(len == 0 || digits == null) return res;
        backtrace(res, digits, 0, new StringBuffer());
        return res;
    }

    public void backtrace(List<String> res, String digits, int index, StringBuffer sb){
        if(index == digits.length()){
            res.add(sb.toString());
        }else{
            char digit = digits.charAt(index);
            String nowString = getString(digit-'0');
            for(int i = 0 ; i < nowString.length(); i++){
                sb.append(nowString.charAt(i));
                backtrace(res, digits, index+1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
    public String getString(int num){
        switch (num) {
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
        }
    }
}