package test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.*;
import java.util.stream.*;

/**
 * 创建阻塞列表队列 LinkedBlockingQueue
 * 进队列：add
 * 出队列：take
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("tangchao");
        queue.add("gege");
        queue.add("meimei");

        /**
         * 开线程，轮询执行添加元素
         */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String str = "";
//                try {
//                    while ((str = queue.take()) != null) {
//                        System.out.println("结果：" + str);
//                    }
//                } catch(InterruptedException e){
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();


        queue.add("baba");
        queue.add("mama");
        queue.add("nainai");

        /**
         * 手动输入字符串
         */
        System.out.println("请手动输入需要添加的字符串：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            queue.add(scanner.nextLine());
            /**
             * 寻找字符串列表中重复字符最少的字符串
             */
            List<String> collect = queue.stream().collect(Collectors.toList());
            int[] ints = queue.stream()
                    .mapToInt(o -> o.chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList()).size()).toArray();
            /**
             * 通过映射获取对应的长度数组
             */
            int reduce = Arrays.stream(ints).reduce(0, (a, b) -> a > b ? a : b);
            int i1 = IntStream.range(0, ints.length).filter(i -> ints[i] == reduce)
                    .findFirst().orElse(-1);
            System.out.println("最长的不重复字符的字符串长度为：" + reduce + ", 字符串为：" + collect.get(i1));
        }
    }
}
