package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
public class CombinedArea {

    public static void main(String[] args) {
        CombinedArea combinedArea = new CombinedArea();
        int[][] array = new int[][] {
                {15,18},{1,3},{2,6}, {8,10}
//                {4,5},{1,4}
        };
        int[][] merge = combinedArea.merge(array);
        IntStream.range(0, merge.length).forEach(o -> {
            System.out.println("结果：" + merge[o][0] + "," + merge[o][1]);
        });

    }
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        int[][] array = handle(intervals);

        return array;
    }

    private int[][] handle(int[][] nums) {

        boolean digui = false;
        List<int[]> arr = new ArrayList<>();
        //添加到list中
        IntStream.range(0, nums.length).forEach(o -> {
            arr.add(nums[o]);
        });
        for (int j=0;j<nums.length;j++) {
            for (int k=j+1;k<nums.length;k++) {
                int[] arr1 = nums[j];
                int[] arr2 = nums[k];

                int[] newArr;
                if ((arr1[0] >= arr2[0] && arr1[0] <= arr2[1])) {
                    digui = true;
                    if (arr1[1] > arr2[1]) {
                        newArr = new int[] {arr2[0], arr1[1]};
                        arr.remove(arr1);arr.remove(arr2);arr.add(newArr);
                    } else {
                        newArr = new int[] {arr2[0], arr2[1]};
                        arr.remove(arr1);arr.remove(arr2);arr.add(newArr);
                    }
                    return quchong(arr, digui);
                } else if ((arr2[0] >= arr1[0] && arr2[0] <= arr1[1])) {
                    digui = true;
                    if (arr1[1] > arr2[1]) {
                        newArr = new int[] {arr1[0], arr1[1]};
                        arr.remove(arr1);arr.remove(arr2);arr.add(newArr);
                    } else {
                        newArr = new int[] {arr1[0], arr2[1]};
                        arr.remove(arr1);arr.remove(arr2);arr.add(newArr);
                    }
                    return quchong(arr, digui);
                }

            }

        }

        return quchong(arr, false);
    }

    private int[][] quchong(List<int[]> arr, boolean digui) {
        //去重
        Set<int[]> set = new HashSet<>(arr);
        List<int[]> newNums = new ArrayList<>(set);
        //转二维数组
        int[][] new2Nums = new int[newNums.size()][2];
        for (int l=0;l<newNums.size();l++) {
            new2Nums[l][0] = newNums.get(l)[0];
            new2Nums[l][1] = newNums.get(l)[1];
        }
        if (digui) {
            return handle(new2Nums);
        } else {
            return new2Nums;
        }

    }
}
