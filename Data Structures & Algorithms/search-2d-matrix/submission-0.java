class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //how can i use a binary search for this???
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols - 1;
        
        while(l <= r){
            int mid = l + (r - l)/2;

            int curRow = mid/cols;
            int curCol = mid%cols;

            if(matrix[curRow][curCol] == target){
                return true;
            }else if(matrix[curRow][curCol] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return false;
    }
}
