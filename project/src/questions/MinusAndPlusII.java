package questions;

import java.util.Scanner;

/**
 * 输入 n 个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾。
 *
 * 数据范围：1 \le n \le 50000 \1≤n≤50000  ，其中每个数都满足 |val| \le 10^{6} \∣val∣≤10
 * 6
 *
 * 输入描述：
 * 输入任意个整数，每行输入一个。
 *
 * 输出描述：
 * 输出负数个数以及所有非负数的平均值
 */
public class MinusAndPlusII {
    public static void main(String[] args) {
        System.out.println("需要输入统计的数目：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int m = 0;
        int[] array = new int[i];
        System.out.println("请输入需要统计的数据：");
        while (i>m) {
            array[m++] = scanner.nextInt();
        }
        //统计并计算
        int n = 0, p = 0;
        double avr = 0;
        for (int a=0;a<i;a++) {
            if (array[a] < 0) {
                n++;
            } else {
                avr += array[a];
                p++;
            }
        }
        //输出结果
        System.out.println("输出：" + "负数的个数为：" + n + ", 非负数的平均值为：" + (avr / p));
    }
}
