package questions;

import java.util.Scanner;

public class LeastCommonMultiple {
    /**
     * 计算最小公倍数
     * 取值范围：1<=a,b<=10000
     *
     */
    public static void main(String[] args) {
        int a = 1, b = 1;
        System.out.println("请输入a和b的值，中间用英文逗号隔开：");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String aa = line.split(",")[0];
            String bb = line.split(",")[1];
            if (aa.equals("") || bb.equals("")) {
                System.out.println("输入的数据有误，请重新输入：");
                continue;
            }
            a = Integer.valueOf(aa);
            b = Integer.valueOf(bb);
            int c = 1, d = 1;
            for (;c<=a&&c<=b;c++) {
                int aaa = 1, bbb = 1;
                if (a % c == 0 && b % c == 0) {
                    aaa = a / c;
                    bbb = b / c;
                    int dd = aaa * bbb * c;
                    if (d == 1 || dd < d) {
                        d = aaa * bbb * c;
                    }
                }
            }
            //最小公倍数时：
            System.out.println("最小公倍数是：" + d);
            return;
        }
    }
}
