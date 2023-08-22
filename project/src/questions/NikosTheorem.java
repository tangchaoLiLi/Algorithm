package questions;

import java.util.*;
import java.util.regex.*;

/**
 * HJ76 尼科彻斯定理
 * 题目
 * 题解(381)
 * 讨论(574)
 * 排行
 * 简单  通过率：48.21%  时间限制：1秒  空间限制：32M
 * 知识点
 * 基础数学
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1\le m\le 100\1≤m≤100
 * 进阶：时间复杂度：O(m)\O(m) ，空间复杂度：O(1)\O(1)
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出分解后的string
 *
 * 示例1
 * 输入：
 * 6
 * 复制
 * 输出：
 * 31+33+35+37+39+41
 */
public class NikosTheorem {
    public static void main(String[] args) {
        int n = 7;
        int value = (int)Math.pow(n, 3);
        int avg = value / n;
        int first = avg - (n - 1);
        List<Integer> list = new ArrayList<>();
        list.add(first);
        for (int i=1;i<n;i++) {
            list.add(first += 2);
        }
        //输出结果
        list.stream().forEach(o -> {
            System.out.print(String.format("%-5d", o));
        });
        System.out.println();
    }
}
