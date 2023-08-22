package questions;
import java.util.*;
import java.util.regex.*;
public class OuputSmallestK {
    public static void main(String[] args) {
        String[] arrs = new String[] {
                "5 3",
                "1 3 5 7 2"
        };
        //遍历并排序
        String regex = "[\\s]+";
        String[] strings = arrs[1].split(regex);
        Arrays.sort(strings);
        Arrays.asList(strings).subList(0, Integer.valueOf(arrs[0].split(regex)[1])).stream().forEach(o -> {
            System.out.print(o + " ");
        });
    }
}
