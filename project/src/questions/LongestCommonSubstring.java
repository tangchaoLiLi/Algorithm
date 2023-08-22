package questions;
import java.util.*;
import java.util.regex.*;

/**
 * HJ65 查找两个字符串a,b中的最长公共子串
 * 题目
 * 题解(303)
 * 讨论(421)
 * 排行
 * 面经new
 * 中等  通过率：34.10%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 *
 * 数据范围：字符串长度1\le length \le300 \1≤length≤300
 * 进阶：时间复杂度：O(n^3)\O(n
 * 3
 *  ) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个字符串
 *
 * 输出描述：
 * 返回重复出现的字符
 * 示例1
 * 输入：
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 复制
 * 输出：
 * jklmnop
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String[] strs = {
                "abcdefghijklmnop",
                "abcsafjklmnopqrstuvw"
        };
        int maxLength = 0;
        String maxSubString = "";
        String shortString = "", longString = "";
        if (strs[0].length() > strs[1].length()) {
            shortString = strs[1];
            longString = strs[0];
        } else {
            shortString = strs[0];
            longString = strs[1];
        }

        for (int i=0;i<=shortString.length();i++) {
            for (int j=i+1;j<=shortString.length();j++) {
                String substring = shortString.substring(i, j);
                int index = longString.indexOf(substring);
                if (index > 0) {
                    if (maxSubString.length() < substring.length() && maxLength < substring.length()) {
                        maxSubString = substring;
                        maxLength = substring.length();
                    }
                }
            }
        }
        //输出
        System.out.println("结果：" + maxSubString);
    }
}
