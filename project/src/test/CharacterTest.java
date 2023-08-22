package test;

import java.util.Arrays;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * Character封装类和char基础类型的用法
 */
public class CharacterTest {
    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e'};
        /**
         * 判断字符是否为拉丁字母，或者数字
         * 方法：isLetter, isLetterOrDigit
         */
        boolean z = Character.isLetter('Z');
        boolean p = Character.isLetter('p');
        boolean t_ = Character.isLetter('\t');
        System.out.println("结果：" + "Z : " + z);
        System.out.println("结果：" + "p : " + p);
        System.out.println("结果：" + "/t : " + t_);

        boolean zero = Character.isLetterOrDigit('0');
        System.out.println("结果：" + " 0 : " + zero);


    }
    /**
     * 将字符数组，转化成字符列表，char转Character
     */
    public static List<Character> getCharacterList(char[] array) {
        List<Character> list = new ArrayList<>();
        try {
            for (char ch : array) {
                list.add(ch);
            }
        } catch (Exception e) {
            list.clear();
            for (int i=0;i<array.length;i++) {
                list.add(array[i]);
            }
        }
        return list;
    }
}
