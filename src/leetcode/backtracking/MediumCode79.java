package leetcode.backtracking;

/**
 * @author : LoneKing
 * @Date : 2021/6/5
 */
public class MediumCode79 {
    boolean result = false;

    public boolean exist(char[][] board, String word) {


        return result;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new MediumCode79().exist(board, "ABCCED"));
        System.out.println(System.nanoTime() - start);
    }
}
