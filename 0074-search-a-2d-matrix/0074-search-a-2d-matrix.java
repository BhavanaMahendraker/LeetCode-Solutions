class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = findTargetRow(matrix, target);
        if(targetRow == -1)
            return false;
        
        int left = 0, right = matrix[targetRow].length - 1;
        while(left <= right){
            int mid = (right + left) / 2;
            if(matrix[targetRow][mid] == target)
                return true;
            if(matrix[targetRow][mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return false;
    }
    
    public int findTargetRow(int[][] matrix, int target){
        int left =0, right = matrix.length - 1; 
        
        while(left <= right){
            int mid = (right + left) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length-1]){
                return mid;
            }
            if(matrix[mid][0] > target){
                right = mid - 1;
            } else if (target > matrix[mid][matrix[mid].length-1]) {
                left = mid + 1;
            } 
        }
        
        return -1;
    }
}