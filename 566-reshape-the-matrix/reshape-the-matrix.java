class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        if(rows*cols != r*c){
            return mat;
        }

        int[][] ans = new int[r][c];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){

                int index = i*cols+j;

                int ansRow = index/c;
                int ansCol = index%c;
                
                ans[ansRow][ansCol] = mat[i][j];
            }
            
        }
        return ans;
    }
}