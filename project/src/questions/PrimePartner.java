package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入:
 *
 * 有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
 *
 * 输出:
 *
 * 输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 *
 * 数据范围： 1 \le n \le 100 \1≤n≤100  ，输入的数据大小满足 2 \le val \le 30000 \2≤val≤30000
 * 输入描述：
 * 输入说明
 * 1 输入一个正偶数 n
 * 2 输入 n 个整数
 *
 * 输出描述：
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 示例1
 * 输入：
 * 4
 * 2 5 6 13
 * 复制
 * 输出：
 * 2
 * 复制
 * 示例2
 * 输入：
 * 2
 * 3 6
 * 复制
 * 输出：
 * 0
 */
public class PrimePartner {
    /**
     * 定义键值对组合的类
     */
    static class PrimeUtil {
        private static PrimeUtil util;
        public static PrimeUtil getInstance() {
            if (null == util) {
                synchronized (PrimeUtil.class) {
                    if (null == util) {
                        util = new PrimeUtil();
                    }
                }
            }
            return util;
        }
        //默认不能使用构造器创建
        private PrimeUtil(){}
        private List<Integer> mList = new ArrayList<>();
        private List<List<KeyValue>> fangan = new ArrayList<>();
        private List<KeyValue> tmpKV = new ArrayList<>();
        /**
         * 内部类，两个参数：x和y
         */
        static class KeyValue {
            public int x;
            public int y;
            public KeyValue(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        //添加排序元素
        public PrimeUtil addDatas (int[] datas) {
            for (int i=0;i<datas.length;i++) {
                mList.add(datas[i]);
            }
            return this;
        }
        //分组
        public List<List<KeyValue>> getKeyValues() {
            for (int i=0;i<mList.size();i++) {
                doKeyValue(mList, i);
            }

            return fangan;
        }
        public void doKeyValue(List<Integer> list, int start) {
            if (list.size() <= 1) {
                List<KeyValue> tmpKV2 = new ArrayList<>();
                for (KeyValue keyValue : tmpKV) {
                    KeyValue kv = new KeyValue(keyValue.x, keyValue.y);
                    tmpKV2.add(kv);
                }
                fangan.add(tmpKV2);
                tmpKV.clear();
                return;
            }
            List<Integer> last = new ArrayList<>();
            last.addAll(list);
            for (int i=start;i<list.size();i++) {
                for (int j=i+1;j<list.size();j++) {
                    if (i != j) {
                        KeyValue keyValue = new KeyValue(list.get(i), list.get(j));
                        tmpKV.add(keyValue);
                        //递归
                        last.remove(list.get(i));
                        last.remove(list.get(j));
                        doKeyValue(last, 0);
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {
            {
                add("2 5 6 13");
                add("3 6");
                add("3 6 4 7 8 9");
            }
        };
        int n=0;
        while(n<list.size()) {
            String s = list.get(n);
            String[] strings = s.split(" ");
            int[] nums = new int[strings.length];
            for (int i=0;i<strings.length;i++) {
                Integer integer = Integer.valueOf(strings[i]);
                nums[i] = integer;
            }
            //遍历
            printAllPermutations(nums, 0);
            System.out.println("结果：" + resNum);
            n++;
            resNum = 0;
        }
    }

    /**
     * 判断是否为素数
     * @param num
     */
    public static boolean isPrime(int num) {
        if(num <=1 ) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static int resNum = 0;
    /**
     * 递归输出所有方案
     */
    public static void printAllPermutations(int[] arr, int index) {
        if(index == arr.length - 1) {
            int tmp = 0;
            for (int j=0;j<arr.length;j+=2) {
                boolean res = isPrime(arr[j] + arr[j+1]);
                tmp += res ? 1 : 0;
            }
            resNum = tmp > resNum ? tmp : resNum;
        } else {
            for(int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                Arrays.sort(arr, index + 1, arr.length);
                printAllPermutations(arr, index + 1);
                swap(arr, index, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
