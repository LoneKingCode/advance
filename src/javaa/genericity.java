package javaa;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 8:22 2019/11/4
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class genericity {
    public static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 0; i < values.length; i++) {
            min = min.compareTo(values[i]) > 0 ? values[i] : min;
        }
        return min;
    }

    public static void main(String[] args) {
        Integer[] arr= {1,5,6,4,-4,32};
        System.out.println(min(arr));
    }
}
