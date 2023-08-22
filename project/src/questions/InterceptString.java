package questions;

import java.util.*;
/**
 * HJ46 截取字符串
 * 题目
 * 题解(300)
 * 讨论(429)
 * 排行
 * 面经new
 * 入门  通过率：52.23%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 模拟
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 *
 * 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ， 1 \le k \le n \1≤k≤n
 * 输入描述：
 * 1.输入待截取的字符串
 *
 * 2.输入一个正整数k，代表截取的长度
 *
 * 输出描述：
 * 截取后的字符串
 *
 * 示例1
 * 输入：
 * abABCcDEF
 * 6
 * 复制
 * 输出：
 * abABCc
 * 复制
 * 示例2
 * 输入：
 * bdxPKBhih
 * 6
 * 复制
 * 输出：
 * bdxPKB
 */
public class InterceptString {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>() {
            {
                put("abABCcDEF", 6);
                put("bdxPKBhih", 6);
            }
        };
        //截取字符串
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println("结果：" + key.substring(0, value));
        }
    }
}
