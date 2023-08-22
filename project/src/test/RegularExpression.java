package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class RegularExpression {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(){
            {
                add("Tangchao199428.");
                add("tangchao199428.");
                add("Tangchao199428");
            }
        };
        String regx = ".*[a-z].*";
        String regx2 = ".*[A-Z].*";
        String regx3 = ".*[0-9].*"; //等价于 ".*[\\d].*"、".*[^\\D].*"
        String regx4 = ".*[^a-zA-Z0-9].*"; //等价于 ".*[\\W].*"、".*[^\\w].*"

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            int count = 0;
            if (next.matches(regx)) {
                count++;
            }
            if (next.matches(regx2)) {
                count++;
            }
            if (next.matches(regx3)) {
                count++;
            }
            if (next.matches(regx4)) {
                count++;
            }
            //输出
            System.out.println(next + " : " + count);
        }
        //反向捕捉和分组
        String regex = "\\((\\d{3})\\)[\\s|+|-]?(\\d{3})-(\\d{4})";
        String input = "(123) 456-7890";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String formatted = matcher.group(1) + "-" + matcher.group(2) + "-" + matcher.group(3);
            System.out.println("Formatted phone number: " + formatted);
        }
        //反向捕捉和分组，手机11位号码
        String mobile_regex = "([0-9]{3})[\\s]?([0-9]{4})[\\s]?([0-9]{4})";
//        String mobile_regex = "(\\d{3})[\\s]?(\\d{4})[\\s]?(\\d{4})";
        input = "13407518300";
        pattern = Pattern.compile(mobile_regex);
        matcher = pattern.matcher(input);
        if (matcher.find()) {
            String formatted = matcher.group(1) + " " + matcher.group(2) + " " + matcher.group(3);
            System.out.println("Formatted mobile number: " + formatted);
            //输出开始匹配的位置和最后匹配的位置
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println(matcher.group());
        }
    }
}
