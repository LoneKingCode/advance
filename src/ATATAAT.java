import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * 题目：DNA
 * 描述:
 * 有一种特殊的DNA，仅仅由核酸A和T组成，长度为n，顺次连接
 * 科学家有一种新的手段，可以改变这种DNA。每一次，科学家可以交换该DNA上两个核酸的位置，也可以将某个特定位置的核酸修改为另一种核酸。
 * 现在有一个DNA，科学家希望将其改造成另一种DNA，希望你计算最少的操作次数。
 * 例如，
 * 样例输入
 * ATTTAA
 * TTAATT
 * 样例输出
 * 3
 * 思路：
 * 1.先对比输入的字符串，找到不同的位置并记录
 * 2.暴力尝试
 */
public class ATATAAT {
    public int min = 0x7fffffff;
    List<Integer> pos;
    boolean[] usedPos;

    public int dna(String a, String b) {
        if (a.isEmpty() || b.isEmpty() || Objects.equals(a, b) || a.length() != b.length()) {
            return 0;
        }
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        pos = new ArrayList<Integer>();
        //记录不同的位置
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                pos.add(i);
            }
        }
        usedPos = new boolean[a.length()];
        trySwap(A, B, 0, 0, pos.size());
        return min;
    }

    public void trySwap(char[] A, char[] B, int replace, int count, int remainPos) {
        if (String.valueOf(A).equals(String.valueOf(B))) {
            if (count < min) {
                min = count;
            }
            return;
        }
        if (replace == usedPos.length || remainPos < 1) {
            return;
        }
        for (int i = 0; i < pos.size(); i++) {
            int p = pos.get(i);
            if (!usedPos[p]) {
                usedPos[p] = true;
                //两两交换 偶数个数时才交换
                if (remainPos >= 2 && remainPos % 2 == 0) {
                    boolean hasSwap = false;
                    //找下一个需要交换的
                    for (Integer x : pos) {
                        if (!usedPos[x] && B[p] != B[x]) {
                            usedPos[x] = true;
                            hasSwap = true;
                            swap(B, p, x);
                            trySwap(A, B, replace, count + 1, remainPos - 2);
                        }
                    }
                    //如果没交换出来 那还是得替换
                    if (!hasSwap) {
                        B[p] = getChar(B[p]);
                        trySwap(A, B, replace + 1, count + 1, remainPos - 1);
                    }

                } else {
                    //替换
                    B[p] = getChar(B[p]);
                    trySwap(A, B, replace + 1, count + 1, remainPos - 1);
                }
            }
        }
    }

    public char getChar(char c) {
        return c == 'A' ? 'T' : 'A';
    }

    public void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String a = "ATATAAT", b = "ATATAAA";
        while (cin.hasNextLine()) {
            a = cin.nextLine();
            b = cin.nextLine();
        }
        System.out.println(new ATATAAT().dna(a, b));
    }
}

