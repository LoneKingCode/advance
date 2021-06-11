package algorithm.old.leetcode;

import java.util.Arrays;

public class code59 {
    //思路： 依次填充外圈 分为 上 右 下 左
    public int[][] generateMatrix1(int n) {
        int[][] result = new int[n][n];
        int top = 0, right = n - 1, bottom = n - 1, left = 0;
        int nn = n * n;
        int count = 1;
        int circle = 0;
        while (count <= nn) {
            //上
            for (int i = circle; i < n - circle; i++) {
                result[top][i] = count++;
            }
            //右
            for (int i = circle + 1; i < n - 1 - circle; i++) {
                result[i][right] = count++;
            }
            top++;
            right--;
            //下
            for (int i = n - 1 - circle; i >= circle + 1; i--) {
                result[bottom][i] = count++;
            }
            bottom--;
            //左
            for (int i = n - 1 - circle; i >= circle + 1; i--) {
                result[i][left] = count++;
            }
            left++;
            circle++;
        }
        return result;
    }

    //本方法思路： 每次填充一层外圈圈的值 之后填充中心点的那一个值
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int nn = n * n;
        int count = 1;
        //第几次完成完整的圈
        int circle = 0;
        int destinationRow = 0;
        while (count <= nn) {
            for (int i = circle; i < n - circle; i++) {
                if (count > nn) {
                    break;
                }
                //最左侧 从下到上 赋值
                if (destinationRow != 0) {
                    for (int dr = destinationRow; dr > circle; dr--) {
                        result[dr][0 + circle] = count++;
                    }

                    if (count > nn) {
                        return result;
                    }
                    //开始下一圈
                    circle++;
                    destinationRow = 0;
                    //最后一个数字 在最中心
                    if (count == nn) {
                        result[(n + 1) / 2 - 1][(n + 1) / 2 - 1] = count;
                        return result;
                    } else {
                        break;
                    }
                }
                //首行赋值
                else if (i == circle) {
                    for (int j = circle; j < n - circle; j++) {
                        result[i][j] = count++;
                    }
                }
                //最后一行 要开始给数组倒着赋值了
                else if (i == n - 1 - circle) {

                    for (int k = n - 1 - circle; k >= circle; k--) {
                        result[i][k] = count++;
                    }
                    destinationRow = i - 1;
                }
                //其他情况 只给该行最后一个元素赋值
                else {
                    result[i][n - 1 - circle] = count++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new code59().generateMatrix1(3);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
