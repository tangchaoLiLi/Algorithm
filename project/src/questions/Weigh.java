package questions;

import java.util.*;
/**
 * HJ41 称砝码
 * 题目
 * 题解(263)
 * 讨论(297)
 * 排行
 * 面经new
 * 中等  通过率：34.83%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 哈希
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 *
 * 注：
 *
 * 称重重量包括 0
 *
 * 数据范围：每组输入数据满足 1 \le n \le 10 \1≤n≤10  ， 1 \le m_i \le 2000 \1≤m
 * i
 * ​
 *  ≤2000  ， 1 \le x_i \le 10 \1≤x
 * i
 * ​
 *  ≤10
 * 输入描述：
 * 对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 * 输出描述：
 * 利用给定的砝码可以称出的不同的重量数
 *
 * 示例1
 * 输入：
 * 2
 * 1 2
 * 2 1
 * 复制
 * 输出：
 * 5
 * 复制
 * 说明：
 * 可以表示出0，1，2，3，4五种重量。
 */
public class Weigh {
    public static void main(String[] args) {
        int t1=1,t2=2;
        int n1=2,n2=1;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<=n1;i++) {
            for (int j=0;j<=n2;j++) {
                int weight = i * t1 + j * t2;
                set.add(weight);
            }
        }
        //输出
//        set.stream().forEach(o-> {System.out.print(o + " ");});
        System.out.println(set.size());
    }
}
