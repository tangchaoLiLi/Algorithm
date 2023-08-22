package questions;

import java.util.*;
import java.util.regex.*;

/**
 * HJ71 字符串通配符
 * 题目
 * 题解(176)
 * 讨论(280)
 * 排行
 * 面经new
 * 中等  通过率：23.52%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 *
 * 注意：匹配时不区分大小写。
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 *
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 数据范围：字符串长度：1\le s\le 100\1≤s≤100
 * 进阶：时间复杂度：O(n^2)\O(n
 * 2
 *  ) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 *
 * 示例1
 * 输入：
 * te?t*.*
 * txt12.xls
 * 复制
 * 输出：
 * false
 */
public class CharacterStringWildcard {
    public static void main(String[] args) {
//        String str1 = "te?t*.*"; //通配符
//        String str2 = "tExt12.xls"; //需要匹配的字符串
        String str1 = "?*Bc*?";
        String str2 = "abcd";

        //分解通配符字符串，用Pattern的通配符取代
        String regex= "";
        for (int i=0;i<str1.length();i++) {
            char c = str1.charAt(i);
            if ((c >= 'a' && c < 'z') || (c >= 'A' && c <= 'Z')) {
                String ch = "", ch2 = "";
                char c1 = 0, c2 = 0;
                if (c >= 'a' && c < 'z') {
                    c1 = (char) (c - 32);
                    c2 = c;
                }
                if (c >= 'A' && c <= 'Z') {
                    c1 = c;
                    c2 = (char) (c + 32);
                }
                regex += "[" + c1 + "" + c2 + "]";
                continue;
            }
            if (c == '?') {
                regex += "[a-zA-Z0-9]";
                continue;
            }
            if (c == '*') {
                regex += ".*";
                continue;
            }
            if (c == '.') {
                regex += "[\\\\.]";
                continue;
            }
            regex += ""+ c;
        }
//        regex += "$";
//        regex = "te[a-zA-Z0-9]*";
        System.out.println("结果：" + regex);
        //匹配
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str2);
        if (matcher.find()) {
            System.out.println("结果：" + matcher.group());
        }
    }
}
