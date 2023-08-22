package questions;

import java.util.*;

/**
 * 描述
 * 对输入的字符串进行加解密，并输出。
 *
 * 加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 解密方法为加密的逆过程。
 * 数据范围：输入的两个字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，保证输入的字符串都是只由大小写字母或者数字组成
 * 输入描述：
 * 第一行输入一串要加密的密码
 * 第二行输入一串加过密的密码
 *
 * 输出描述：
 * 第一行输出加密后的字符
 * 第二行输出解密后的字符
 *
 * 示例1
 * 输入：
 * abcdefg
 * BCDEFGH
 * 复制
 * 输出：
 * BCDEFGH
 * abcdefg
 */
public class StringEncryptionAndDecryption {
    private static Map<Character, Character> preMap = new HashMap<>();
    private static Map<Character, Character> afterMap = new HashMap<>();
    static {
        //0-9数字
        for (char i='0';i<'9';i++) {
            preMap.put(i, (char) (i+1));
            afterMap.put((char)(i+1), i);
        }
        //数字9转0
        preMap.put('9', '0');
        afterMap.put('0', '9');
        //a-z字母
        for (char j='a';j<'z';j++) {
            preMap.put(j, (char)(j+1-32));
            afterMap.put((char)(j+1-32), j);
        }
        preMap.put('z', 'A');
        afterMap.put('A', 'z');
        //字母A-Z
        for (char k='A';k<'Z';k++) {
            preMap.put(k, (char)(k+1+32));
            afterMap.put((char)(k+1+32), k);
        }
        preMap.put('Z', 'a');
        afterMap.put('a', 'Z');
    }
    public static void main(String[] args) {
        System.out.println("输入：");
        List<String> list = new ArrayList<>(){
            {
                add("abcdefg");
            }
        };
        for (int i=0;i<list.size();i++) {
            String s = secretHandle(list.get(i), true);
            System.out.println("结果：" + s);
            System.out.println("结果：" + secretHandle(s, false));
        }
    }
    /**
     * 加密和解密
     * @param str
     * @param b
     */
    public static String secretHandle(String str, boolean b) {
        String res = "";
        for (int i=0;i<str.length();i++) {
            char c;
            if (b) {
                c = preMap.get(str.charAt(i));
            } else {
                c = afterMap.get(str.charAt(i));
            }
            res += c;
        }
        return res;
    }
}
