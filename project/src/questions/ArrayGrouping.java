package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * HJ93 数组分组
 * 题目
 * 题解(163)
 * 讨论(270)
 * 排行
 * 面经new
 * 较难  通过率：27.59%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 递归
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
 *
 * 数据范围：每个数组大小满足 1 \le n \le 50 \1≤n≤50  ，输入的数据大小满足 |val| \le 500 \∣val∣≤500
 * 输入描述：
 * 第一行是数据个数，第二行是输入的数据
 *
 * 输出描述：
 * 返回true或者false
 *
 * 示例1
 * 输入：
 * 4
 * 1 5 -5 1
 * 复制
 * 输出：
 * true
 * 复制
 * 说明：
 * 第一组：5 -5 1
 * 第二组：1
 * 示例2
 * 输入：
 * 3
 * 3 5 8
 * 复制
 * 输出：
 * false
 * 复制
 * 说明：
 * 由于3和5不能放在同一组，所以不存在一种分法
 */
public class ArrayGrouping {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1 ,5 ,-5 ,1},
                {3 ,5 ,8},
                {3 ,4 ,5, 2, 0}
        };
        //判断
        for (int i=0;i<arr.length;i++) {
            int[] ints = arr[i];
            List<List<Integer>> lists = new ArrayList<>();
            //循环，截取长度为1到ints.length的数组
            //调用分组方法
            group(ints, 0, lists);
            //输出所有长度为 ints.length 的数组
            lists.stream().forEach(o -> {
                o.stream().forEach(p -> {
                    System.out.print("" + p + " ");
                });
                System.out.println();
            });
            //循环遍历每种情况
            boolean ok = false;
            for (int k=0;k<lists.size();k++) {
                List<Integer> list = lists.get(k);
                for (int j=0;j<=list.size()/2;j++) {
                    if (j == 0) {
                        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
                        if (sum == 0) {

                        }
                        continue;
                    }
                    List<Integer> last = new ArrayList<>(list.subList(0, j));
                    List<Integer> start = new ArrayList<>(list.subList(j, list.size()));
                    if ((last.contains(3) && last.contains(5)) || (start.contains(3) && start.contains(5))) {
                        continue;
                    }
                    //和是否相同
                    Integer a1 = last.stream().reduce(0, (a, b) -> a + b);
                    Integer a2 = start.stream().reduce(0, (a, b) -> a + b);
                    if (a1 == a2) {
                        ok = true;
                        System.out.println("结果：" + ok);
                        System.out.println("结果：" + start + " " + last);
                        break;
                    }
                }
                if (ok) break;
            }
            if (!ok) System.out.println("结果：" + false);
        }
    }
    /**
     * 使用递归，查找所有组合
     */
    public static void group(int[] arr, int n, List<List<Integer>> lists) {
        if (n == arr.length) {
            List<Integer> list = new ArrayList<>();
            IntStream.range(0, arr.length).forEach(o -> {
                list.add(arr[o]);
            });
            lists.add(list);
            return;
        }

        for (int i=n;i<arr.length;i++) {
            if (isCheck(arr, n, i)) {
                swap(arr, n, i);
                group(arr, n+1, lists);
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
