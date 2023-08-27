package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * HJ44 Sudoku
 * 题目
 * 题解(140)
 * 讨论(155)
 * 排行
 * 面经new
 * 困难  通过率：28.36%  时间限制：1秒  空间限制：32M
 * 知识点
 * 思维
 * 基础数学
 * 搜索
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
 * 例如：
 * 输入
 */
public class SoduKu {
    public static void main(String[] agrs) {

        Scanner scan = new Scanner(System.in);

        /**
         * 0 9 2 4 8 1 7 6 3
         * 4 1 3 7 6 2 9 8 5
         * 8 6 7 3 5 9 4 1 2
         * 6 2 4 1 9 5 3 7 8
         * 7 5 9 8 4 3 1 2 6
         * 1 3 8 6 2 7 5 9 4
         * 2 7 1 5 3 8 6 4 9
         * 3 8 6 9 1 4 2 5 7
         * 0 4 5 2 7 6 8 3 1
         */
        int[][] a = new int[][] {
                {0 ,9 ,0 ,4 ,0 ,1 ,7 ,0 ,3},
                {4 ,1 ,3 ,7 ,6 ,2 ,9 ,8 ,5},
                {8 ,0 ,7 ,3 ,5 ,9 ,4 ,1 ,2},
                {6 ,2 ,4 ,1 ,9 ,5 ,3 ,7 ,8},
                {7 ,5 ,9 ,8 ,4 ,3 ,1 ,2 ,6},
                {1 ,3 ,8 ,6 ,2 ,7 ,5 ,9 ,4},
                {2 ,7 ,1 ,5 ,3 ,8 ,6 ,0 ,9},
                {3 ,8 ,6 ,9 ,1 ,4 ,2 ,5 ,7},
                {0 ,4 ,5 ,2 ,7 ,6 ,8 ,3 ,1},
        };
//        for (int i = 0; i < 9; i ++) {
//            for (int j = 0; j < 9; j ++) {
//                a[i][j] = scan.nextInt();
//            }
//        }

        handle(a);

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean handle(int[][] arr) {
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                int num = arr[i][j];
                if (num == 0) {
                    for (int k=1;k<10;k++) {
                        arr[i][j] = k;

                        if (check(i, j, k, arr)) {
                            if (handle(arr)) {
                                return true;
                            }
                        }

                        //回溯
                        arr[i][j] = 0;
                    }

                    return false;
                }
            }
        }
        return true;
    }
    private static boolean resolve(int[][] a) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {

                /**
                 * 对于空缺的位置从 1-9 依次填入，如果 1-9 符合数独规则
                 *      则基于此尝试递归解决数独，否则回溯
                 */
                if (a[i][j] == 0) {
                    for (int k = 1; k < 10; k ++) {
                        a[i][j] = k;

                        // 校验数独规则
                        if (check(i, j, k, a)) {

                            // 规则符合则递归解决数独
                            if (resolve(a)) {

                                // 数独解决
                                return true;
                            }
                        }

                        // 回溯
                        a[i][j] = 0;
                    }

                    // 9 个数字尝试完都不行则该数独无法解决
                    return false;
                }
            }
        }

        // 没有数字为 0，即数独已经解决
        return true;
    }

    private static boolean check(int i, int j, int v, int[][] a) {

        return checkI(i, j, a) && checkJ(i, j, a) && checkS(i, j, a);
    }

    private static boolean checkI(int i, int j, int[][] a) {
        for (int index = 0; index < 9; index ++) {
            if (index != j && a[i][index] == a[i][j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkJ(int i, int j, int[][] a) {
        for (int index = 0; index < 9; index ++) {
            if (index != i && a[index][j] == a[i][j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkS(int i, int j, int[][] a) {
        int imin = (i / 3) * 3;
        int jmin = (j / 3) * 3;
        for (int x = imin; x < imin + 3; x ++) {
            for (int y = jmin; y < jmin + 3; y ++) {
                if (x != i && j != i && a[x][y] == a[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
