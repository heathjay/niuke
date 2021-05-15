class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        if(r == 0 ) return;
        int c = matrix[0].length;
        if(c == 0) return;


        boolean[] rowsFlag = new boolean[r];
        boolean[] colFlag = new boolean[c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    rowsFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }


        for(int i = 0; i < r; i++){
            for(int j = 0 ; j < c ;j++){
                if(rowsFlag[i]){
                    matrix[i][j] = 0;
                }
                if(colFlag[j]){
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }


    public void setZeroes1(int[][] matrix){
        int r = matrix.length;
        if(r == 0) return;
        int c = matrix[0].length;
        if(c == 0) return;


        boolean rowsFlag0 = false;
        boolean colsFlag0 = false;

        for(int i = 0 ; i < r ; i++){
            if(matrix[i][0] == 0){
                rowsFlag0  = true;
            }
        }

        for(int j = 0; j < c ; j++){
            if(matrix[0][j] == 0){
                colsFlag0 = true;
            }
        }

        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(colsFlag0){
            for(int i = 0; i < c; i++){
                matrix[0][i] = 0;
            }
        }
        if(rowsFlag0){
            for(int i = 0; i < r;i++){
                matrix[i][0] = 0;
            }
        }
    }
}