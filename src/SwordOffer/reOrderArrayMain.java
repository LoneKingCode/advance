package SwordOffer;

import java.util.Arrays;

public class reOrderArrayMain {
    //遇到偶数就放到末尾
    public void reOrderArray(int[] array) {
        int move = 0;
        int index = 0;
        while (array.length - move - index > 0) {
            if (array[index] % 2 == 0) {
                int temp = array[index];
                System.arraycopy(array, index + 1, array, index, array.length - index - 1);
                array[array.length - 1] = temp;
                move++;
                index--;
            }
            index++;
        }
    }

    public void reOrderArray1(int[] array) {
        int pos = 0;
        boolean firstEven = array.length > 0 && array[0] % 2 == 0;
        for (int i = 0; i < array.length; i++) {
            //找到奇数元素且左边为偶数元素
            if (array[i] % 2 == 1 && i > 0 && array[i - 1] % 2 == 0) {
                int temp = array[i];
                if (pos > 0) { //该奇数前右多个偶数，偶数整体右移
                    System.arraycopy(array, pos, array, pos + 1, i - pos);
                    if (firstEven) array[pos++] = temp;
                    else array[++pos] = temp;
                } else if (firstEven && pos == 0) { //首位偶数的话 直接整体右移一下给奇数让出位置
                    System.arraycopy(array, pos, array, pos + 1, i - pos);
                    array[pos++] = temp;
                } else { //首次发现奇数情况，偶数右移1 奇数左移到偶数位置
                    pos = i - 1;
                    System.arraycopy(array, pos, array, pos + 1, 1);
                    array[pos] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 9, 11, 13};
        new reOrderArrayMain().reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

}

