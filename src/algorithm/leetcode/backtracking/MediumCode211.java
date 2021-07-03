package algorithm.leetcode.backtracking;

import java.util.*;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * <p>
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : LoneKing
 * @Date : 2021/6/19
 */
public class MediumCode211 {
    static class WordDictionary {
        Map<Integer, Set<String>> data = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {

        }

        public void addWord(String word) {
            int length = word.length();
            Set<String> set = data.get(length);
            if (Objects.nonNull(set)) {
                set.add(word);
            } else {
                set = new HashSet<>();
                set.add(word);
                data.put(length, set);
            }
            if (length < minLength) {
                minLength = word.length();
            }
            if (length > maxLength) {
                maxLength = word.length();
            }
        }

        public boolean isEqual(String str, String word) {
            if (str.length() != word.length()) {
                return false;
            }
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    continue;
                }
                if (word.charAt(i) != str.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public boolean search(String word) {
            int length = word.length();
            if (Objects.isNull(word) || word.isEmpty()) {
                return false;
            }
            if (length < minLength || length > maxLength) {
                return false;
            }
            Set<String> set = data.get(length);
            if (Objects.isNull(set)) {
                return false;
            }
            if (!word.contains(".")) {
                return set.contains(word);
            }
            for (String str : set) {
                boolean result = isEqual(str, word);
                if (result) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        // return False
        System.out.println(wordDictionary.search("pad"));
        // return True
        System.out.println(wordDictionary.search("bad"));
        // return True
        System.out.println(wordDictionary.search(".ad"));
        // return True
        System.out.println(wordDictionary.search("b.."));

    }
}
