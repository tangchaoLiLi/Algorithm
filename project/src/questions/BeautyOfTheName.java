package questions;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

/**
 * HJ45 名字的漂亮度
 * 题目
 * 题解(395)
 * 讨论(537)
 * 排行
 * 面经new
 * 中等  通过率：43.09%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 贪心
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 给出一个字符串，该字符串仅由小写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个字符串，计算每个字符串最大可能的“漂亮度”。
 *
 * 本题含有多组数据。
 *
 * 数据范围：输入的名字长度满足 1 \le n \le 10000 \1≤n≤10000
 *
 * 输入描述：
 * 第一行一个整数N，接下来N行每行一个字符串
 *
 * 输出描述：
 * 每个字符串可能的最大漂亮程度
 *
 * 示例1
 * 输入：
 * 2
 * zhangsan
 * lisi
 * 复制
 * 输出：
 * 192
 * 101
 * 复制
 * 说明：
 * 对于样例lisi，让i的漂亮度为26，l的漂亮度为25，s的漂亮度为24，lisi的漂亮度为25+26+24+26=101.
 */
public class BeautyOfTheName {
    public static void main(String[] args) {
        String[]  arr = {
            "zhangsan", "lisi"
        };

        List<String> list = Arrays.asList(arr);
        int n=0;
        while (n<list.size()) {
            String s = list.get(n);
            String[] split = s.split("");
            Set<String> set = new HashSet<>(){
                {
                    addAll(Arrays.asList(split));
                }
            };
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String s1 : set) {
                int num = 0;
                for (int i=0;i<s.length();i++) {
                    if (s1.equals("" + s.charAt(i))) {
                        num++;
                    }
                }
                map.put(s1, num);
            }
            //计算漂亮度
            int total = 0;
            List<Map.Entry<String, Integer>> collect = map.entrySet().stream().collect(Collectors.toList());
            Collections.sort(collect, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            Iterator<Map.Entry<String, Integer>> iterator = collect.iterator();
            int mei = 26;
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> next = iterator.next();
                total += mei-- * next.getValue();
            }
            //输出
            System.out.println(total);
            n++;
        }
    }
}
