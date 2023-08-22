package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * 电话号码 按下键之后的字母组合
 * 1 --- 没有对应的字母
 * 2 --- abc
 * 3 --- def
 * 4 --- ghi
 * 5 --- jkl
 * 6 --- mno
 * 7 --- pqrs
 * 8 --- tuv
 * 9 --- wxyz
 */
public class PhoneNumber {
    public static void main(String[] args) {
        Map<Character, List<String>> map1 = new LinkedHashMap();
        List<String> list1 = new ArrayList<>();
        list1.add("a");list1.add("b");list1.add("c");
        map1.put('2', list1);

        List<String> list2 = new ArrayList<>();
        list2.add("d");list2.add("e");list2.add("f");
        map1.put('3', list2);

        List<String> list3 = new ArrayList<>();
        list3.add("g");list3.add("h");list3.add("i");
        map1.put('4', list3);

        List<String> list4 = new ArrayList<>();
        list4.add("j");list4.add("k");list4.add("l");
        map1.put('5', list4);

        List<String> list5 = new ArrayList<>();
        list5.add("m");list5.add("n");list5.add("o");
        map1.put('6', list5);

        List<String> list6 = new ArrayList<>();
        list6.add("p");list6.add("q");list6.add("r");list6.add("s");
        map1.put('7', list6);

        List<String> list7 = new ArrayList<>();
        list7.add("t");list7.add("u");list7.add("v");
        map1.put('8', list7);

        List<String> list8 = new ArrayList<>();
        list8.add("w");list8.add("x");list8.add("y");list8.add("z");
        map1.put('9', list8);

        String str1 = "234";
        List<String>[] array = (List<String>[])new ArrayList<?>[str1.length()];
        for (int i=0;i<str1.length();i++) {
            char c = str1.charAt(i);
            array[i] = map1.get(c);
        }
        //求所有的组合
        System.out.println("结果数量：" + array.length);

        List<String> list = new ArrayList();
        generateStrings(array, 0, list);
        //输出
        System.out.println("结果：" + list.size());
        //遍历所有结果
        list.stream().forEach(o -> {
            System.out.print(o + " ");
        });
        System.out.println();
    }

    public static void generateStrings(List<String>[] arrays, int n, List<String> list) {
        if (n == arrays.length) {
            return;
        }

        List<String> newList = new ArrayList<>();
        for (int i=0;i<arrays[n].size();i++) {
            if (list.isEmpty() && n == 0) {
                newList.add(arrays[n].get(i));
            } else {
                for (int j=0;j<list.size();j++) {
                    newList.add(arrays[n].get(i) + list.get(j));
                }
            }
        }
        list.clear();
        list.addAll(newList);
        generateStrings(arrays, n + 1, list);
    }
}
