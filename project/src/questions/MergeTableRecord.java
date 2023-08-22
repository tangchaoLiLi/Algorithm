package questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 *0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 复制
 * 输出：
 * 0 3
 * 1 2
 * 3 4
 * 复制
 * 示例2
 * 输入：
 * 3
 * 0 1
 * 0 2
 * 8 9
 * 复制
 * 输出：
 * 0 3
 * 8 9
 */
public class MergeTableRecord {
    public static void main(String[] args) {
        System.out.println("请输入键值对个数：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("请输入键值对，中间用空格隔开");
        int n = 0;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        while (n<i) {
            String s = scanner.nextLine();
            if (s.equals("")) {
                continue;
            }
            String[] s1 = s.split(" ");
            int i1 = Integer.parseInt(s1[0]);
            int i2 = Integer.parseInt(s1[1]);
            Map.Entry<Integer,Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(i1, i2);;
            list.add(entry);
            n++;
        }
        //统计并输出
        Map<Integer, Integer> map1 = new TreeMap<>();
        Iterator<Map.Entry<Integer, Integer>> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator1.next();
            if (map1.containsKey(next.getKey())) {
                Integer integer = map1.get(next.getKey());
                map1.put(next.getKey(), next.getValue() + integer);
                continue;
            }
            map1.put(next.getKey(), next.getValue());
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
        String res = "";
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            res += next.getKey() + " " + next.getValue() + "\n";
        }
        System.out.println("输出：" + res);
    }
}
