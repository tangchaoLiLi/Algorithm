package questions;

import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * abc00000
 */
public class StringSeparation {
    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String res = "";
        for (int i=0;i<line.length();i++) {
            res += line.charAt(i);
            if ((i + 1) % 8 == 0) {
                res += " ";
            }
        }
        if (line.length() % 8 != 0) {
            int end = line.length() % 8;
            for (int j=0;j<8-end;j++) {
                res += '0';
            }
        }
        //输出
        System.out.println("输出：" + res);
    }
}
