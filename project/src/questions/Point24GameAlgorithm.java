package questions;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * HJ67 24点游戏算法
 * 题目
 * 题解(219)
 * 讨论(292)
 * 排行
 * 面经new
 * 中等  通过率：34.48%  时间限制：1秒  空间限制：32M
 * 知识点
 * dfs
 * 搜索
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
 * 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
 * 输入描述：
 * 读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 *
 * 输出描述：
 * 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 *
 * 示例1
 * 输入：
 * 7 2 1 10
 * 复制
 * 输出：
 * true
 */
public class Point24GameAlgorithm {
    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{7, 2, 1, 10};
//        Integer[] arr = new Integer[]{1, 1, 5, 8};
        Integer[] arr = new Integer[]{4, 2, 13, 1};
        List<Integer> list = Arrays.asList(arr);
        list.stream().forEach(o -> {
            System.out.println("结果：" + o);
        });
        //字符数组
//        Character[] characters = new Character[]{'a','c','e'};
//        List<Character> characters1 = Arrays.asList(characters);
//        characters1.stream().forEach(o -> {
//            System.out.println("结果：" + o);
//        });
        //调用计算函数
        System.out.println("结果：" + isPoint24Ok(arr));
    }
    /**
     * 定义24点计算函数
     * @param arr
     */
    public static boolean isPoint24Ok(Integer[] arr) {
        //数字数组
        Arrays.stream(arr).forEach(o -> {
            arr_str += "" + o + ",";
        });
        //符号数组
        Character[] fuhao = new Character[]{'+','-','*','/'};
        System.out.println("数组：" + arr.length+ "，内容：" + arr_str);
        boolean ok = false;
        //调用获取算数表达式组合
        List<List<String>> allZuhe = getAllZuhe(arr, fuhao);
        //判断是否有符合的结果
        ok = allZuhe.stream().anyMatch(o -> 24 == ExpressionEvaluation.orderHandle(o));
        final List<List<String>> result = new ArrayList<>();
        allZuhe.stream().forEach(o -> {
            if (24 == ExpressionEvaluation.orderHandle(o)) {
                result.add(o);
            }
        });
        if (result.size() > 0) {
            result.stream().forEach(o -> {
                o.stream().forEach(p -> {
                    System.out.print(p);
                });
                System.out.println();
            });
        };
        System.out.println();
        return result.size() > 0 ? true : false;
    }

    /**
     * 使用递归方法，列举出所有组合
     *
     *
     */
    public static List<List<String>> getAllZuhe(Integer[] arr1, Character[] fuhao) {
        Integer[] arr =arr1;
        Integer[] tempArr = new Integer[4];
        boolean[] isVisited = new boolean[4];
        List<List<Integer>> list = new ArrayList<>();

        Character[] arr2 =fuhao;
        Character[] tempArr2 = new Character[4];
        boolean[] isVisited2 = new boolean[4];
        List<List<Character>> list2 = new ArrayList<>();

        listAllSequences(arr, tempArr, isVisited, 0, list);
        listAllSequences(arr2, tempArr2, isVisited2, 0, list2);

        List<List<String>> stringsList = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            for (int j=0;j<list2.size();j++) {
                List<Integer> list1 = list.get(i);
                List<Character> characters = list2.get(j);
                List<String> strings = new ArrayList<>();
                int l=0;
                String biaodashi = "";
                for (int k=0;k<list1.size();k++) {
                    strings.add("" + list1.get(k));
                    biaodashi += "" + list1.get(k);
                    if (l < 3) {
                        strings.add("" + characters.get(l));
                        biaodashi += "" + characters.get(l);
                        l++;
                    }
                }
                System.out.println("结果：" + biaodashi);
                stringsList.add(strings);
            }
        }
        return stringsList;
    }

    /**
     * 添加数组，长度1-4之间
     *
     */
    public static void listAllSequences(Integer[] arr, Integer[] tempArr, boolean[] isVisited, int index, List<List<Integer>> list) {
        if (index == arr.length) {
            List<Integer> tmpList = new ArrayList<>();
            // 输出当前的排列
            for (int i : tempArr) {
//                System.out.print(i + " ");
                tmpList.add(i);
            }
//            System.out.println();
            list.add(tmpList);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!isVisited[i]) {
                tempArr[index] = arr[i];
                isVisited[i] = true;
                listAllSequences(arr, tempArr, isVisited, index + 1, list);
                isVisited[i] = false;
            }
        }
    }
    /**
     * 添加数组，+ - * /符号
     *
     */
    public static void listAllSequences(Character[] arr, Character[] tempArr, boolean[] isVisited, int index, List<List<Character>> list) {
//        if (index == arr.length) {
//            List<Character> tmpList = new ArrayList<>();
//            // 输出当前的排列
//            for (Character i : tempArr) {
////                System.out.print(i + " ");
//                tmpList.add(i);
//            }
////            System.out.println();
//            list.add(tmpList);
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (!isVisited[i]) {
//                tempArr[index] = arr[i];
//                isVisited[i] = true;
//                listAllSequences(arr, tempArr, isVisited, index+1, list);
//                isVisited[i] = false;
//            }
//        }
        // 四个操作数的所有组合
        for (char operator1 : arr) {
            for (char operator2 : arr) {
                for (char operator3 : arr) {
//                        System.out.println(operator1 + " " + operator2 + " " + operator3 + " " + operator4);
                    List<Character> characters = new ArrayList<>();
                    characters.add(operator1);
                    characters.add(operator2);
                    characters.add(operator3);
                    list.add(characters);
            }
            }
        }

    }
    static String arr_str = "";
}
