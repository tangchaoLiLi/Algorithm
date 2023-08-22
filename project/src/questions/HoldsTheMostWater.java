package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
/**
 * 计算出盛最多水的两个刻度值
 */
public class HoldsTheMostWater {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        List<int[]> list = new ArrayList<>();

        handleWater(arr, 0, list);

        list.stream().forEach(o -> {
            System.out.println("结果：" + o[0] + "," + o[1]);
        });
        System.out.println("一共有结果数量：" + list.size());
        //计算出容量最多的一组
        int[] ints = list.stream().max((a, b) -> (a[1] - a[0]) * (arr[a[1] - 1] > arr[a[0] - 1] ? arr[a[0] - 1] : arr[a[1] - 1]) - (b[1] - b[0]) * (arr[b[1] - 1] > arr[b[0] - 1] ? arr[b[0] - 1] : arr[b[1] - 1])).orElse(null);
        System.out.println("容量最多的结果：" + ints[0] + "," + ints[1] + ", 容积为：" + ((ints[1] - ints[0]) * (arr[ints[1] - 1] > arr[ints[0] - 1] ? arr[ints[0] - 1] : arr[ints[1] - 1])));
    }

    public static void handleWater(int[] arr, int n, List<int[]> list) {
        if (n == arr.length) {
//            Arrays.copyOf(arr, )
            return;
        }
        for (int i=n;i<arr.length;i++) {
            list.add(new int[]{n+1, i+1});
        }
        handleWater(arr, n+1, list);
    }
}
