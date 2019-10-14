import java.util.Arrays;

public class Main {

    public boolean exist(char[][] board, String word) {

    }

    private void backtrack() {

    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Main().exist(board, "ABCCED"));
        System.out.println(new Main().exist(board, "SEE"));
        System.out.println(new Main().exist(board, "ABCB"));

    }

}
