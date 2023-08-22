package questions;

import java.util.*;

/**
 *
 *描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 数据范围：每组输入的字符串长度满足 1\le n \le 10000 \1≤n≤10000  ，坐标保证满足 -2^{31} \le x,y \le 2^{31}-1 \−2
 * 31
 *  ≤x,y≤2
 * 31
 *  −1  ，且数字部分仅含正数
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 示例1
 * 输入：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 复制
 * 输出：
 * 10,-10
 * 复制
 * 示例2
 * 输入：
 * ABC;AKL;DA1;
 * 复制
 * 输出：
 * 0,0
 */
public class CoordinateShift {
    public static void main(String[] args) {
        System.out.println("请输入坐标移动动作，中间用分号隔开：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(";");
        List<String> strings = Arrays.asList(split);
        Iterator<String> iterator = strings.iterator();
        Map<Integer, Map.Entry<Integer, Integer>> map = new TreeMap<>() {
            {
                put(0, new AbstractMap.SimpleEntry<>(0, 0));
            }
        };
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("".equals(next)) {
                continue;
            }
            char c = next.charAt(0);
            Integer value = 0;
            try {
                value = Integer.valueOf(next.substring(1, next.length()));
            } catch (Exception e) {
                continue;
            }
            switch (c) {
                case 'A':
                    Map.Entry<Integer, Integer> entry = map.get(0);
                    Integer key = entry.getKey();
                    Integer value1 = entry.getValue();
                    key -= value;
                    Map.Entry<Integer, Integer> newEntry = new AbstractMap.SimpleEntry<>(key, value1);
                    map.put(0, newEntry);
                    break;
                case 'D':
                    Map.Entry<Integer, Integer> entry1 = map.get(0);
                    Integer key1 = entry1.getKey();
                    Integer value2 = entry1.getValue();
                    key1 += value;
                    Map.Entry<Integer, Integer> newEntry1 = new AbstractMap.SimpleEntry<>(key1, value2);
                    map.put(0, newEntry1);
                    break;
                case 'W':
                    Map.Entry<Integer, Integer> entry2 = map.get(0);
                    Integer key2 = entry2.getKey();
                    Integer value3 = entry2.getValue();
                    value3 += value;
                    Map.Entry<Integer, Integer> newEntry2 = new AbstractMap.SimpleEntry<>(key2, value3);
                    map.put(0, newEntry2);
                    break;
                case 'S':
                    Map.Entry<Integer, Integer> entry3 = map.get(0);
                    Integer key3 = entry3.getKey();
                    Integer value4 = entry3.getValue();
                    value4 -= value;
                    Map.Entry<Integer, Integer> newEntry3 = new AbstractMap.SimpleEntry<>(key3, value4);
                    map.put(0, newEntry3);
                    break;
            }
        }
        //输出
        System.out.println("输出：" + map.get(0).getKey() + "," + map.get(0).getValue());
    }
}
