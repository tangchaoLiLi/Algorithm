package questions;

/**
 * 描述
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 *
 * 输出描述：
 * 输出密码变换后的字符串
 *
 * 示例1
 * 输入：
 * YUANzhi1987
 * 复制
 * 输出：
 * zvbo9441987
 */
public class SimpleCipher {
    public static void main(String[] args) {
        String str = "YUANzhi1987";
        String res = "";
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (chars[i] == '1') {
                res += '1';
            }
            if (chars[i] == 'a' || chars[i] == 'b' || chars[i] == 'c') {
                res += '2';
            }
            if (chars[i] == 'd' || chars[i] == 'e' || chars[i] == 'f') {
                res += '3';
            }
            if (chars[i] == 'g' || chars[i] == 'h' || chars[i] == 'i') {
                res += '4';
            }
            if (chars[i] == 'j' || chars[i] == 'k' || chars[i] == 'l') {
                res += '5';
            }
            if (chars[i] == 'm' || chars[i] == 'n' || chars[i] == 'o') {
                res += '6';
            }
            if (chars[i] == 'p' || chars[i] == 'q' || chars[i] == 'r' || chars[i] == 's') {
                res += '7';
            }
            if (chars[i] == 't' || chars[i] == 'u' || chars[i] == 'v') {
                res += '8';
            }
            if (chars[i] == 'w' || chars[i] == 'x' || chars[i] == 'y' || chars[i] == 'z') {
                res += '9';
            }
            if (chars[i] == '0') {
                res += '0';
            }
            if (chars[i] >= 'A' && chars[i] <= 'Y') {
                res += (chars[i] += 33);
            }
            if (chars[i] == 'Z') {
                res += 'a';
            }
            if (chars[i] >= '2' && chars[i] <= '9') {
                res += chars[i];
            }
        }
        //输出
        System.out.println("结果：" + res);
    }
}
