package questions;

import java.util.Arrays;
import java.util.Stack;

/**
 * HJ51 输出单向链表中倒数第k个结点
 * 题目
 * 题解(329)
 * 讨论(450)
 * 排行
 * 面经new
 * 简单  通过率：27.42%  时间限制：1秒  空间限制：32M
 * 知识点
 * 链表
 * 双指针
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 *
 * 链表结点定义如下：
 * struct ListNode
 * {
 *     int m_nKey;
 *     ListNode* m_pNext;
 * };
 * 正常返回倒数第k个结点指针，异常返回空指针.
 * 要求：
 * (1)正序构建链表;
 * (2)构建后要忘记链表长度。
 * 数据范围：链表长度满足 1 \le n \le 1000 \1≤n≤1000  ， k \le n \k≤n  ，链表中数据满足 0 \le val \le 10000 \0≤val≤10000
 *
 * 本题有多组样例输入。
 *
 *
 * 输入描述：
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 *
 * 输出描述：
 * 输出一个整数
 *
 * 示例1
 * 输入：
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 复制
 * 输出：
 * 5
 */
public class OutputLastKNode {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            1,2,3,4,5,6,7,8
        };
        Stack<Integer> stack = new Stack<>();
        //遍历添加
        Arrays.asList(arr).stream().forEach(o -> {
            stack.push(o);
        });
        //末尾输出第n个元素
        int n = 4;
        Integer pop = -1;
        for (int i=0;i<n-1;i++) {
            pop = stack.pop();
        }

        System.out.println("结果：" + stack.peek());
    }
}
