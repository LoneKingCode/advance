package leetcode.backtracking;

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
    List<String> result = new ArrayList<>();
    int[] minutesArr = new int[]{1, 2, 4, 8, 16, 32};
    int[] hourArr = new int[]{1, 2, 4, 8};

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8 || turnedOn < 1) {
            return new ArrayList<>();
        }

        return result;
    }

    public void f(int turnedOn,int current, int hour, int minutes) {
        if(current == turnedOn)
        {
            // save result
            return;
        }
    }

    public static void main(String[] args) {

    }
}
