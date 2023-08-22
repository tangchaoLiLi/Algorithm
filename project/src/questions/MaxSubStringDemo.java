package questions;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * 求字符串的最大回文子串
 */
public class MaxSubStringDemo {
    public static void main(String[] s) {
        System.out.println("Hello world");
        List<String> list = new ArrayList();
        handleString("babad", 0, list);
        System.out.println("list size = " + list.size());
        List<String> strings = list.stream().filter(o -> o.equals(new StringBuilder(o).reverse().toString())).toList();
        String longestString = strings.stream()
                .max((s1, s2) -> s1.length() - s2.length())
                .orElse(null);
        System.out.println("输出：" + longestString);
    }

    public static void handleString(String s, int i, List<String> list) {
        if (i == s.length()) {
            return;
        }

        for (int j=i;j<=s.length();j++) {
            if (i != j) {
                list.add(s.substring(i, j));
            }
        }
        //使用递归，移动后一位，继续找字串，如果字符串长裤为5，则是：5+4+3+2+1=15
        handleString(s, i+1, list);
    }
}
