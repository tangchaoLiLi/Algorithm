package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * 78. 子集
 * 中等
 * 2.1K
 * 相关企业
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class SubCollection {
    public static void main(String[] args) {
        int[] array = new int[] {1};
        List<int[]> list = new LinkedList<>();
        //创建类的实例
        SubCollection object = new SubCollection();
        //循环执行，获取不同长度的集合
        for (int i=1;i<=array.length;i++) {
            object.handle(array, 0, i, list);
        }
        //添加长度为0的组合
        list.add(new int[]{});
        //输出当前所有的组合
        System.out.println("结果：" + list.size());
    }

    public void handle(int[] array, int n, int subLength, List<int[]> list){
        if (n == array.length) {
            //截取subLength长度的int[]
            int[] subArray = Arrays.stream(Arrays.copyOf(array, subLength)).sorted().toArray();
            List<int[]> arrs = new LinkedList<>();
            for (int i=0;i<list.size();i++) {
                //计算当前list中所有长度为subLength的元素
                int[] itemArray = list.get(i);
                if (itemArray.length == subArray.length) {
                    arrs.add(itemArray);
                }
            }
            //遍历arrs中的元素
            int count = 0;
            for (int j=0;j<arrs.size();j++) {
                int sameLength = 0;
                int[] itemArray2 = arrs.get(j);
                for (int k=0;k<subArray.length;k++) {
                    if (subArray[k] == itemArray2[k]) sameLength++;
                }
                if (sameLength == subArray.length) break;
                count++;
            }
            if (count == arrs.size()) list.add(subArray);
            return;
        }

        for (int p=n;p<array.length;p++) {
            if (check(array, n, p)) {
                swap(array, n, p);
                handle(array, n+1, subLength, list);
                swap(array, n, p);
            }
        }
    };

    public boolean check(int[] array, int start, int end) {
        boolean flag = true;
        for (int i=start;i<end;i++) {
            if (array[i] == array[end]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
