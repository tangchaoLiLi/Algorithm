package questions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述
 * IP地址是由4个0-255之间的整数构成的，用"."符号相连。
 * 二进制的IP地址格式有32位，例如：10000011，01101011，00000011，00011000;每八位用十进制表示就是131.107.3.24
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，由1和0组成，且1和0分别连续，其中网络号部分全为“1”和主机号部分全为“0”。
 * 你可以简单的认为子网掩码是一串连续的1和一串连续的0拼接而成的32位二进制数，左边部分都是1，右边部分都是0。
 * 利用子网掩码可以判断两台主机是否在同一子网中。
 * 若两台主机的IP地址分别与它们的子网掩码进行逻辑“与”运算（按位与/AND）后的结果相同，则说明这两台主机在同一子网中。
 *
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　  11000000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算   11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 *
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11000000.10101000.00000000.11111110
 * 子网掩码  11111111.11111111.11111111.00000000
 *
 * AND运算  11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 *
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 *
 * 注:
 * 有效掩码与IP的性质为：
 * 1. 掩码与IP每一段在 0 - 255 之间
 * 2. 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由'0'组成
 *
 * 输入描述：
 * 3行输入，第1行是输入子网掩码、第2，3行是输入两个ip地址
 * 题目的示例中给出了三组数据，但是在实际提交时，你的程序可以只处理一组数据（3行）。
 *
 * 输出描述：
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
 */
public class BelongToTheSameSubnet {
    public final static int A = 1;
    public final static int B = 1<<1;
    public final static int C = 1<<2;

    public static void main(String[] args) {
        List<String> ips = new ArrayList<>();
        ips.add("255.255.255.0 192.168.224.256 192.168.10.4");
        ips.add("255.0.0.0 193.194.202.15 232.43.7.59");
        ips.add("255.255.255.0 192.168.0.254 192.168.0.1");

        for (int i=0;i<ips.size();i++) {
            String regex = " ";
            Pattern pattern = Pattern.compile(regex);
            String[] split = pattern.split(ips.get(i));
            int subnetMaskType = getIpSubnetMask(split[0]);
            switch (subnetMaskType) {
                case A:
                    String s = split[1].split("\\.")[0];
                    int i1 = Integer.parseInt(s);
                    if (i1 > 127) {
                        System.out.println("结果： " + 2);
                    }
                    break;
                case B:

                    break;
                case C:

                    break;
                default:
                    break;
            }
        }
    }
    /**
     * 判断ABC哪种类型的掩码
     *
     */
    private static int getIpSubnetMask (String subnetMask) {
        int type = 0;
        //A类型
//        String aRegex = "([\\d]{1,}).([\\d]{1,}).([\\d]{1,}).([\\d]{1,})";
        String aRegex = "([\\d]*).([\\d]*).([\\d]*).([\\d]*)";
        Pattern pattern = Pattern.compile(aRegex);
        Matcher matcher = pattern.matcher(subnetMask);
        if (matcher.find()) {
//            String group1 = matcher.group(1);
//            String group2 = matcher.group(2);
//            String group3 = matcher.group(3);
//            String group4 = matcher.group(4);
            //A类型
            int count=0;
            for (int i=1;i<=4;i++) {
                switch (matcher.group(i)) {
                    case "255":
                        count++;
                        break;
                    default:
                        break;
                }
            }
            type = count == 3? C : count == 2? B : A;
        }
        //B类型

        //C类型

        return type;
    }
}
