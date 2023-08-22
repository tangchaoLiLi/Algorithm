package questions;
import test.DFS;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * 给出一列数组，选出三个数的和，与目标数最接近的一组
 * [-1,2,1,-4] --- 1
 * 输出：(-1 + 2 + 1 = 2)
 */
public class SumOfTheThreeClosestNumbers {
    public static void main(String[] args) {
        int[] array = {-1,2,1,-4};
        int target = 1;
        List<int[]> list = new ArrayList<>();

        handle(array, 0, list);

        Integer integer = list.stream().map(item -> Arrays.stream(item).sum()).reduce((a, b) -> Math.abs(a - target) > Math.abs(b - target) ? b : a).orElse(-1001);
        System.out.println("最小三数之和的结果：" + integer);
    }

    public static void handle(int[] array, int n, List<int[]> list) {
        if (n == array.length) {
            int[] ints = Arrays.stream(Arrays.copyOf(array, 3)).toArray();
            boolean had = list.stream().anyMatch(arr -> arr[0] == ints[0] && arr[1] == ints[1] && arr[2] == ints[2]);
            if (!had) list.add(ints);
            return;
        }

        for (int i=n;i<array.length;i++) {
            if (DFS.isSwap(array, n, i)) {
                DFS.swap(array, n, i);
                handle(array, n+1, list);
                DFS.swap(array, n, i);
            }
        }
    }
}
