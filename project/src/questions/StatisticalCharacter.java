package questions;

import java.util.regex.*;
/**
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 *
 * 输入描述：
 * 输入一行字符串，可以有空格
 *
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 *
 * 示例1
 * 输入：
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 复制
 * 输出：
 * 26
 * 3
 * 10
 * 12
 */
public class StatisticalCharacter {
    public static void main(String[] args) {
        String str = "1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\\\/;p0-=\\\\][";
        int n=0;
        int x=0,y=0,z=0,r=0;
        do {
            char c = str.charAt(n);
            //统计英文字母
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                x += 1;
                continue;
            }
            //统计空格符
            if (' ' == c) {
                y++;
                continue;
            }
            //数字字符
            if (c >= '0' && c <= '9') {
                z++;
                continue;
            }
            //统计其他字符个数
            r++;
        } while (++n<str.length());
        System.out.println("结果：" + str.length());
        System.out.println("结果：" + x);
        System.out.println("结果：" + y);
        System.out.println("结果：" + z);
        System.out.println("结果：" + r);

        //模式匹配给指定位置赋值
        String sqlStr = "select count(*) from table where a = @{1} and b = @{2} and c =@{3}";
//        String regex = "select\\s+count\\((\\*|[a-zA-z1-9.]+)\\)\\s+from.*";
//        String regex = "select[\\s]+(.*)[\\s]+from[\\s]+where[\\s]+(.*)";
        String regex = "select[\\s]+(.*)[\\s]+from[\\s]+(.*)[\\s]+where[\\s]+(.*)";
        Pattern pp = Pattern.compile(regex);
        Matcher matcher = pp.matcher(sqlStr);
        if (matcher.find()) {
            String set = matcher.group(1);
            String tableName = matcher.group(2);
            String whereCondition = matcher.group(3);
            //使用分隔符获取填充位置
            String regex2 = "@\\{\\d+\\}";
            String regex3 = ".*(@\\{\\d+\\}).*(@\\{\\d+\\}).*(@\\{\\d+\\})";
            Pattern pp2 = Pattern.compile(regex2);
            Pattern pp3 = Pattern.compile(regex3);
            String[] split = pp2.split(whereCondition);
            Matcher matcher1 = pp3.matcher(whereCondition);
            System.out.println("分割后的结果：" + split.length);
            if (matcher1.find()) {
                System.out.println("子项目：" + matcher1.group(1));
                System.out.println("子项目：" + matcher1.group(2));
                System.out.println("子项目：" + matcher1.group(3));
            }
            System.out.println();
        }

    }
}
