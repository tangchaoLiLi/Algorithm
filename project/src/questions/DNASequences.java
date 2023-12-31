package questions;

import java.util.*;
import java.util.regex.*;

/**
 * HJ63 DNA序列
 * 题目
 * 题解(310)
 * 讨论(457)
 * 排行
 * 面经new
 * 中等  通过率：40.10%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
 *
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
 * DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
 *
 * 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
 * 输入描述：
 * 输入一个string型基因序列，和int型子串的长度
 *
 * 输出描述：
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 *
 * 示例1
 * 输入：
 * ACGT
 * 2
 * 复制
 * 输出：
 * CG
 * 复制
 * 说明：
 * ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5，CG为1，故输出CG
 * 示例2
 * 输入：
 * AACTGTGCACGACCTGA
 * 5
 * 复制
 * 输出：
 * GCACG
 * 复制
 * 说明：
 * 虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。
 */
public class DNASequences {
    public static void main(String[] args) {
        String[] arrs = {
                "ACGT 2",
                "AACTGTGCACGACCTGA 5"
        };
        int i=0;
        while (i < arrs.length) {
            String s = arrs[i];
            String regex = "[\\s]+";
            Pattern pattern = Pattern.compile(regex);
            String[] strings = pattern.split(s);
            int len = Integer.valueOf(strings[1]);

            float ratio = 0.0f;
            String res = "";
            for (int j=0;j<strings[0].length() - len + 1;j++) {
                String substring = strings[0].substring(j, j + len);
                int count = 0;
                for (char ch : substring.toCharArray()) {
                    if (ch == 'C' || ch == 'G') {
                        count++;
                    }
                }
                float ratio_local = (float) count / substring.length();
                if (ratio_local > ratio) {
                    ratio = ratio_local;
                    res = substring;
                }
            }
            //输出
            System.out.println("结果：" + res);
            i++;
        }
    }
}
