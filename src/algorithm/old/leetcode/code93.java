package algorithm.old.leetcode;

import java.util.ArrayList;
import java.util.List;

public class code93 {

    private int maxSaveLength = 0;
    private List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12)
            return result;
        // 每子段最多有几位
        if (s.length() - 4 > 0) {
            if (s.length() - 4 <= 1)
                maxSaveLength = 2;
            else {
                maxSaveLength = 3;
            }
        } else {
            maxSaveLength = 1;
        }
        backtrack(1, new ArrayList<String>(4), s);
        return result;

    }

    private void backtrack(int position, List<String> ip, String remain) {
        if(position >4 && !remain.isEmpty())
            return;
        if (remain.isEmpty()) {
            result.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            return;
        }

        for (int i = 1; i <= maxSaveLength; i++) {
            // 剩余的数字最起码要给当前子段后面的每个段都保留一位
            if (remain.length() - (4 - position) >= i && !(position == 4 && remain.length() > maxSaveLength)
                    && remain.length() >= i && isValid(remain.substring(0, i))) {
                ip.add("");
                ip.set(position - 1, remain.substring(0, i));
                backtrack(position + 1, ip, remain.substring(i));
                ip.remove(ip.size() - 1);
            } else {
                return;
            }
        }
    }

    private boolean isValid(String s)
    {
        return Integer.parseInt(s) <= 255 && !(s.length() > 1 && s.startsWith("0"));
    }

    public static void main(String[] args) {
         System.out.println(new code93().restoreIpAddresses("25525511135"));

    }

}
