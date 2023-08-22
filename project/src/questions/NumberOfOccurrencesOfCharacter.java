package questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 复制
 * 输出：
 * 2
 */
public class NumberOfOccurrencesOfCharacter {
    public static void main(String[] args) {
        System.out.println("输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("请输入查找的字符：");
        String s = scanner.nextLine();
        //输出
        List<String> collect = Arrays.asList(line.toLowerCase().split("")).stream().filter(o -> s.toLowerCase().equals(o)).collect(Collectors.toList());
        System.out.println("输出：" + collect.size());
    }
}
