package questions;

import java.util.Scanner;

/**
 * 实现字符的倒序
 * 字符串长度：1<=|en<=10000
 * 输入一个字符串，可以有空格
 */
public class CharacterReverseOrder {
    public static void main(String[] args) {
        System.out.println("请输入需要倒序排列的字符串：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] a;
        char[] b = new char[10000];
        //计算并存储倒序数组
        a = line.toCharArray();
        String res = "";
        for (int i=a.length - 1;i>=0;i--) {
            res += a[i];
        }
        //输出倒序后的字符串
        System.out.println("倒序后的字符串为：\n" + res);
    }
}
