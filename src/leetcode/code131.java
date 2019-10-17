package leetcode;

import java.util.ArrayList;
import java.util.List;

public class code131 {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(new ArrayList<String>(),s);
        return result;
    }

    private void backtrack(List<String> temp, String remain) {
        if(remain.isEmpty())
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < remain.length(); i++) {
            String s = remain.substring(0, i + 1);
            if (isValid(s)) {
                temp.add(s);
                backtrack(temp,remain.substring(i + 1));
                temp.remove(temp.size()-1);
            }
        }

    }

    private boolean isValid(String s) {
        int i = 0;
        int j = s.length()-1;
        while( i < j)
        {
            if(s.charAt(i)!= s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new code131().partition("aabbc"));
    }

}
