package questions;

/**
 * HJ43 迷宫问题
 * 题目
 * 题解(402)
 * 讨论(527)
 * 排行
 * 面经new
 * 中等  通过率：34.59%  时间限制：1秒  空间限制：32M
 * 知识点
 * 查找
 * getAllPath
 * 广度优先搜索(BFS)
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 *
 *
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 *
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 *
 *
 * 数据范围： 2 \le n,m \le 10 \2≤n,m≤10  ， 输入的内容只包含 0 \le val \le 1 \0≤val≤1
 *
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 *
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 * 示例1
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 复制
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 * 复制
 * 示例2
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 1
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 复制
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (3,0)
 * (4,0)
 * (4,1)
 * (4,2)
 * (4,3)
 * (4,4)
 *
 * 复制
 * 说明：
 * 注意：不能斜着走！
 */
import java.util.*;
public class MazeProblem {
    static class  Point {
        public int x;
        public int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
    public static void main(String[] args) {
        /**
         * java二维数组的定义方式
         */
//        int nn[][] = new int[][]{
//            {1, 2},
//            {3, 4, 5},
//            {6, 7, 8, 9}
//        };
//        int[][] arr = new int[3][4];
//        arr = new int[2][3];
//        //赋值，可以使用length属性获取数组长度
//        for (int i=0;i< arr.length;i++) {
//            for (int j=0;j<arr[i].length;j++) {
//                System.out.println(arr[i][j]);
//            }
//        }
        int mm[][] = new int[6][6];
        int h1[] = new int[] {0, 1, 0, 0, 0, 0};
        int h2[] = new int[] {0, 1, 1, 1, 0, 0};
        int h3[] = new int[] {0, 0, 0, 0, 0, 0};
        int h4[] = new int[] {0, 1, 1, 1, 0, 0};
        int h5[] = new int[] {0, 0, 0, 1, 0, 0};
        int h6[] = new int[] {0, 0, 0, 1, 1, 0};
        //添加到mm数组中
        mm[0] = h1;
        mm[1] = h2;
        mm[2] = h3;
        mm[3] = h4;
        mm[4] = h5;
        mm[5] = h6;
        //统计所有可走的点位
        List<Point> points = new ArrayList<>();
        //设计算法计算，从[0,0]的位置，走到[4,4]的位置
        List<List<Point>> pointsList = new ArrayList<>();
        getAllPath(mm, 0, 0, points);
        System.out.println(points);
        //输出map的坐标
        for (int i=0;i< mm.length;i++) {
            for (int j=0;j<mm[i].length;j++) {
                System.out.print(mm[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * 使用递归方法寻找所有可能的路径
     *
     */
    private static boolean getAllPath (int[][] map, int x, int y, List<Point> path) {
        // 添加路径并标记已走
        path.add(new Point(x, y));
        map[x][y] = 1;
        // 结束标志
        if (x == map.length - 1 && y == map[0].length - 1) {
            return true;
        }
        // 向下能走时
        if (x + 1 < map.length && map[x + 1][y] == 0) {
            if (getAllPath(map, x + 1, y, path)) {
                return true;
            }
        }
        // 向右能走时
        if (y + 1 < map[0].length && map[x][y + 1] == 0) {
            if (getAllPath(map, x, y + 1, path)) {
                return true;
            }
        }
        // 向上能走时
        if (x - 1 > -1 && map[x - 1][y] == 0) {
            if (getAllPath(map, x - 1, y, path)) {
                return true;
            }
        }
        // 向左能走时
        if (y - 1 > -1 && map[x][y - 1] == 0) {
            if (getAllPath(map, x, y - 1, path)) {
                return true;
            }
        }
        // 回溯
        path.remove(path.size() - 1);
        map[x][y] = 0;
        return false;
    }
}
