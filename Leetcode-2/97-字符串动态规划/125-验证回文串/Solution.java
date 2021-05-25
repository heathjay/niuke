class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        int len = lowerCase.length();
        int left = 0;
        int right = len - 1 ;

        while(left < right){
            while(left <  right && !Character.isLetterOrDigit(lowerCase.charAt(left))){
                left++;
            }


            while(left < right && !Character.isLetterOrDigit(lowerCase.charAt(right))){
                right--;
            }

            if(lowerCase.charAt(left) != lowerCase.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}