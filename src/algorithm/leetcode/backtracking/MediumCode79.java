package algorithm.leetcode.backtracking;

import java.util.Objects;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *  
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
