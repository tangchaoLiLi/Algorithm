package questions;

import java.util.*;
import java.util.regex.*;

/**
 * HJ64 MP3光标位置
 * 题目
 * 题解(263)
 * 讨论(348)
 * 排行
 * 面经new
 * 中等  通过率：25.28%  时间限制：1秒  空间限制：32M
 * 知识点
 * 数组
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 *
 *
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 *
 * 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 *
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 *
 *
 *
 * 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。
 *
 *
 *
 * 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
 *
 *
 * 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
 *
 *
 *
 * 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
 *
 *
 *
 * 其他情况，不用翻页，只是挪动光标就行。
 *
 * 数据范围：命令长度1\le s\le 100\1≤s≤100 ，歌曲数量1\le n \le 150\1≤n≤150
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 *
 * 输出描述：
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 *
 * 示例1
 * 输入：
 * 10
 * UUUU
 * 复制
 * 输出：
 * 7 8 9 10
 * 7
 */
public class MP3CursorPosition {
    public static void main(String[] args) {
        String[] strs = new String[] {
//            "10 UUUU",
//            "7 UDDDD",
//            "11 UDDDDDDDU",
            "12 UUDDDDDDDUDD",
        };
        int i=0;
        while (i<strs.length) {
            /**
             * [[1 2 3 4] 5 6 7 8 9 10] --- 1
             * [1 2 3 4 5 6 [7 8 9 10]] --- 8
             *
             * [[1 2 3 4] 5 6 7] --- 1
             * [1 2 3 [4 5 6 7]] --- 7
             * [[1 2 3 4] 5 6 7] --- 4
             *
             * [1 2 3 4 5 6 7 8 9 10 11 12]
             */
            String str = strs[i];
            String[] strings = str.split(" ");
            Integer value = Integer.valueOf(strings[0]);
            int[] array = new int[value];
            for (int t=0;t<array.length;t++) {
                array[t] = t + 1;
            }
            int[] subArray = new int[] {1,2,4,5};
            char[] chars = strings[1].toCharArray();
            int start = 1, subStart = 1;
            for (int h=0;h<chars.length;h++) {
                switch (chars[h]) {
                    case 'D':
                        start++;
                        subStart++;
                        if (start > value) {
                            start = 1;
                            subStart = 1;
                            subArray = new int[]{1,2,3,4};
                        }
                        if (subStart > 4) {
                            subArray = new int[]{subArray[0]+1, subArray[1]+1, subArray[2]+1, subArray[3]+1};
                            subStart = 4;
                        }
                        break;
                    case 'U':
                        start--;
                        subStart--;
                        if (start <= 0) {
                            start = value;
                            subStart = 4;
                            subArray = new int[]{value-3, value-2, value-1, value};
                        }
                        if (subStart <= 0) {
                            subArray = new int[]{subArray[0]-1, subArray[1]-1, subArray[2]-1, subArray[3]-1};
                            subStart = 1;
                        }
                        break;
                }
            }
            String res = "";
            for (int g=0;g<4;g++) res += subArray[g] + " ";
            System.out.println("结果：" + res);
            System.out.println("结果：" + start);
            i++;
        }
    }
}
