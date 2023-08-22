package questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：
 * aabcddd
 * 复制
 * 输出：
 * aaddd
 */
public class DeleteTheLeastFrequentCharacter {
    public static void main(String[] args) {
        String str = "aabcddd";
        List<String> collect = Arrays.asList(str.split("")).stream().distinct().collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        Iterator<String> iterator = collect.iterator();
        List<Integer> integers = new ArrayList<>();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String[] strings = str.split("");
            int count = 0;
            for (int i=0;i<strings.length;i++) {
                if (strings[i].equals(next)) {
                    count++;
                }
            }
            //输出
            integers.add(count);
            map.put(next, count);
            System.out.println("结果：" + count);
        }
        //找出最小值
        Collections.sort(integers);
        Integer integer = integers.get(0);
        List<Map.Entry<String, Integer>> collect1 = map.entrySet().stream().filter(o -> o.getValue() > integer).collect(Collectors.toList());
        Iterator<Map.Entry<String, Integer>> iterator1 = collect1.iterator();
        String res = "";
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> next = iterator1.next();
            for (int i=0;i<next.getValue();i++) {
                res += next.getKey();
            }
        }
        //输出
        System.out.println("处理后的字符串：" + res);
    }
}
