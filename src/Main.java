import SwordOffer.deleteDuplicationLinkedList;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import jjjava.ThreadPool;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.PRIVATE_MEMBER;
import share.TreeNode;
import sun.reflect.generics.tree.Tree;

import javax.print.attribute.EnumSyntax;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 题目：
 * 描述:
 * 例如，
 * 思路：
 */
public class Main {
    static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        //不断的分割
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    static void merge(int[] array, int low, int mid, int high) {
        int[] copy = array.clone();
        int i = low, left = low, right = mid + 1;
        while (i <= high) {
            if (left > mid) {
                array[i++] = copy[right++];
            } else if (right > high) {
                array[i++] = copy[left++];
            } else if (copy[left] < copy[right]) {
                array[i++] = copy[left++];
            } else {
                array[i++] = copy[right++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 9, 4, 5, 6, 8, 7, 0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

