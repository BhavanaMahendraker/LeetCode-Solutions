class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        
        while(left <= right && up <= down){
            for(int i=left; i<= right; i++){
                res.add(matrix[up][i]);
            }
            up++;
            if(left > right || up > down) 
                break;
            
            for(int i=up; i<= down; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left > right || up > down) 
                break;
                
            for(int i=right; i >= left; i--){
                res.add(matrix[down][i]);
            }
            down--;
            if(left > right || up > down) 
                break;
            
            for(int i=down; i>= up; i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(left > right || up > down) 
                break;
        }
        
        return res;
    }
}