package questions;

/**
 * 将阿拉伯数字转罗马数字
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanNumerals {
    public static void main(String[] args) {
        /**
         * 1 --- I
         * 2 --- II
         * 3 --- III
         * 4 --- IV
         * 5 --- V
         * 6 --- VI
         * 7 --- VII
         * 8 --- VIII
         * 9 --- IX
         */
        int n = 1994;
        int i = 1000, j = 900, k = 90, l = 4;
        String res = "M" + "CM" + "XC" + "IV";
        System.out.println("结果：" + res);

//        n = 2765;
        i = 0;
        String s = Integer.toString(n);
        res = "";
        for (;i<s.length();i++) {
            switch (s.length() - i) {
                case 4:
                    char c = s.charAt(i);
                    res += getRomanNumber(c, 4);
                    break;
                case 3:
                    c = s.charAt(i);
                    res += getRomanNumber(c, 3);
                    break;
                case 2:
                    c = s.charAt(i);
                    res += getRomanNumber(c, 2);
                    break;
                case 1:
                    c = s.charAt(i);
                    res += getRomanNumber(c, 1);
                    break;
                default:
            }
        }
        System.out.println("结果：" + n + " --- " + res);
    }

    /**
     * 根据数字和位数来确定返回的字符串
     *
     */
    public static String getRomanNumber(char c, int w) {
        String str = "";
        switch (c) {
            case '0':
                break;
            case '1':
                switch (w) {
                    case 4:
                        str += "M";
                        break;
                    case 3:
                        str += "C";
                        break;
                    case 2:
                        str += "X";
                        break;
                    case 1:
                        str += "I";
                        break;
                }
                break;
            case '2':
                switch (w) {
                    case 4:
                        str += "MM";
                        break;
                    case 3:
                        str += "CC";
                        break;
                    case 2:
                        str += "XX";
                        break;
                    case 1:
                        str += "II";
                        break;
                }
                break;
            case '3':
                switch (w) {
                    case 4:
                        str += "MMM";
                        break;
                    case 3:
                        str += "CCC";
                        break;
                    case 2:
                        str += "XXX";
                        break;
                    case 1:
                        str += "III";
                        break;
                }
                break;
            case '4':
                switch (w) {
//                    case 4:
//                        str += "M";
//                        break;
                    case 3:
                        str += "CD";
                        break;
                    case 2:
                        str += "XL";
                        break;
                    case 1:
                        str += "IV";
                        break;
                }
                break;
            case '5':
                switch (w) {
//                    case 4:
//                        str += "M";
//                        break;
                    case 3:
                        str += "D";
                        break;
                    case 2:
                        str += "L";
                        break;
                    case 1:
                        str += "V";
                        break;
                }
                break;
            case '6':
                switch (w) {
//                    case 4:
//                        str += "M";
//                        break;
                    case 3:
                        str += "DC";
                        break;
                    case 2:
                        str += "LX";
                        break;
                    case 1:
                        str += "VI";
                        break;
                }
                break;
            case '7':
                switch (w) {
//                    case 4:
//                        str += "M";
//                        break;
                    case 3:
                        str += "DCC";
                        break;
                    case 2:
                        str += "LXX";
                        break;
                    case 1:
                        str += "VII";
                        break;
                }
                break;
            case '8':
                switch (w) {
//                    case 4:
//                        str += "M";
//                        break;
                    case 3:
                        str += "DCCC";
                        break;
                    case 2:
                        str += "LXXX";
                        break;
                    case 1:
                        str += "VIII";
                        break;
                }
                break;
            case '9':
                switch (w) {
//                    case 4:
//                        str += "M";
//                        break;
                    case 3:
                        str += "CM";
                        break;
                    case 2:
                        str += "XC";
                        break;
                    case 1:
                        str += "IX";
                        break;
                }
                break;
        }
        return str;
    }

}
