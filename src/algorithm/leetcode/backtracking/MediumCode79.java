package algorithm.leetcode.backtracking;

import java.util.Objects;

/**
 * @author : LoneKing
 * @Date : 2021/6/5
 */
public class MediumCode79 {
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if (Objects.isNull(board) || board.length == 0 || Objects.isNull(word) || word.isEmpty()) {
            return false;
        }

        final int maxColumnIndex = board[0].length - 1;
        final int maxRowIndex = board.length - 1;

        // 先找到起点
        for (int row = 0; row <= maxRowIndex; row++) {
            for (int col = 0; col <= maxColumnIndex; col++) {

                char c = board[row][col];
                if (c == word.charAt(0)) {
                    used = new boolean[board.length + 1][board[0].length + 1];
                    boolean res = f(board, word, 1, col, row);
                    if (res) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean f(char[][] board, String word, int findWordLength,
                     int columnIndex, int rowIndex) {
        final int maxColumnIndex = board[0].length - 1;
        final int maxRowIndex = board.length - 1;


        if (  columnIndex < 0 || columnIndex > maxColumnIndex
                || rowIndex < 0 || rowIndex > maxRowIndex || used[rowIndex][columnIndex] ) {
            return false;
        }
        if (word.charAt(findWordLength - 1) != board[rowIndex][columnIndex]) {
            return false;
        }
        if (word.length() == findWordLength) {
            return true;
        }

        used[rowIndex][columnIndex] = true;
        boolean res = f(board, word, findWordLength + 1, columnIndex, rowIndex - 1)
                ||
                f(board, word, findWordLength + 1, columnIndex, rowIndex + 1)
                ||
                f(board, word, findWordLength + 1, columnIndex - 1, rowIndex)
                ||
                f(board, word, findWordLength + 1, columnIndex + 1, rowIndex);
        used[rowIndex][columnIndex] = false;

        return res;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new MediumCode79().exist(board, "SEE"));
        System.out.println(System.nanoTime() - start);
    }
}
