package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 数据范围：输入的正整数满足 1 \le n \le 100 \1≤n≤100
 *
 * 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
 * 输入描述：
 * 输入文件最多包含 10 组测试数据，每个数据占一行，仅包含一个正整数 n（ 1<=n<=100 ），表示小张手上的空汽水瓶数。n=0 表示输入结束，你的程序不应当处理这一行。
 *
 * 输出描述：
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 *
 * 示例1
 * 输入：
 * 3
 * 10
 * 81
 * 0
 * 复制
 * 输出：
 * 1
 * 5
 * 40
 * 复制
 * 说明：
 * 样例 1 解释：用三个空瓶换一瓶汽水，剩一个空瓶无法继续交换
 * 样例 2 解释：用九个空瓶换三瓶汽水，剩四个空瓶再用三个空瓶换一瓶汽水，剩两个空瓶，向老板借一个空瓶再用三个空瓶换一瓶汽水喝完得一个空瓶还给老板
 */
public class SodaBottle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>() {
            {
                add(3);
                add(10);
                add(81);
                add(20);
            }
        };
        for (int i=0;i<list.size();i++) {
            Integer integer = list.get(i);
            int count = 0;
            while (integer > 1) {
                if (integer == 2) {
                    count += 1;
                    break;
                }
                int res = integer / 3;
                int dot = integer % 3;
                //累加
                count += res;
                //下一次循环的瓶子总数
                integer = res + dot;
            }
            //输出
            System.out.println("结果：" + count);
        }
    }

}
