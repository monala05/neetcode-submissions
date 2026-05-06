class Solution {
    public int uniquePaths(int m, int n) {
        
        return brute(m - 1, n - 1);
    }

    public int brute(int i, int j){
        if(i == 0 || j == 0){
            return 1;
        }

        if(i < 0 || j < 0){
            return 0;
        }

        return brute(i - 1, j) + brute(i, j -1);
    }
}
