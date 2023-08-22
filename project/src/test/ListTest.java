package test;

/**
 * 测试列表工具
 */
import java.util.*;
import java.util.stream.IntStream;

public class ListTest {
    public static void main(String[] args) {
        /**
         * 使用子字符串工具，subList方法
         */
        List<String> list = new LinkedList<>(){
            {
                add("Tangchao");
                add("ggdialj.");
                add("tangchao");
                add("tchao");
                add("tango");
            }
        };
        //截取位置1-4之间的元素，包括1，不包括4
        List<String> sublist = list.subList(1,4);
//        sublist.stream().forEach(o -> {
//            System.out.println(o + " ");
//        });
//        System.out.println();
//        //清空列表
//        sublist.clear();
//        //遍历原列表，发现子列表修改之后，原列表的元素是同步修改的，修改之后的元素个数为：2
//        list.stream().forEach(o -> {
//            System.out.println(o + " ");
//        });
        List<String> newSubList = new LinkedList<>(sublist);
        newSubList.clear();
        //重新遍历原来的列表
        list.stream().forEach(o -> {
            System.out.println(o + " ");
        });
        System.out.println("newSubList size = " + newSubList.size());
        //使用IntStream方法，可以实现同步遍历
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{10,11,8,7};
        int[] arr3 = new int[4];
        IntStream.range(0, arr2.length).forEach(o ->{
            arr3[o] = arr1[o] + arr2[o];
        });
        //输出
        Arrays.stream(arr3).forEach(o -> {
            System.out.println("结果：" + o);
        });
        int[] ints = Arrays.stream(arr3).distinct().toArray();
        System.out.println("去重个数：" + ints.length + " , 结果：" + Arrays.stream(ints).average());

    }
}
