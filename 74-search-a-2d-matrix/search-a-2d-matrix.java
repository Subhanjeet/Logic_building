class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;    // number of rows in 1st example we have 3 rows       
        int m = matrix[0].length; // number of columns in 1st example we have 4 columns
        int low = 0, high = n * m -1;
        
        while(low <= high){
            int guess = (low + high) / 2;
            int row = guess / m;        
            int col = guess % m;

            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] <= target){
                low = guess +1;
            }else{
                high = guess -1;
            }
        }
        return false;

    }
}