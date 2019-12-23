package SwordOffer;

/**
 * 题目：二维数组的查找
 * 介绍：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 思路：因为从左到右为有序，递增，从上到下有序，递增，所以选择左下角为搜索起点，小于则向上走，大于则向右走
 * 如下
 * 1 4 8
 * 2 6 9
 * 3 9 10
 */
public class DoubleDimensionalArrayFind {
    //    递归法
//    private boolean result;
//    public boolean Find(int target, int[][] array) {
//        result = false;
//        find(target, array, array.length - 1, 0);
//        return result;
//    }
//
//    private void find(int target, int[][] arr, int row, int col) {
//        if (row >= 0 && col < arr[0].length) {
//            if (target > arr[row][col]) {
//                find(target, arr, row, col + 1);
//            } else if (target < arr[row][col]) {
//                find(target, arr, row - 1, col);
//            } else {
//                result = true;
//            }
//        }
//    }

    public boolean Find(int target, int[][] array) {
        if (array.length < 1) {
            return false;
        }
        int row = array.length - 1;
        int col = 0;
        int maxCol = array[0].length - 1;
        while (row >= 0 && col <= maxCol) {
            int value = array[row][col];
            if (value == target) {
                return true;
            }
            //如果当前位置的值大于目标值 向上继续
            else if (value > target) {
                row--;
            }
            //否则就向右继续搜索
            else {
                col++;
            }
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(new DoubleDimensionalArrayFind().Find(7, array));
    }
}

