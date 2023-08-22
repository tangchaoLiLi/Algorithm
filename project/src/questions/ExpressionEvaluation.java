package questions;

/**
 * HJ54 表达式求值
 * 题目
 * 题解(202)
 * 讨论(273)
 * 排行
 * 面经new
 * 简单  通过率：51.00%  时间限制：1秒  空间限制：32M
 * 知识点
 * 字符串
 * 基础数学
 * 栈
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 *
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 *
 * 数据范围：运算过程中和最终结果均满足 |val| \le 2^{31}-1 \∣val∣≤2
 * 31
 *  −1  ，即只进行整型运算，确保输入的表达式合法
 * 输入描述：
 * 输入算术表达式
 *
 * 输出描述：
 * 计算出结果值
 *
 * 示例1
 * 输入：
 * 400+5
 * 复制
 * 输出：
 * 405
 */

import java.util.*;
import java.util.regex.*;

public class ExpressionEvaluation {
    public static void main(String[] args) {
        String[] strs = {
                "(5 + 3) * 7 - 12",
                "400+((5*3-6)/2)/3+(2+3)",
                "15 / (3 + 2) - 4 * 2",
                "3 * (7 + 2) + 14 / 2",
                "20 - 8 * (6 + 2) / 4"
        };
        //测试一
        String regex1 = "([+|\\-|\\*|/|\\(|\\)]){1,}";
        Pattern pattern1 = Pattern.compile(regex1);
//        Matcher matcher1 = pattern1.matcher(str);
//        String[] split1 = pattern1.split(str);

        for (String str : strs) {
            //空白符号替换
            str = str.replaceAll(" ", "");
            List<String> list = getCharsList(str);
            //遍历
//            list.stream().forEach(o -> {
//                System.out.println(o);
//            });
            //计算出结果
            System.out.println(handle(list));
        }
        //计算1+1+1+8，使用顺序计算
        List<String> biaodashi = new ArrayList<>(){
            {
                add("1");
                add("+");
                add("1");
                add("+");
                add("1");
                add("*");
                add("8");
            }
        };
        int i = orderHandle(biaodashi);
        System.out.println("结果：" + i);
    }

    public static List<String> getCharsList(String str) {
        char[] chars = str.toCharArray();
        int i=0;
        String num = "";
        LinkedList<String> list = new LinkedList<>();
        while (chars.length > i) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num += chars[i];
                i++;
                if (i >= chars.length && num.length() > 0) {
                    list.add(num);
                }
                continue;
            } else {
                if (num.length() > 0) {
                    list.add(num);
                    num = "";
                }
                if (chars[i] == '+' ||
                        chars[i] == '-' ||
                        chars[i] == '*' ||
                        chars[i] == '/' ||
                        chars[i] == '(' ||
                        chars[i] == ')') {
                    list.add("" + chars[i]);
                }
            }
            i++;
        }
        return list;
    }
    public static int handle(List<String> list) {
        //如果有括号，则先匹配括号内的内容
        String expression = "";
        for (String s : list) {
            expression += s;
        }
        String regex = "\\([^\\(\\)]*\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String s = matcher.group();
            List<String> charsList = getCharsList(s);
            List<String> afterCharsList = new LinkedList<>();
            List<String> beforeCharsList = new LinkedList<>();
            int i = 0;
            boolean yes = false;
            for (i=0;i<list.size();i++) {
                int l = i, count = 0;
                boolean lYes = false;
                for (int k=0;k<charsList.size();k++) {
                    if (charsList.get(k).equals(list.get(l++))) {
                        count++;
                        continue;
                    }
                    break;
                }
                if (count == charsList.size()) {
                    yes = true;
                    break;
                }
            }
            //计算结果
            if (yes) {
                beforeCharsList.addAll(charsList);
                beforeCharsList.remove(0);
                beforeCharsList.remove(beforeCharsList.size() - 1);
                List<String> afterList = new LinkedList<>();
                afterList.addAll(list);
//                afterCharsList.addAll(beforeCharsList);
                //删除原来位置的元素
                afterList.subList(i, i+charsList.size()).clear();
                afterList.add(i, "" + simpleHandle(beforeCharsList));
                return handle(afterList);
            } else {
                return 0;
            }

//            System.out.println(matcher.group());
//            System.out.println(matcher.start());
//            System.out.println(matcher.end());
        }

        return simpleHandle(list);
    }

    public static int simpleHandle(List<String> list) {
        Integer i1 = 0;
        Integer i2 = 0;
        Integer i3 = 0;
        int j = 0;
        if (list.size() <= 1) {
            String s = list.get(0);
            return Integer.valueOf(s);
        }
        //遍历乘法和除法
        List<String> afterList = new LinkedList<>();
        afterList.addAll(list);
        //匹配+、-、*、/四种算数
        if (list.contains("*")) {
            j = list.indexOf("*");
            i1 = Integer.valueOf(list.get(j - 1));
            i2 = Integer.valueOf(list.get(j + 1));
            i3 = i1 * i2;
            afterList.subList(j-1, j+2).clear();
            afterList.add(j - 1, "" + i3);
            //删除对应位置元素
//            afterList.remove(list.get(j-1));
//            afterList.remove(list.get(j));
//            afterList.remove(list.get(j+1));
            //递归
            return handle(afterList);
        }
        if (list.contains("/")) {
            j = list.indexOf("/");
            i1 = Integer.valueOf(list.get(j - 1));
            i2 = Integer.valueOf(list.get(j + 1));
            i3 = i1 / i2;
            afterList.subList(j-1, j+2).clear();
            afterList.add(j - 1, "" + i3);
            //删除对应位置元素
//            afterList.remove(list.get(j-1));
//            afterList.remove(list.get(j));
//            afterList.remove(list.get(j+1));
            //递归
            return handle(afterList);
        }
        if (list.contains("+")) {
            j = list.indexOf("+");
            i1 = Integer.valueOf(list.get(j - 1));
            i2 = Integer.valueOf(list.get(j + 1));
            i3 = i1 + i2;
            afterList.subList(j-1, j+2).clear();
            afterList.add(j - 1, "" + i3);
            //删除对应位置元素
//            afterList.remove(list.get(j-1));
//            afterList.remove(list.get(j));
//            afterList.remove(list.get(j+1));
            //递归
            return handle(afterList);
        }
        if (list.contains("-")) {
            j = list.indexOf("-");
            i1 = Integer.valueOf(list.get(j - 1));
            i2 = Integer.valueOf(list.get(j + 1));
            i3 = i1 - i2;
            afterList.subList(j-1, j+2).clear();
            afterList.add(j - 1, "" + i3);
            //删除对应位置元素
//            afterList.remove(list.get(j-1));
//            afterList.remove(list.get(j));
//            afterList.remove(list.get(j+1));
            //递归
            return handle(afterList);
        }
        return 0;
    }

    public static int orderHandle(List<String> list) {
        Integer i1 = 0;
        Integer i2 = 0;
        Integer i3 = 0;
        int j = 0;
        if (list.size() <= 1) {
            String s = list.get(0);
            return Integer.valueOf(s);
        }
        //遍历乘法和除法
        List<String> afterList = new LinkedList<>();
        afterList.addAll(list);
        //匹配+、-、*、/四种算数
        List<String> fuhao = new ArrayList<>();
        list.stream().forEach(o -> {
            if ("+".equals(o) || "-".equals(o) || "*".equals(o) || "/".equals(o)) {
                fuhao.add(o);
            }
        });
        String s = fuhao.get(0);
        j = list.indexOf(s);
        i1 = Integer.valueOf(list.get(j - 1));
        i2 = Integer.valueOf(list.get(j + 1));
        switch (s) {
            case "*":
                i3 = i1 * i2;
                break;
            case "/":
                i3 = i1 / i2;
                break;
            case "+":
                i3 = i1 + i2;
                break;
            case "-":
                i3 = i1 - i2;
                break;
        }
        afterList.subList(j-1, j+2).clear();
        afterList.add(j - 1, "" + i3);
        //递归
        return orderHandle(afterList);

    }
}
