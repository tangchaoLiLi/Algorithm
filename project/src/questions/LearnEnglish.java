package questions;

import java.util.*;
/**
 * HJ42 学英语
 * 题目
 * 题解(179)
 * 讨论(262)
 * 排行
 * 面经new
 * 较难  通过率：24.73%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 *
 * 具体规则如下:
 * 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
 * 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
 * 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
 * 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
 *
 * 下面再看几个数字例句：
 * 22: twenty two
 * 100:  one hundred
 * 145:  one hundred and forty five
 * 1,234:  one thousand two hundred and thirty four
 * 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
 * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
 * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
 *
 * 说明：
 * 数字为正整数，不考虑小数，转化结果为英文小写；
 * 保证输入的数据合法
 * 关键字提示：and，billion，million，thousand，hundred。
 *
 * 数据范围：1 \le n \le 2000000 \1≤n≤2000000
 *
 *
 * 输入描述：
 * 输入一个long型整数
 *
 * 输出描述：
 * 输出相应的英文写法
 *
 * 示例1
 * 输入：
 * 22
 * 复制
 * 输出：
 * twenty two
 */
public class LearnEnglish {
    static Map<Integer, String> map = new HashMap<>() {
        {
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
            put(10, "ten");
            put(11, "eleven");
            put(12, "twelve");
            put(13, "thirteen");
            put( 14, "fourteen");
            put(15, "fifteen");
            put(16, "sixteen");
            put(17, "seventeen");
            put(18, "eighteen");
            put(19, "nineteen");
            put(20, "twenty");
            put(30, "thirty");
            put(40, "forty");
            put(50, "fifty");
            put(60, "sixty");
            put(70, "seventy");
            put(80, "eighty");
            put(90, "ninety");
            put(100, "hundred and");
            put(1000, "thousand");
            put(1000000, "million");
            put(1000000000, "billion");
        }
    };
    public static void main(String[] args) {
        String[] numbers = {
                "1234",
                "145",
                "22"
        };

        for (int i=0;i<numbers.length;i++) {
            Integer value = Integer.valueOf(numbers[i]);
            switch (numbers[i].length()) {
                case 4:
                    int thousand = value / 1000;
                    int hundrund = (value -  thousand * 1000) / 100;
                    int ten = (value - hundrund * 100 - thousand * 1000) / 10;
                    int one = (value - hundrund * 100 - thousand * 1000 - ten * 10);

                    String res = "";
                    res += map.get(thousand) + " " + map.get(1000) + " " + map.get(hundrund) + " " + map.get(100) + " " + map.get(ten * 10) + " " + map.get(one);
                    System.out.println(res);
                    break;
                case 3:
                    hundrund = (value) / 100;
                    ten = (value - hundrund * 100) / 10;
                    one = (value - hundrund * 100 - ten * 10);

                    res = "";
                    res += map.get(hundrund) + " " + map.get(100) + " " + map.get(ten * 10) + " " + map.get(one);
                    System.out.println(res);
                    break;
                case 2:
                    ten = (value) / 10;
                    one = (value - ten * 10);

                    res = "";
                    res += map.get(ten * 10) + " " + map.get(one);
                    System.out.println(res);
                    break;
            }
        }
    }
}
