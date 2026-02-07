class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] subBox = new HashSet[9];

        for(int i = 0; i < 9; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            subBox[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];

                if(c == '.'){
                    continue;
                }

                if(row[i].contains(c)){
                    return false;
                }

                row[i].add(c);

                if(col[j].contains(c)){
                    return false;
                }

                col[j].add(c);

                int idx = (i / 3) * 3 + (j / 3);

                if(subBox[idx].contains(c)){
                    return false;
                }

                subBox[idx].add(c);
            }
        }
        return true;
    }
}