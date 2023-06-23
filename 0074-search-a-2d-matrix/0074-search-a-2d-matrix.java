class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow, rows = matrix.length, cols = matrix[0].length, up = 0, down = rows -1;

        while(up <= down){
            targetRow = (up+down) / 2;
            if(matrix[targetRow][cols - 1] < target)
                up = targetRow + 1;
            else if(matrix[targetRow][0] > target)
                down = targetRow - 1;
            else 
                break;
        }
        if(up > down) return false;
        targetRow = (up+down) / 2;
        int left = 0, right = cols - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[targetRow][mid] < target)
                left = mid + 1;
            else if (matrix[targetRow][mid] > target)
                right = mid - 1;
            else
                return true;
        }

        return false;        
    }
}