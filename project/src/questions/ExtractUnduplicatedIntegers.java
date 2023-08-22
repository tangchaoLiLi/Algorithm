package questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围： 1 \le n \le 10^{8} \1≤n≤10
 * 8
 *
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673
 * 复制
 * 输出：
 * 37689
 */
public class ExtractUnduplicatedIntegers {
    public static void main(String[] args) {
        System.out.println("请输入整数：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
        String[] strings = str.split("");
        List<String> strings1 = Arrays.asList(strings);
        List<String> collect = strings1.stream().distinct().collect(Collectors.toList());
        String res = "";
        for (int i=0;i<collect.size();i++) {
            res += collect.get(i);
        }
        System.out.println("输出：" + res);
    }
}
