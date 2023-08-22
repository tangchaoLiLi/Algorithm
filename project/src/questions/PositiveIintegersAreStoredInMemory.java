package questions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：
 * 5
 * 复制
 * 输出：
 * 2
 * 复制
 * 示例2
 * 输入：
 * 0
 * 复制
 * 输出：
 * 0
 */
public class PositiveIintegersAreStoredInMemory {
    public static void main(String[] args) {
        System.out.println("请输入整数：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = Integer.toBinaryString(i);
        List<String> collect = Arrays.asList(s.split("")).stream().filter(o -> "1".equals(o)).collect(Collectors.toList());
        //输出
        System.out.println("输出：" + collect.size());
    }
}
