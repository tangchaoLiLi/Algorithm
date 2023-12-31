package questions;

import java.util.Scanner;

/**
 *描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 *
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * 输入描述：
 * 输入一个正浮点数值
 *
 * 输出描述：
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入：
 * 5.5
 * 复制
 * 输出：
 * 6
 * 复制
 * 说明：
 * 0.5>=0.5，所以5.5需要向上取整为6
 * 示例2
 * 输入：
 * 2.499
 * 复制
 * 输出：
 * 2
 * 复制
 * 说明：
 * 0.499<0.5，2.499向下取整为2
 */
public class Approximation {
    public static void main(String[] args) {
        System.out.println("输入浮点类型的数字：");
        Scanner scanner = new Scanner(System.in);
        double v = scanner.nextDouble();
        int middle = (int)v;
        double dot = v - middle;
        double dot2 = (middle + 1) - v;

        double ceil = dot >= dot2 ? middle + 1 : middle;
        System.out.println(String.format("输出：%.0f", ceil));
    }
}
