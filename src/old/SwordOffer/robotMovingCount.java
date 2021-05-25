package old.SwordOffer;

public class robotMovingCount {
    private int moveCount = 0;
    private boolean[][] visited;

    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows + 1][cols + 1];
        tryMove(threshold, rows, cols, 0, 0);
        return moveCount;
    }

    private void tryMove(int thresold, int rows, int cols, int curRow, int curCol) {
        if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols) {
            return;
        }
        if (visited[curRow][curCol] || !isAllow(thresold, curRow, curCol)) {
            return;
        }
        moveCount++;
        visited[curRow][curCol] = true;
        tryMove(thresold, rows, cols, curRow - 1, curCol);
        tryMove(thresold, rows, cols, curRow, curCol + 1);
        tryMove(thresold, rows, cols, curRow + 1, curCol);
        tryMove(thresold, rows, cols, curRow, curCol - 1);
    }

    private boolean isAllow(int thresold, int row, int col) {
        String rowStr = String.valueOf(row);
        String colStr = String.valueOf(col);
        int sum = 0;
        for (int i = 0; i < rowStr.length(); i++) {
            sum += (rowStr.charAt(i) - '0');
        }
        for (int i = 0; i < colStr.length(); i++) {
            sum += (colStr.charAt(i) - '0');
        }
        return sum <= thresold;
    }

    public static void main(String[] args) {
        System.out.println(new robotMovingCount().movingCount(15, 20, 20));
    }

}

