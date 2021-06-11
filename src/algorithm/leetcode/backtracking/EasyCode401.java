package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/5/26
 */
public class EasyCode401 {

    List<String> result2 = new ArrayList<>();

    public int bCount(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;

        }
        return count;
    }

    public List<String> readBinaryWatch2(int turnedOn) {
        if (turnedOn < 0) {
            return new ArrayList<>();
        }
        // 所有组合都列出来 计算二进制数的1的个数
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 12; j++) {
                if (bCount(i) + bCount(j) == turnedOn) {
                    result2.add(j + ":" + (i < 10 ? "0" + i : i));
                }
            }
        }
        return result2;
    }


    // 回溯

    List<String> result = new ArrayList<>();
    int[] timeArr = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn < 0) {
            return new ArrayList<>();
        }
        f(turnedOn, 0, 0, 0);
        return result;
    }

    public void f(int turnedOn, int timeStartIndex, int hourSum, int minutesSum) {
        if (turnedOn == 0) {
            if (hourSum > 11 || minutesSum > 59) {
                return;
            }
            StringBuilder sb = new StringBuilder();

            sb.append(hourSum);

            sb.append(":");
            if (minutesSum < 10) {
                sb.append(0);
            }
            sb.append(minutesSum);

            result.add(sb.toString());
            return;
        }

        for (int i = timeStartIndex; i < timeArr.length; i++) {
            if (i < 4) {
                hourSum += timeArr[i];

            } else {
                minutesSum += timeArr[i];
            }
            f(turnedOn - 1, i + 1, hourSum, minutesSum);

            if (i < 4) {
                hourSum -= timeArr[i];

            } else {
                minutesSum -= timeArr[i];

            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new EasyCode401().readBinaryWatch2(1));
    }
}
