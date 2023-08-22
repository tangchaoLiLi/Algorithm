package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTest {
    public static void main(String[] args) {
        String str = "tangchaolili";
        List<Character> chars = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            chars.add(ch);
        }
        //遍历
        chars.stream().forEach(o -> {
            System.out.print(o + " ");
        });
        System.out.println();
        //分组，强力推荐使用该方法，
        Map<Character, List<Character>> collect = chars.stream().collect(Collectors.groupingBy(Character::valueOf));
        //遍历1，
        Iterator<Map.Entry<Character, List<Character>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, List<Character>> next = iterator.next();
            System.out.println("" + next.getKey() + " : " + next.getValue().size());
        }
        //遍历2，按照顺序整理分组的顺序
        List<Map.Entry<Character, List<Character>>> mList = new ArrayList<>();
        chars.stream().forEach(o -> {
            collect.entrySet().forEach(p -> {
                if (p.getKey() == o) {
                    mList.add(p);
                }
            });
        });
        //去重，可以用两种方法，第一种distinct方法去重，第二种LinkedHashSet转ArrayList，都可以保持原来列表中的元素顺序不变
//        List<Map.Entry<Character, List<Character>>> collect1 = mList.stream().distinct().collect(Collectors.toList());
//        List<Map.Entry<Character, List<Character>>> collect1 = mList.stream().distinct().collect(Collectors.toList());
        Set<Map.Entry<Character, List<Character>>> setWithoutDuplicates = new LinkedHashSet<>(mList);
        List<Map.Entry<Character, List<Character>>> collect1 = new ArrayList<>(setWithoutDuplicates);
        collect1.stream().forEach(o -> {
            System.out.print(o.getKey() + "," + o.getValue().size() + " ");
        });
        System.out.println();
        //链表列表创建
        LinkedList<String> linkList = new LinkedList<>() {
            {
                add("3");
                add("2");
                add("1");
                add("2");
                add("3");
                add("4");
            }
        };
        //双向链表
        Deque<String> deque = new ArrayDeque<>(linkList);
        //头部尾部操作
//        deque.removeLast();
//        deque.removeLast();
//        deque.removeLast();
//        deque.pollLast();
//        deque.push("5");
//        deque.addLast("6");
        deque.addLast("5");
        deque.addLast("6");
        deque.push("7");
        deque.push("8");
        System.out.println(deque.peekLast());
        deque.stream().forEach(o -> {
            System.out.print(o + ",");
        });
        System.out.println();
        //栈
        Stack<String> stack = new Stack<>();
        stack.push("100");
        stack.push("200");
        stack.push("300");
        stack.push("400");
        stack.push("500");
        //遍历
        stack.stream().forEach(o -> {
            System.out.print(o + ",");
        });
        System.out.println();
        //栈的操作
        stack.pop();
        stack.pop();
        stack.push("600");
        stack.push("700");
        stack.stream().forEach(o -> {
            System.out.print(o + ",");
        });
    }
}
