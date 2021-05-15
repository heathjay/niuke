class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r == 0) return false;
        int c = matrix[0].length;
        if(c == 0) return false;
        int row = 0;
        int top = 0, bottom = r - 1;
        while(top <= bottom){
            int mid = (bottom - top) / 2 + top;
            if(matrix[mid][0] < target){
                row = mid;
                top = mid + 1;
            }else if(matrix[mid][0] > target){
                bottom = mid - 1;
            }else{
                return true;
            }
        }
        int left = 0, right = c - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target){
        int r = matrix.length;
        if(r == 0) return false;
        int c = matrix[0].length;
        if(c == 0) return false;
        int left = 0, right = r * c - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            int row = mid / c ;
            int col = mid % c;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}