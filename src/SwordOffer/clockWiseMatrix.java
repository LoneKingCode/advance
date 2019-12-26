package SwordOffer;

import java.util.ArrayList;
/**
 * 题目：顺时针打印矩阵
 * 描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 思路：一圈一圈打印，先上边，然后右边，然后下边，然后左边
 */
public class clockWiseMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        clockWise(matrix, result);
        return result;
    }

    void clockWise(int[][] matrix, ArrayList<Integer> result) {
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
