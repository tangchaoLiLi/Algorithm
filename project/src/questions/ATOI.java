package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
/**
 * 寻找字符串中包含的数字
 */
public class ATOI {
    public static void main(String[] args) {
//        String s = "s = \"4193 with words\"";
        String s = "s = \"   -42\"";
        String regex = "(\".*\")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String str = matcher.group();
            regex = "([+|-]*[\\d]+)";
            pattern = Pattern.compile(regex);
            Matcher matcher1 = pattern.matcher(str);
            while(matcher1.find()) {
                System.out.println("结果：" + matcher1.group());
            }
        }
    }
}
