class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        //do a dfs on every cell in the borders
        for(int i = 0; i < cols; i++){
            dfs(board, 0, i);    //top row
            dfs(board, rows -1, i);   //bottom row
        }

        for(int j = 0; j < rows; j++){
            dfs(board, j, 0); //left
            dfs(board, j, cols - 1); //right
        }

        //flip remaining O's into X's
        //flip temp values back into O's
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

        
    }

    public void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' ||  board[row][col] == '#'){
            return;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
