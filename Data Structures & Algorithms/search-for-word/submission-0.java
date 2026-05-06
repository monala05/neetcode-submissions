class Solution {
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
    int row = board.length;
    int col = board[0].length;    

    visited = new boolean[row][col];

    for(int i  = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            if(dfs(board, word, i, j, 0)){
                return true;
            }
        }
    }

    return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int i){
        if(i == word.length()){
            return true;
        }
        
        if(row < 0 || col < 0 ||row >= board.length || col >= board[0].length 
        || board[row][col] != word.charAt(i) || visited[row][col] == true){
            return false;
        }

        visited[row][col] = true;

        boolean found = dfs(board, word, row + 1, col, i + 1) ||
        dfs(board, word, row, col + 1, i + 1) ||
        dfs(board, word, row - 1, col, i + 1) ||
        dfs(board, word, row, col - 1, i + 1);

        visited[row][col] = false;
        return found;
    }


}
