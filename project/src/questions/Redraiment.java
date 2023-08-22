package questions;

import java.util.Scanner;

/**
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 数据范围：每组数据长度满足 1 \le n \le 200 \1≤n≤200  ， 数据大小满足 1 \le val \le 350 \1≤val≤350
 *
 *
 * 输入描述：
 * 数据共2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 *
 * 输出描述：
 * 输出一个结果
 */
public class Redraiment {
    public static void main(String[] args) {
        System.out.println("请输入梅花桩的数目：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] arr = new int[i];
        System.out.println("请输入梅花桩的高度");
        int n = 0;
        while (n<i) {
            arr[n++] = scanner.nextInt();
        }
        //统计并输出结果
        int[] resArr = new int[i];
        for (int a=0;a<i;a++) {
            //创建一个i-1长度的数组
            int[] t = new int[i-1];
            int[] r = new int[i];
            int j = 0;
            for (int tt=0;tt<r.length;tt++) {
                if (tt != a) {
                    r[tt] = arr[tt];
                } else {
                    r[tt] = -1;
                }
            }
            for (int rr=a;rr<r.length;rr++) {
                if (r[rr] > 0) {
                    t[j++] = r[rr];
                }
            }
            //从小到大排序
            for (int m=0;m<t.length;m++) {
                for (int l=0;l<t.length;l++) {
                    if (t[m] < t[l]) {
                        int tmp = t[m];
                        t[m] = t[l];
                        t[l] = tmp;
                    }
                }
            }
            int res = 1, aa = arr[a];
            //记录最大数
            for (int e=0;e < t.length;e++) {
                if (aa < t[e]) {
                    aa = t[e];
                    res++;
                }
            }
            //添加到数组中
            resArr[a] = res;
        }
        //输出最大方案
        int lastMoment =0;
        for (int o=0;o<i;o++) {
            if (resArr[o] >= lastMoment) {
                lastMoment = resArr[o];
            }
        }
        //输出
        System.out.println("输出：" + lastMoment);
    }
}
