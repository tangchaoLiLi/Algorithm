package questions;

import java.util.regex.*;
import java.util.*;
/**
 * 描述
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 *
 * 4、每个单词最长20个字母；
 *
 * 数据范围：字符串长度满足 1 \le n \le 10000 \1≤n≤10000
 * 输入描述：
 * 输入一行，表示用来倒排的句子
 *
 * 输出描述：
 * 输出句子的倒排结果
 *
 * 示例1
 * 输入：
 * I am a student
 * 复制
 * 输出：
 * student a am I
 * 复制
 * 示例2
 * 输入：
 * $bo*y gi!r#l
 * 复制
 * 输出：
 * l r gi y bo
 */
public class WordInversion {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {
            {
                add("I am a student");
                add("$bo*y gi!r#l");
            }
        };
        for (int i=0;i<list.size();i++) {
            //使用pattern.split()方法可以实现自定义分隔符分割
            String regex = "\\W";
            Pattern pattern = Pattern.compile(regex);
            String[] strings = pattern.split(list.get(i)); //使用pattern.split()实现自定义分隔符
            String res = "";
            for (int j=strings.length - 1;j>=0;j--) {
                res += strings[j] + " ";
            }
            System.out.println("结果：" + res);
//            String s = list.get(i);
//            int j = 0;
//            do {
//                char c = s.charAt(j);
//            } while(++j<s.length());
        }
    }
}
