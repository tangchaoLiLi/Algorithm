package questions;

/**
 * HJ15 求int型正整数在内存中存储时1的个数
 * 题目
 * 题解(739)
 * 讨论(1k)
 * 排行
 * 面经new
 * 简单  通过率：59.22%  时间限制：1秒  空间限制：32M
 * 知识点
 * 位运算
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：
 * 5
 * 复制
 * 输出：
 * 2
 * 复制
 * 示例2
 * 输入：
 * 0
 * 复制
 * 输出：
 * 0
 */
public class TheNumberOfPositiveIntegersOne {
    public static void main(String[] args) {
        String[] ss = {
                "5"
        };
        for ( int i=0;i<ss.length;i++) {
            String s = ss[i];
            String binary = Integer.toBinaryString(Integer.valueOf(s));
            int j=0, total = 0;
            do {
                if (binary.charAt(j++) == '1') {
                    total++;
                }
            } while (j < binary.length());
            System.out.println("" + total);
        }
    }
}
