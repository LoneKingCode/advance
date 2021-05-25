package old.SwordOffer;

/**
 * 题目：
 * 描述:
 * 例如，
 * 思路：
 */
public class longestSubstring {
    public static int longestSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        int currLength = 0;
        //26个字母
        int[] pos = new int[26];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }
        int maxContainsA=0;
        for (int i = 0; i < str.length(); i++) {
              char c = str.charAt(i);
              int letterIndex = pos[c - 'a'];
              int distance = i - letterIndex;
              if (letterIndex < 0 || distance > currLength) {
                   currLength++;
            } else {
                if (currLength > maxLength) {
                    maxLength = currLength;
                }
                currLength = distance;
            }
            //更新字母出现的位置
            pos[c - 'a'] = i;
        }
        return maxLength > currLength ? maxLength : currLength;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(longestSubstring("csdfabsadfg"));
    }
}
