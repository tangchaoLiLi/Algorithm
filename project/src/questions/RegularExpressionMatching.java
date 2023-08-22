package questions;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * 正则表达式匹配，老生常谈的问题，需要进一步优化
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        /**
         * 匹配qq邮箱
         * 样例：585977209@qq.com  tangchao584977209@qq.com
         */
        String strs[] = {
                "585977209@qq.com",
                "tangchao584977209@qq.com",
                "tangc#ao577209@qq.com",
                "tangcao5_77209@qq.com",
        };
        /**
         * 正则表达式，使用^匹配开头，$匹配结尾
         * 用于整段匹配，不是匹配某一字段或者部分
         */
//        String regex = "^([a-zA-Z0-9]+)@qq\\.com$";
        /**
         * 使用使用\\w表示匹配 a-z A-Z 0-9 _
         * 不匹配下划线，则需要^_
         */
        String regex = "^([^_|\\w]+)@qq\\.com$";
        Pattern pattern = Pattern.compile(regex);
        for (int i=0;i<strs.length;i++) {
            Matcher matcher = pattern.matcher(strs[i]);
            if (matcher.find()) {
                System.out.println("匹配结果：" + matcher.group(1));
                System.out.println(strs[i] + " 的匹配结果：ok");
            } else {
                System.out.println(strs[i] + " 的匹配结果：false");
            }
        }

        List<Character>[] array = (List<Character>[])new ArrayList<?>[1];
        array[0] = new ArrayList<Character>(){
            {
                add('t');add('c');
            }
        };
        for (int j=0;j<array.length;j++) {
            for (Character character : array[j]) {
                System.out.println("字符数组结果：" + character);
            }
        }
    }

}
