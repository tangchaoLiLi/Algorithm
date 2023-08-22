package questions;

import java.util.*;
import java.util.regex.*;

/**
 * HJ57 高精度整数加法
 * 题目
 * 题解(288)
 * 讨论(363)
 * 排行
 * 面经new
 * 中等  通过率：36.81%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 *
 * 数据范围： 1 \le len(str) \le 10000 \1≤len(str)≤10000
 * 输入描述：
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 *
 * 输出描述：
 * 输出求和后的结果
 *
 * 示例1
 * 输入：
 * 9876543210
 * 1234567890
 * 复制
 * 输出：
 * 11111111100
 */
public class HighPrecisionIntegerAddition {
    public static void main(String[] args) {
        String[] strings = {
                "9876543210",
                "1234567890"
        };

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = strings[0].length() - 1, j = strings[1].length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int num1 = i >= 0 ? Character.getNumericValue(strings[0].charAt(i)) : 0;
            int num2 = j >= 0 ? Character.getNumericValue(strings[1].charAt(j)) : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        String sumStr = sb.reverse().toString();
        System.out.println("sum: " + sumStr);
    }
}
