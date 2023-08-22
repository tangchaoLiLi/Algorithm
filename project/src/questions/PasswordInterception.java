package questions;

import java.util.*;

/**
 * 描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 数据范围：字符串长度满足 1 \le n \le 2500 \1≤n≤2500
 * 输入描述：
 * 输入一个字符串（字符串的长度不超过2500）
 *
 * 输出描述：
 * 返回有效密码串的最大长度
 *
 * 示例1
 * 输入：
 * ABBA
 * 复制
 * 输出：
 * 4
 * 复制
 * 示例2
 * 输入：
 * ABBBA
 * 复制
 * 输出：
 * 5
 * 复制
 * 示例3
 * 输入：
 * 12HHHHA
 * 复制
 * 输出：
 * 4
 */
public class PasswordInterception {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {
            {
                add("ABBA");
                add("ABBBA");
                add("12HHHHA");
            }
        };


        for (int i=0;i<list.size();i++) {
            int maxLength = 0;
            String s = list.get(i);
            if (s.length() < 3) {
                continue;
            }
            for (int j=0;j<s.length()-3;j++) {
                int yd = 0;
                for (;yd<=s.length()-3-j;) {
                    String substring = s.substring(j, 3 + yd + j);
                    boolean res = isPalindrome(substring);
                    if (res && maxLength < 3+yd) {
                        maxLength = 3+yd;
                    }
                    yd++;
                }

            }
            //输出
            System.out.println("结果：" + maxLength);
        }
    }
    /**
     * 判断字符串是否为回文数
     */
    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        //使用StringBuilder函数中的reverse方法，判断和原来的字符串是否相同
        return str.equals(sb.reverse().toString());
    }
}
