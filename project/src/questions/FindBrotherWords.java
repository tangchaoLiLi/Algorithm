package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 *
 * 数据范围：1 \le n \le 1000 \1≤n≤1000 ，输入的字符串长度满足 1 \le len(str) \le 10 \1≤len(str)≤10  ， 1 \le k < n \1≤k<n
 * 输入描述：
 * 输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
 * 输出描述：
 * 第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入：
 * 3 abc bca cab abc 1
 * 复制
 * 输出：
 * 2
 * bca
 * 复制
 * 示例2
 * 输入：
 * 6 cab ad abcd cba abc bca abc 1
 * 复制
 * 输出：
 * 3
 * bca
 * 复制
 * 说明：
 * abc的兄弟单词有cab cba bca，所以输出3
 * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
 */
public class FindBrotherWords {
    public static void main(String[] args) {
        String s1 = "3 abc bca cab abc 1";
        String s2 = "6 cab ad abcd cba abc bca abc 1";
        List<String> list = new ArrayList<>() {
            {
                add(s1);
                add(s2);
            }
        };
        int i = 0;
        while (i < list.size()) {
            String s = list.get(i++);
            String[] s3 = s.split(" ");
            List<String> ll = new CopyOnWriteArrayList<>();
            //匹配的字符串
            String s4 = s3[s3.length - 2];
            String[] chars = s4.split("");
            List<String> zuhe = new ArrayList<>();
            //输出所有组合
            for (int o=0;o<chars.length;o++) {
                for (int p=0;p<chars.length;p++) {
                    for (int u=0;u<chars.length;u++) {
                        if (o != p && o != u && p != u) {
                            String newStr = "" + chars[o] + chars[p] + chars[u];
                            zuhe.add(newStr);
                        }
                    }
                }
            }
            int xiabiao = Integer.valueOf(s3[s3.length - 1]);
            int n = 0;
            do {
                if (n == 0 || n == s3.length - 1 || n == s3.length - 2) {
                    n++;
                    continue;
                }
                ll.add(s3[n]);
                n++;
            } while (n < s3.length);
            //遍历列表中元素
            int count = 0;
            Iterator<String> iterator = ll.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (zuhe.contains(next) && !next.equals(s3[s3.length - 2])) {
                    count ++;
                } else {
                    ll.remove(next);
                }
            }
            //输出
            Collections.sort(ll);
            System.out.println("结果：" + count + " " + ll.get(xiabiao - 1));
        }
    }
}
