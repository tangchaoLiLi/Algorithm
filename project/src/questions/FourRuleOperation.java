package questions;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * HJ50 四则运算
 * 题目
 * 题解(253)
 * 讨论(353)
 * 排行
 * 面经new
 * 中等  通过率：55.03%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 基础数学
 * 栈
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 * 数据范围：表达式计算结果和过程中满足 |val| \le 1000 \∣val∣≤1000  ，字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 *
 * 输入描述：
 * 输入一个算术表达式
 *
 * 输出描述：
 * 得到计算结果
 *
 * 示例1
 * 输入：
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 复制
 * 输出：
 * 25
 */
public class FourRuleOperation {
    public static void main(String[] args) {
        String str = "3+2*{1+2*[-4/(8-6)+7]}";

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
    }
}
