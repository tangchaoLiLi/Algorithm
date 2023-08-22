package questions;

import java.util.Scanner;

/**
 * 计算浮点数的立方根，精确到一位小数
 * 取值范围：|val|<=20
 */
public class CubeRoot {
    public static void main(String[] args) {
        System.out.println("请输入一个求立方根的小数：");
        Scanner scanner = new Scanner(System.in);
        double v = scanner.nextDouble();
        //开始累加
        double a = 0.0,dot1 = 0.0, dot2 = 0.0;
        for (;;) {
            if (v >= 0) {
                if (a*a*a<=v) {
                    dot1 = v - a*a*a;
                }
                a+=0.1;
                if (a*a*a>=v) {
                    dot2 = a*a*a - v;
                    if (dot1 > dot2) {
                        a = a;
                    } else {
                        a = a - 0.1;
                    }
                    break;
                }
            } else {
                if (a*a*a>=v) {
                    dot1 = a*a*a - v;
                }
                a-=0.1;
                if (a*a*a<v) {
                    dot2 = v - a*a*a;
                    if (dot1 > dot2) {
                        a = a;
                    } else {
                        a = a + 0.1;
                    }
                    break;
                }
            }

        }
        //输出结果
        System.out.println(String.format("%.1f的立方根是：%.1f", v, a));
    }
}
