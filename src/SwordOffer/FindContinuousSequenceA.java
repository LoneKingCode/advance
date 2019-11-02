package SwordOffer;

import java.util.ArrayList;

public class FindContinuousSequenceA {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int i = 1;
        int count = 0;
        int currentSum = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i < sum) {
            currentSum += i;
            temp.add(i);
            i++;
            if (sum == currentSum || currentSum > sum) {
                if (sum == currentSum) {
                    result.add(new ArrayList<>(temp));
                    temp = new ArrayList<>();
                }
                count++;
                i = 1 + count;
                currentSum = 0;
                temp = new ArrayList<>();
            }


        }
        return result;
    }


    public static void main(String[] args) {
        new FindContinuousSequenceA().FindContinuousSequence(9);
    }

}
