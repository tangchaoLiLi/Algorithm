package questions;

import test.DFS;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
/**
 * 对数组中的元素，超过3个，选出3个全排
 */
public class SanShuZhiHe {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<int[]> list = new ArrayList<>();

        handle(arr, 0, list);

        List<int[]> ints = list.stream().distinct().filter(o -> 0 == o[0] + o[1] + o[2]).toList();
        ints.stream().forEach(o -> {
            System.out.println("结果：" + o[0] + "," + o[1] + "," + o[2]);
        });
        System.out.println("结果：");
    }

    public static void handle(int[] arr, int n, List<int[]> list) {
        if (n == arr.length) {
            //排序
            int[] ints = Arrays.stream(Arrays.copyOf(arr, 3)).sorted().toArray();
            boolean match = list.stream().anyMatch(o -> ints[0] == o[0] && ints[1] == o[1] && ints[2] == o[2]);
            if (!match) {
                list.add(ints);
            }
            return;
        }

        for (int i=n;i<arr.length;i++) {
            if (DFS.isSwap(arr, n, i)) {
                DFS.swap(arr, n, i);
                handle(arr, n+1, list);
                DFS.swap(arr, n, i);
            }
        }
    }

}
