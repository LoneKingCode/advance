package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class code167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return new int[]{0, 0};
        }

        int first = 0, second = 0;
        HashMap<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                first = map.get(numbers[i]);
                second = i;
                return new int[]{first + 1, second + 1};
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 4};
        System.out.println(Arrays.toString(new code167().twoSum(arr, 0)));
    }


}
