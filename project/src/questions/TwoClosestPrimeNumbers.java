package questions;
import java.util.*;
import java.util.regex.*;

/**
 * HJ60 查找组成一个偶数最接近的两个素数
 * 题目
 * 题解(352)
 * 讨论(485)
 * 排行
 * 面经new
 * 简单  通过率：43.55%  时间限制：1秒  空间限制：32M
 * 知识点
 * 查找
 * 基础数学
 * 穷举
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 数据范围：输入的数据满足 4 \le n \le 1000 \4≤n≤1000
 * 输入描述：
 * 输入一个大于2的偶数
 *
 * 输出描述：
 * 从小到大输出两个素数
 *
 * 示例1
 * 输入：
 * 20
 * 复制
 * 输出：
 * 7
 * 13
 * 复制
 * 示例2
 * 输入：
 * 4
 * 复制
 * 输出：
 * 2
 * 2
 */
public class TwoClosestPrimeNumbers {
    public static void main(String[] args) {
        int n = 28;
        List<Integer> list = getAllPrimeNumbers(n);
        list.stream().forEach(o -> {
            System.out.println("结果：" + o);
        });
        System.out.println();
        //找出所有素数对
        Map<Integer, Integer> map = new LinkedHashMap<>(){
            {
                for (int i=0;i<list.size();i++) {
                    Integer integer = list.get(i);
                    Integer integer1 = n - integer;
                    if (list.contains(integer1) && list.contains(integer)) {
                        put(integer, integer1);
                    }
                }
            }
        };
        //计算出结果
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        Map.Entry<Integer, Integer> result = new AbstractMap.SimpleEntry<>(0,20);
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            int abs = Math.abs(key - value);
            int abs1 = Math.abs(result.getKey() - result.getValue());
            if (abs1 - abs > 0) {
                result = new AbstractMap.SimpleEntry<>(key, value);
            }
        }
        //输出结果
        System.out.println("结果：" + result.getKey() + "," + result.getValue());
    }
    /**
     * 找出数字n的所有质数（素数）
     * @param n 需要查找的元素
     */
    public static List<Integer> getAllPrimeNumbers(int n) {
        List<Integer> list = new LinkedList<>();
        int i=2;
        do {
            if (isPrime(i)) {
                list.add(i);
            }
        } while(i++ < n);
        return list;
    }
    /**
     * 判断x是否为素数
     *
     */
    public static boolean isPrime(int x) {
        boolean res = false;
        int i=2;
        do {
            if (x % i == 0) {
                break;
            }
        } while (i++ < x);
        if (i == x) {
            res = true;
        }
        return res;
    }
}
