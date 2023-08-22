package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串对象的比较
 * 字符串对象有hashcode和equals方法，用于比较对象是否相同
 */
public class CharStringTest {
    public static void main(String[] args) {
        System.out.println("" + 'a' == "a");
        System.out.println("'a' hashcode = " + ("" + 'a').hashCode() + ", \"a\"" + "a".hashCode());

        String s1 = "tangchao";
        String s2 = new String("tangchao");
        String s3 = "tangchao";
        System.out.println("s1 code " + s1.hashCode() + ", s2 code " + s2.hashCode() + ", s3 code " + s3.hashCode());
        System.out.println("s1 = s2 : " + s2.equals(s1) + ", " + (s2 == s1));
        System.out.println("s1 = s3 : " + s3.equals(s1) + ", " + (s3 == s1));
        //计算字符串列表中最大长度的元素
        String[] arrs = new String[]{
                "tangchao",
                "jianglili",
                "xiaohai",
                "baba",
                "nainai",
                "mama",
                "gege",
                "meimei",
        };
        String s = Arrays.stream(arrs).max((a, b) -> a.length() - b.length()).orElse("");
        System.out.println("最长字符串的结果：" + s);
        String ss = Arrays.stream(arrs).min((a, b) -> a.length() - b.length()).orElse("");
        System.out.println("最短字符串的结果：" + ss);
        //找出所有最短字符串，使用mapToInt、min、orElse方法获取
        int minLength = Arrays.stream(arrs).mapToInt(String::length).min().orElse(0);
        List<String> collect = Arrays.stream(arrs).filter(o -> o.length() == minLength).collect(Collectors.toList());
        System.out.println("最短字符串一共有：" + collect.size());
        collect.stream().forEach(o -> {
            System.out.println("最短字符串：" + o);
        });
        /**
         * lamda表达式找出字符串数组最长的3个字符串
         * 使用sorted、Comparator.comparing、reversed方法可以实现倒序、属性值排序等
         */
        String[] arr = {"apple", "pear", "banana", "orange", "watermelon", "grape"};
        String[] topThree = Arrays.stream(arr)
                .sorted(Comparator.comparing(String::length).reversed())
                .toArray(String[]::new);
//        String[] topThree;
//        topThree = Arrays.stream(arr).sorted(Comparator.reverseOrder()).toArray(String[]::new);
        System.out.println("结果：" + topThree);
    }
}
