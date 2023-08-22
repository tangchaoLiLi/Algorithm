package questions;

import java.util.*;

/**
 *
 */
public class StringSorting2 {
    public static void main(String[] args) {
        String str = "A Famous Saying: Much Ado About Nothing (2012/8).";
        String res = "";
        char[] chars = str.toCharArray();
        Map<Integer, Character> xiabiao = new HashMap<>();
        List<Character> chars2 = new ArrayList<>();
        for (int i=0;i<chars.length;i++) {
            char c = chars[i];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                chars2.add(chars[i]);
            } else {
                xiabiao.put(i, c);
            }
        }
        //排序
        Collections.sort(chars2, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                Character tmp1, tmp2;
                if (o1 >= 'A' && o1 <= 'Z') {
                    tmp1 = Character.valueOf((char) (o1.charValue() + 32));
                } else {
                    tmp1 = o1;
                }
                if (o2 >= 'A' && o2 <= 'Z') {
                    tmp2 = Character.valueOf((char) (o2.charValue() + 32));
                } else {
                    tmp2 = o2;
                }
                if (tmp1 > tmp2) {
                    return 1;
                } else if (tmp1 == tmp2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        //输出排序后的结果
        char[] resArray = new char[chars.length];
        //添加分隔符，按原来的位置
        Iterator<Map.Entry<Integer, Character>> iterator = xiabiao.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Character> next = iterator.next();
            Integer key = next.getKey();
            Character value = next.getValue();
            resArray[key.intValue()] = value;
        }
        int p = 0;
        for (int n=0;n<resArray.length;n++) {
            //填入排序好的元素
            Set<Integer> values = xiabiao.keySet();
            if (values.contains(n)) {
                continue;
            }
            resArray[n] = chars2.get(p++);
        }
        //输出
        for (int u=0;u<resArray.length;u++) {
            res += resArray[u];
        }
        System.out.println("结果： " + res);
    }
}
