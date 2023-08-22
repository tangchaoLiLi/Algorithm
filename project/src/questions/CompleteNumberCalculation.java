package questions;
import java.util.*;
import java.util.regex.*;

/**
 * HJ56 完全数计算
 * 题目
 * 题解(384)
 * 讨论(549)
 * 排行
 * 面经new
 * 简单  通过率：52.56%  时间限制：1秒  空间限制：32M
 * 知识点
 * 基础数学
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 * 输入n，请输出n以内(含n)完全数的个数。
 *
 * 数据范围： 1 \le n \le 5 \times 10^{5} \1≤n≤5×10
 * 5
 *
 * 输入描述：
 * 输入一个数字n
 *
 * 输出描述：
 * 输出不超过n的完全数的个数
 *
 * 示例1
 * 输入：
 * 1000
 * 复制
 * 输出：
 * 3
 */
public class CompleteNumberCalculation {
    public static void main(String[] args) {
        int n = 1000;
        for (int i=1;i<=n;i++) {
            List<Integer> list = getCompleteN(i);
            //使用reduce方法求和，求平均值
            Integer sum = list.stream().reduce(0, (a, b) -> a + b);
            if (sum == i) {
                System.out.println("结果：" + i);
            }
        }
    }
    /**
     * 找出n的所有约束，并添加到列表中
     *
     */
    public static List<Integer> getCompleteN(int n) {
        List<Integer> list = new LinkedList<>();
        if (n == 1) {
            return list;
        } else {
            for (int i=1;i<n;i++) {
                if (n % i == 0) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
