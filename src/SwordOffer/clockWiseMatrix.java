package SwordOffer;

import java.util.ArrayList;

public class clockWiseMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        clockWise(matrix, result);
        return result;
    }

    void clockWise(int[][] matrix, ArrayList<Integer> result) {
        if (result.size() == matrix.length * matrix[0].length)
            return;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            //上面 row固定 col变
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;
            if (top > bottom) break;
            //右侧面 col固定 row变
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            if (right < left)
                break;
            //下面 row固定 col变
            for (int col = right; col >= left; col--) {
                result.add(matrix[bottom][col]);
            }
            bottom--;
            if (top > bottom) break;
            //左侧 col不变 row变
            for (int row = bottom; row >= top; row--) {
                result.add(matrix[row][left]);
            }
            left++;
            if (left > right) break;
        }

    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1},
                {2},
                {3},
                {4},
                {5}

        };
        System.out.println(new clockWiseMatrix().printMatrix(matrix));
    }

}
