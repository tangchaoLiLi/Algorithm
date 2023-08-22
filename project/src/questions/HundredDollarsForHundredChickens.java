package questions;

import java.util.*;
import java.util.regex.*;

/**
 * HJ72 百钱买百鸡问题
 * 题目
 * 题解(248)
 * 讨论(364)
 * 排行
 * 面经new
 * 简单  通过率：53.80%  时间限制：1秒  空间限制：32M
 * 知识点
 * 查找
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 公元五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 现要求你打印出所有花一百元买一百只鸡的方式。
 * 输入描述：
 * 输入任何一个整数，即可运行程序。
 *
 * 输出描述：
 *  输出有数行，每行三个整数，分别代表鸡翁，母鸡，鸡雏的数量
 *
 * 示例1
 * 输入：
 * 1
 * 复制
 * 输出：
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 */
public class HundredDollarsForHundredChickens {
    public static void main(String[] args) {
        int m = 100, n = 100; //表示100块钱，100只鸡
        //创建两个int类型变量，分别用于划分多少只鸡
        int i = 0, j = 0, k = 0; //i表示公鸡，j表示母鸡，k表示雏鸡
        for (int a = 0;a<=n;a++) {
            i = a; //一共a只公鸡
            for (int b=0;b<=n;b++) {
                j = b; //b只母鸡
                k = n - i - j; //k只雏鸡
                if (k >= 0 && k % 3 == 0) {
                    int money = i * 5 + j * 3 + k / 3;
                    if (money == m) {
                        System.out.println("结果：" + i + ", " + j + ", " + k);
                    }
                }
            }
        }

    }
}

