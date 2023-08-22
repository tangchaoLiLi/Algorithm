package questions;

import java.util.HexFormat;
import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
 * 31
 *  −1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xAA
 * 复制
 * 输出：
 * 170
 */
public class BaseConversion {
    public static void main(String[] args) {
        System.out.println("请输入16进制的数字");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //使用Long.parseLong将字符串转数字
        long dec_num = Long.parseLong(line.substring(2, line.length()), 16);
        System.out.println("输出：" + dec_num);
    }
}
