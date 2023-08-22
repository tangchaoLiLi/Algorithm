package questions;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * 描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 数据范围：字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
 *
 * 输入描述：
 * 一个只包含小写英文字母和数字的字符串。
 *
 * 输出描述：
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 *
 * 示例1
 * 输入：
 * aaddccdc
 * 复制
 * 输出：
 * cda
 * 复制
 * 说明：
 * 样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
 */
public class CharacterStatistics {
    public static void main(String[] args) {
        System.out.println("输入检查的字符串：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] array = line.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c : array) {
            list.add(c);
        }
        //去重之后的Set
        LinkedHashSet<Character> set = new LinkedHashSet<>(list);
        List<Character> newList = new ArrayList<>(set);
        Map<Character, Integer> map = new TreeMap<>();
        for (Character character : newList) {
            int num = 0;
            for (int i=0;i<array.length;i++) {
                if (character == array[i]) {
                    num++;
                }
            }
            map.put(character, num);
        }
        List<Map.Entry<Character, Integer>> entries = map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o2.getValue() == o1.getValue() && o1.getKey() > o2.getKey()) {
                    return 1;
                }
                return 0;
            }
        });
        String res = "";
        for (Map.Entry<Character, Integer> entry : entries) {
            res += entry.getKey();
        }
        System.out.println(res);
    }
}
