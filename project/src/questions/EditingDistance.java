package questions;

/**
 * HJ52 计算字符串的编辑距离
 * 题目
 * 题解(172)
 * 讨论(202)
 * 排行
 * 面经new
 * 中等  通过率：33.62%  时间限制：1秒  空间限制：256M
 * 知识点
 * 字符串
 * 动态规划
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
 *
 * 例如：
 *
 * 字符串A: abcdefg
 *
 * 字符串B: abcdef
 *
 * 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 *
 * 要求：
 *
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 *
 *
 * 数据范围：给定的字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
 *
 *
 * 输入描述：
 * 每组用例一共2行，为输入的两个字符串
 *
 * 输出描述：
 * 每组用例输出一行，代表字符串的距离
 *
 * 示例1
 * 输入：
 * abcdefg
 * abcdef
 * 复制
 * 输出：
 * 1
 */
public class EditingDistance {
    public static void main(String[] args) {
        String[] strings = {
                "awcdefg",
                "abcdefwerwrwe"
        };
        String s1 = strings[0];
        String s2 = strings[1];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length = chars2.length > chars1.length ? chars1.length : chars2.length, count = Math.abs(chars2.length - chars1.length);

        for (int i=0;i<length;i++) {
            if (chars2[i] != chars1[i]) {
                count++;
            }
        }
        //输出
        System.out.println("编辑距离为：" + count);
    }
}
