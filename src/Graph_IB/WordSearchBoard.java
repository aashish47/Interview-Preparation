package Graph_IB;

import java.util.*;

public class WordSearchBoard {

    public static int exist(ArrayList<String> A, String B) {
        int rows = A.size();
        int columns = A.get(0).length();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(dfs(i, j, A, B, 0)){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static boolean dfs(int i, int j, ArrayList<String> board, String word, int index){
        int rows = board.size();
        int columns = board.get(0).length();

        if(i < 0 || i >= rows || j < 0 || j >= columns){
            return false;
        }
        else if(board.get(i).charAt(j) != word.charAt(index)){
            return false;
        }
        else if(index == word.length() - 1){
            return true;
        }
        else{
            return dfs(i + 1, j, board, word, index + 1) ||
                    dfs(i - 1, j, board, word, index + 1) ||
                    dfs(i, j + 1, board, word, index + 1) ||
                    dfs(i, j - 1, board, word, index + 1);
        }

    }
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA"));
        String B = "FAFBA";
        System.out.println(exist(A, B));
    }
}
