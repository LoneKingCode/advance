package SwordOffer;

public class hasPathA {
    private boolean[][] used;
    private boolean find = false;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || rows < 1 || cols < 1 || str.length == 0) return false;
        used = new boolean[rows + 1][cols + 1];
        for (int i = 1; i <= rows && !find; i++) {
            for (int j = 1; j <= cols && !find; j++) {
                tryFind(i, j, rows, cols, 0, str, matrix);
            }
        }
        return find;
    }

    private void tryFind(int curRow, int curCol, int rows, int cols, int pos, char[] str, char[] matrix) {

        int arrPos = getArrPos(curRow, curCol, cols);
        if (find || matrix[arrPos] != str[pos]) {
            return;
        }
        if (pos >= str.length - 1) {
            find = true;
            return;
        }
        System.out.println("Start find:" + pos);
        //如果可以向上继续搜索
        if (curRow > 1 && !used[curRow - 1][curCol]) {
            used[curRow][curCol] = true;
            tryFind(curRow - 1, curCol, rows, cols, pos + 1, str, matrix);
            used[curRow][curCol] = false;
        }
        //如果可以向右搜索
        if (curCol < cols && !used[curRow][curCol + 1]) {
            used[curRow][curCol] = true;
            tryFind(curRow, curCol + 1, rows, cols, pos + 1, str, matrix);
            used[curRow][curCol] = false;
        }
        //如果可以向下搜索
        if (curRow < rows && !used[curRow + 1][curCol]) {
            used[curRow][curCol] = true;
            tryFind(curRow + 1, curCol, rows, cols, pos + 1, str, matrix);
            used[curRow][curCol] = false;
        }
        //如果可以向左搜索
        if (curCol > 1 && !used[curRow][curCol - 1]) {
            used[curRow][curCol] = true;
            tryFind(curRow, curCol - 1, rows, cols, pos + 1, str, matrix);
            used[curRow][curCol] = false;
        }
    }

    //行列位置(1开始) 转为 一维数组索引
    private int getArrPos(int row, int col, int fullCol) {
        return (row - 1) * fullCol + col - 1;
    }

    public static void main(String[] args) {
        char[] matrix = {
                'A', 'A', 'B', 'A',
                'A', 'A', 'A', 'B'};
        char[] str = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'B'};

        System.out.println(new hasPathA().hasPath(matrix, 2, 4, str));
    }

}

