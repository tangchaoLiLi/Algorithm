package questions;

import java.util.*;

/**
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，字符串长度满足 1 \le len \le 100 \1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 复制
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class StringSorting {
    public static void main(String[] args) {
        System.out.println("输入需要排序的字符串个数：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt(), n = 0;

        System.out.println("请输入字符串数组：");
        List<String> list = new ArrayList<>();
        while (n < i) {
            String line = scanner.nextLine();
            if ("".equals(line)) {
                continue;
            }
            list.add(line);
            n++;
        }
        //排序
        Collections.sort(list);
        String res = "";
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            res += next + "\n";
        }
        //输出
        System.out.println("输出：" + res);
    }
}
