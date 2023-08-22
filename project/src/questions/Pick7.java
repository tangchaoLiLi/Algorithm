package questions;

import java.util.*;
import java.util.regex.*;
/**
 *
 */
public class Pick7 {
    public static void main(String[] args) {
        String[] strings = {
                "100", "20","21"
        };

        for (String str : strings) {
            Integer value = Integer.valueOf(str), count = 0;
            for (int i=7;i<=value;i++) {
                if (Integer.toString(i).contains("7")) {
                    count++;
                } else {
                    if (i % 7 == 0) {
                        count++;
                    }
                }
            }
            //输出匹配结果
            System.out.println("一共可以匹配到的结果：" + count);
        }
    }
}
