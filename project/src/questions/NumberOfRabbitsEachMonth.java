package questions;

/**
 * HJ37 统计每个月兔子的总数
 * 题目
 * 题解(480)
 * 讨论(750)
 * 排行
 * 面经new
 * 简单  通过率：43.77%  时间限制：1秒  空间限制：32M
 * 知识点
 * 查找
 * 排序
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
 * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
 * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 * 数据范围：输入满足 1 \le n \le 31 \1≤n≤31
 * 输入描述：
 * 输入一个int型整数表示第n个月
 *
 * 输出描述：
 * 输出对应的兔子总数
 *
 * 示例1
 * 输入：
 * 3
 * 复制
 * 输出：
 * 2
 */
public class NumberOfRabbitsEachMonth {
    public static void main(String[] args) {
        /**
         * 1 --- 1
         * 2 --- 1
         * 3 --- 2
         * 4 --- 3
         * 5 --- 5
         * 6 --- 8
         * 斐波那契数列
         */
        int n = 6;
        for (int i=1;i<=6;i++) {
            System.out.println("结果： " + fibonaqi(i));
        }
    }
    /**
     * 斐波那契数列计算
     *
     */
    public static int fibonaqi (int n) {
        int res = 0;
        if (n <= 2) {
            return 1;
        }
        res = fibonaqi(n - 1) + fibonaqi(n - 2);
        return res;
    }
}
