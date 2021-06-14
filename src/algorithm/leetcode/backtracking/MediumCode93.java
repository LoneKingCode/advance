package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 题解配图
 * https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
 * https://pic.leetcode-cn.com/b581bdde1cef982f0af3182af17fc3c41960c76a7445af0dcfd445c89b4c2eaa-%E3%80%8C%E5%8A%9B%E6%89%A3%E3%80%8D%E7%AC%AC%2093%20%E9%A2%98%EF%BC%9A%E5%A4%8D%E5%8E%9F%20IP%20%E5%9C%B0%E5%9D%80-1.png
 * @author wangzixiang
 * @date 2021/6/14
 */
public class MediumCode93 {
    public final int SEGMENT = 4;
    public final int UNIT = 3;
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        f(s, 0, 1, new ArrayList<>());
        return result;
    }

    // segmentId记录当前在构造第几段的ip片段

    public void f(String s, int start, int segmentId, ArrayList<String> temp) {
        if (start >= s.length() && segmentId > SEGMENT) {
            result.add(String.join(".", temp));
            return;
        }
        int strRemain = s.length() - start;
        int minRemain = SEGMENT - segmentId;
        int maxRemain = minRemain * UNIT;

        // 剩余的位数过多，凑不出来正确的ip直接跳过
        if (strRemain < minRemain || strRemain - UNIT > maxRemain) {
            return;
        }

        // 依次尝试分割1 2 3 位
        for (int i = 1; i <= UNIT && (start + i <= s.length()); i++) {
            // 判断边界
            int seg = Integer.parseInt(s.substring(start, start + i));
            if (s.charAt(start) == '0' && i > 1 || seg > 255) {
                continue;
            }
            // 最后一段要都分完
            if (segmentId == SEGMENT && strRemain - i != 0) {
                continue;
            }
            temp.add(String.valueOf(seg));
            f(s, start + i, segmentId + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MediumCode93().restoreIpAddresses("010010"));
    }
}
