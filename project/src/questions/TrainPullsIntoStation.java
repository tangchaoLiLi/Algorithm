package questions;

import test.DFS;

import java.util.*;
import java.util.regex.*;

/**
 * HJ77 火车进站
 * 题目
 * 题解(143)
 * 讨论(203)
 * 排行
 * 面经new
 * 中等  通过率：44.89%  时间限制：1秒  空间限制：32M
 * 知识点
 * 栈
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 数据范围：1\le n\le 10\1≤n≤10
 * 进阶：时间复杂度：O(n!)\O(n!) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 *
 * 输出描述：
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 *
 * 示例1
 * 输入：
 * 3
 * 1 2 3
 * 复制
 * 输出：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 复制
 * 说明：
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class TrainPullsIntoStation extends DFS {
    public static void main(String[] args) {
        l.clear(); //静态变量，每次先清空
        int nums = 3;
        int[] id = new int[nums];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums; i++) {
            id[i] = i + 1;
        }
        trainOut(id, 0, stack, "", 0);
        //对结果集排序
        Collections.sort(l);
        //输出全排列个数
        l.stream().forEach(o -> {
            System.out.println("结果：" + o);
        });
        System.out.println("组合结果：" + l.size());
    }

    /**
     * 1+、1-、2+、2-、3+、3-
     * 1+、1-、2+、3+、3-、2-
     * 1+、2+、2-、1-、3+、3-
     * 1+、2+、3+、3-、2-、1-
     * 1+、2+、2-、3+、3-、1-
     */
    public static void trainOut(int[] id, int i, Stack<Integer> s, String str, int n) {
        if (n == id.length) {
            l.add(str); //如果所有火车均出栈则将当前结果保存
        }

        if (!s.empty()) { //栈非空时出栈
            int temp = s.pop();
            trainOut(id, i, s, str + temp + " ", n + 1);
            s.push(temp); //恢复现场
        }

        if (i < id.length) {
            s.push(id[i]);
            trainOut(id, i + 1, s, str + id[i] + " ", n);
            s.pop(); //恢复现场

        }
    }

    static List<String> l = new ArrayList<>(); //储存结果
}
