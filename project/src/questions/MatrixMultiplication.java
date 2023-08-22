package questions;

import java.util.*;
import java.util.regex.*;

/**
 * HJ69 矩阵乘法
 * 题目
 * 题解(233)
 * 讨论(326)
 * 排行
 * 面经new
 * 中等  通过率：48.40%  时间限制：1秒  空间限制：32M
 * 知识点
 * 数组
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 *
 * 矩阵的大小不超过100*100
 * 输入描述：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 *
 * 输出描述：
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 * 示例1
 * 输入：
 * 2
 * 3
 * 2
 * 1 2 3
 * 3 2 1
 * 1 2
 * 2 1
 * 3 3
 * 复制
 * 输出：
 * 14 13
 * 10 11
 * 复制
 * 说明：
 * 1 2 3
 * 3 2 1
 * 乘以
 * 1 2
 * 2 1
 * 3 3
 * 等于
 * 14 13
 * 10 11
 */
public class MatrixMultiplication {
    public static void main(String[] args) {
        int arr1[][] = {
            {1 ,2 ,3 ,4},
            {3 ,2 ,1, 5}
        };
        int arr2[][] = {
                {1 ,2},
                {2, 1},
                {3, 3},
                {4, 5},
        };
        int[][] matix = matix(arr1, arr2);
        //输出结果
        for (int i=0;i<matix.length;i++) {
            for (int j=0;j<matix[i].length;j++) {
                System.out.print(String.format("%-5d", matix[i][j]));
            }
            System.out.println();
        }
    }
    /**
     * 计算两个矩阵相乘的结果
     *
     *
     */
    public static int[][] matix(int[][] arr1, int[][] arr2) {
        int l = arr1[0].length;
        int h = arr2.length;
        if (l != h) {
            return null;
        }
        int ll = arr1.length;
        int hh = arr2[0].length;
        //定义行和列的矩阵
        int arr[][] = new int[ll][hh];
        for (int i=0;i<ll;i++) {
            for (int j=0;j<hh;j++) {
                //第i行，第j列
                int temp1[] = new int[l];
                int temp2[] = new int[h];
                for (int k=0;k<l;k++) {
                    temp1[k] = arr1[i][k];
                }
                for (int r=0;r<h;r++) {
                    temp2[r] = arr2[r][j];
                }
                //相乘得出结果
                int res = 0;
                for (int m=0;m<l;m++) {
                    res += temp1[m] * temp2[m];
                }
                arr[i][j] = res;
            }
        }
        return arr;
    }
}
