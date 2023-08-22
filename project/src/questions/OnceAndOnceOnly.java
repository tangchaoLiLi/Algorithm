package questions;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * HJ59 找出字符串中第一个只出现一次的字符
 * 题目
 * 题解(345)
 * 讨论(589)
 * 排行
 * 面经new
 * 中等  通过率：32.85%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 找出字符串中第一个只出现一次的字符
 *
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 *
 *
 * 输入描述：
 * 输入一个非空字符串
 *
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 *
 * 示例1
 * 输入：
 * asdfasdfo
 *
 * 复制
 * 输出：
 * o
 */
public class OnceAndOnceOnly {
    public static void main(String[] args) {
        String str = "asdtfasdofo";
        List<Character> list = new LinkedList<>() {
            {
                for (char c : str.toCharArray()) {
                    if (c != 0) add(c);
                }
            }
        };

        Map<Character, List<Character>> collect = list.stream().collect(Collectors.groupingBy(Character::valueOf));
        List<Map.Entry<Character, List<Character>>> collect1 = new LinkedList<>();
        list.stream().forEach(o -> {
            Iterator<Map.Entry<Character, List<Character>>> iterator = collect.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, List<Character>> next = iterator.next();
                if (o == next.getKey()) {
                    collect1.add(next);
                }
            }

        });
        //输出
        List<Map.Entry<Character, List<Character>>> collect2 = collect1.stream().filter(o -> o.getValue().size() == 1).collect(Collectors.toList());
        if (collect2.size() == 0) {
            System.out.println("NULL!");
            return;
        }
        System.out.println("结果: " + collect2.get(0).getKey() );
    }
}
