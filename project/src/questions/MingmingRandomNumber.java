package questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \1≤val≤500
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 *
 * 示例1
 * 输入：
 * 3
 * 2
 * 2
 * 1
 * 复制
 * 输出：
 * 1
 * 2
 * 复制
 * 说明：
 * 输入解释：
 * 第一个数字是3，也即这个小样例的N=3，说明用计算机生成了3个1到500之间的随机整数，接下来每行一个随机数字，共3行，也即这3个随机数字为：
 * 2
 * 2
 * 1
 * 所以样例的输出为：
 * 1
 * 2
 */
public class MingmingRandomNumber {
    public static void main(String[] args) {
        System.out.println("请输入需要输入的数的数目：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(String.format("请输入%d个整数，按行输入", i));
//        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int n = 0;
        while (n<i) {
            list.add(scanner.nextInt());
            n++;
        }
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        String res = "";
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            res += next.intValue() + "\n";
        }
        System.out.println("输出：" + res);
    }
}
