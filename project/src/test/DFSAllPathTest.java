package test;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class DFSAllPathTest {
    public static void main(String[] args) {
        int arr[] = new int[]{1000, 2000, 3000, 123321};
        List<String> list = new ArrayList<>();

        handle(arr, 0, list);

        list.stream().forEach(o -> {
            System.out.println("结果：" + o);
        });
    }

    public static void handle(int[] arr, int n, List<String> list) {
        if (n == arr.length) {
            String reduce = Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.toList()).stream().reduce("", (a, b) -> a + " " + b);
            list.add(reduce);
            return;
        }

        for (int i=n;i<arr.length;i++) {
            if (isCheck(arr, n, i)) {
                swap(arr, n, i);
                handle(arr, n+ 1, list);
                swap(arr, n, i);
            }
        }
    }

    public static boolean isCheck(int[] arr, int i, int j) {
        boolean flag = true;
        for (int k=i;k<j;k++) {
            if (arr[k] == arr[j]) {
                flag = false;
            }
        }
        return flag;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
