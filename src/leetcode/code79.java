package leetcode;

import java.util.Arrays;

public class code79 {

    private boolean findEnd;

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        findEnd = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(i, j, 0, board, word.toCharArray(), visited);
            }
        }
        return findEnd;
    }

    private void backtrack(int row, int col, int index, char[][] board, char[] word, boolean[][] visited) {
        if (index > word.length - 1)
            return;
        int maxRowIndex = board.length - 1;
        int maxColIndex = board[0].length - 1;
        int i = row;
        int j = col;

        // 判断当前点是否和其他周围点有接触的
        boolean adjoin = i - 1 >= 0 && visited[i - 1][j] || i + 1 <= maxRowIndex && visited[i + 1][j]
                || j - 1 >= 0 && visited[i][j - 1] || j + 1 <= maxColIndex && visited[i][j + 1];
        adjoin = (adjoin && index > 0 || index == 0);
        // 如果字符相等 并且此点未被使用
        if (board[i][j] == word[index] && !visited[i][j] && adjoin) {
            System.out.println(index + ":" + word[index]);
            for (int k = 0; k < visited.length; k++) {
                System.out.println(Arrays.toString(visited[k]));
            }
            // 如果找到了并且 已经找到的字符长度符合 不用继续找了
            if (index == word.length - 1) {
                findEnd = true;
                visited[i][j] = true;
                System.out.println("find it,last:" + i + "," + j);
                System.out.println(index + ":" + word[index]);
                for (int k = 0; k < visited.length; k++) {
                    System.out.println(Arrays.toString(visited[k]));
                }
                return;
            }
            // 可以向上继续走
            if (i - 1 >= 0 && !visited[i - 1][j] && !findEnd) {
                visited[i][j] = true;
                backtrack(i - 1, j, index + 1, board, word, visited);
                visited[i][j] = false;
            }
            // 可以向下继续走
            if (i + 1 <= maxRowIndex && !visited[i + 1][j] && !findEnd) {
                visited[i][j] = true;
                backtrack(i + 1, j, index + 1, board, word, visited);
                visited[i][j] = false;
            }
            // 可以向左继续走
            if (j - 1 >= 0 && !visited[i][j - 1] && !findEnd) {
                visited[i][j] = true;
                backtrack(i, j - 1, index + 1, board, word, visited);
                visited[i][j] = false;
            }
            // 可以向右继续走
            if (j + 1 <= maxColIndex && !visited[i][j + 1] && !findEnd) {
                visited[i][j] = true;
                backtrack(i, j + 1, index + 1, board, word, visited);
                visited[i][j] = false;
            }
        } else if (index > 0) {
            return;
        }

    }


    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'b', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a', 'b'},
                {'a', 'a', 'a', 'b', 'a'},
                {'a', 'a', 'a', 'a', 'a'},
                {'a', 'b', 'a', 'b', 'b'},
                {'a', 'b', 'b', 'a', 'b'}
        };

        System.out.println(new code79().exist(board, "abbab"));
        //  System.out.println(new Main().exist(board, "ABCCED"));
        // System.out.println(new Main().exist(board, "SEE"));
        // System.out.println(new Main().exist(board, "ABCB"));

    }

}
