package Chart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hot212 {
    class Solution {
        Set<String> set = new HashSet<>();
        public List<String> findWords(char[][] board, String[] words) {
            for (String word : words) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if(DFS(board,i,j,word,0)){
                            set.add(word);
                        }
                    }
                }
            }
            return new ArrayList<>(set);
        }

        private boolean DFS(char[][] board, int i, int j, String word,int k) {
            if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j]=='0'){
                return false;
            }
            if(word.charAt(k) != board[i][j]){
                return false ;
            }
            if(k == word.length()-1){

                return true;
            }
            board[i][j] = '0';
            boolean right = DFS(board,i,j+1,word,k+1);
            if(right){
                board[i][j] = word.charAt(k);
                return true;
            }
            boolean up =  DFS(board,i-1,j,word,k+1);
            if(up){
                board[i][j] = word.charAt(k);
                return true;
            }
            boolean left = DFS(board,i,j-1,word,k+1);
            if(left){
                board[i][j] = word.charAt(k);
                return true;

            }
            boolean down = DFS(board,i+1,j,word,k+1);
            if(down){
                board[i][j] = word.charAt(k);
                return true;
            }
            return false;
        }
    }
}
