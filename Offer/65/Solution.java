public class Solution {
    public boolean[][] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        visited = new boolean[rows][cols];
        char[][] arr = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = matrix[i * cols + j];
            }
        }
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < cols; j++){
                if(find(arr,rows, cols, str, i, j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] arr, int rows, int cols, char[] str, int rpos, int cpos,int spos){
        if(spos >= str.length){
            return true;
        }

        if(rpos < 0 || cpos < 0 || rpos >= rows || cpos >= cols || arr[rpos][cpos] != str[spos] || visited[rpos][cpos]){
            return false;
        }

        visited[rpos][cpos] = true;
        boolean isS = find(arr, rows, cols, str, rpos + 1, cpos, spos + 1)
        || find(arr, rows, cols, str, rpos , cpos+1, spos + 1)
        || find(arr, rows, cols, str, rpos - 1, cpos, spos + 1)
        || find(arr, rows, cols, str, rpos , cpos - 1, spos + 1);
        visited[rpos][cpos] = false;
        return isS;
    }
}