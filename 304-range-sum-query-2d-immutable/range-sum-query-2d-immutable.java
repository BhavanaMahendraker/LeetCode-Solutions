class NumMatrix {
    int[][] prefixMatrix;
    public NumMatrix(int[][] matrix) {
        prefixMatrix = new int[matrix.length+1][matrix[0].length+1];

        for(int i=1; i<prefixMatrix.length; i++){
            for(int j=1; j<prefixMatrix[0].length; j++){
                prefixMatrix[i][j] = prefixMatrix[i-1][j] + prefixMatrix[i][j-1] 
                                        - prefixMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        return prefixMatrix[row2][col2] - prefixMatrix[row1-1][col2] - prefixMatrix[row2][col1-1] + prefixMatrix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */