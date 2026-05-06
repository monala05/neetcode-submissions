class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<List<Character>> rows = new ArrayList();
        List<List<Character>> cols = new ArrayList();
        List<List<List<Character>>> sectors = new ArrayList();

        //initialize lists
        for(int i = 0; i < 9; i++){
            rows.add(new ArrayList());
            cols.add(new ArrayList());
        }

        for(int i = 0; i < 3; i++){
            sectors.add(new ArrayList());
            for(int j = 0; j < 3; j++){
                sectors.get(i).add(new ArrayList());
            }
        }

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                char cur = board[row][col];
                
                if(cur != '.'){
                    if(rows.get(row).contains(cur)){
                        return false;
                    }else{
                        rows.get(row).add(cur);
                    }

                    if(cols.get(col).contains(cur)){
                        return false;
                    }else{
                        cols.get(col).add(cur);
                    }

                    int secRow = row / 3;
                    int secCol = col / 3;

                    if(sectors.get(secRow).get(secCol).contains(cur)){
                        return false;
                    }else{
                        sectors.get(secRow).get(secCol).add(cur);
                    }
                }

            }
        }

        return true;
     }
    }



