package questions;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * 75. 颜色分类
 * 提示
 * 中等
 * 1.6K
 * 相关企业
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 *
 * 进阶：
 *
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class ColorClassifier {
    /**
     * 处理方法，用于对数组元素int元素排序
     */
    public int[] sortArray(int[] array) {
        int[] array1 = Arrays.stream(array).boxed().sorted().mapToInt(Integer::valueOf).toArray();
        return array1;
    }
    public static void main(String[] args) {
        ColorClassifier classifier = new ColorClassifier();
        int[] arr1 = new int[]{2,0,2,1,1,0};
        int[] arr2 = new int[]{2,0,1};

        System.out.println("结果：" + Arrays.stream(classifier.sortArray(arr1)).boxed().map(i -> Integer.toString(i)).reduce("", (a, b) -> a + "," + b));
        System.out.println("结果：" + Arrays.stream(classifier.sortArray(arr2)).boxed().map(i -> Integer.toString(i)).reduce("", (a, b) -> a + "," + b));
    }
}
