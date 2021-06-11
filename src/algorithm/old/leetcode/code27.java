package algorithm.old.leetcode;

public class code27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //找到该元素就把他往后移动
            if (nums[i] == val) {
                boolean noFind = true;
                //找到一个别的数和他交换位置
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        count++;
                        nums[i] += nums[j];
                        nums[j] = nums[i] - nums[j];
                        nums[i] -= nums[j];
                        noFind = false;
                        break;
                    }
                }
                if(noFind) return i;

            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] arr = {3,3};
        System.out.println(new code27().removeElement(arr, 3));
    }

}
