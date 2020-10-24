public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        return help(str, pattern,0,0);
    }

    public boolean help(char[] str, char[] pattern, int i, int j){
        if(i == str.length && j == pattern.length) return true;
        if(j >= pattern.length) return false;
        if(i == str.length && j < pattern.length){
            if((j + 1) < pattern.length && pattern[j + 1] == '*'){
                return help(str, pattern, i, j+2);
            }
            return false;
        }
        if (pattern[j] == '.' && (j+1) < pattern.length && pattern[j+1] == '*'){
            return help(str, pattern, i, j + 2) || help(str, pattern,++i,j);
        }else if(pattern[j] == '.'){
            return help(str,pattern, ++i,++j);
        }

        if(str[i] == pattern[j] && (j+1) < pattern.length && pattern[j+1] == '*'){
            return help(str, pattern,i, j+ 2) || help(str, pattern, ++i,j);
        }else if(str[i] == pattern[j]){
            return help(str,pattern,++i,++j);
        }

        if(str[i] != pattern[j] && (j+1) < pattern.length && pattern[j+1] =='*'){
            return help(str,pattern,i,j+2) ;
        }else{
            return false;
        }

    }
}