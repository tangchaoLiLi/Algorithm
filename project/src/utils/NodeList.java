package utils;

import java.util.LinkedList;
import java.util.List;

/**
 * Node基础类对应的列表类NodeList
 * 包含属性和方法：add添加，delete删除，clear清空，遍历find(从头开始），addAll全部添加
 */
public class NodeList {
    /**
     * 基础类，Node类
     * 包含属性：
     * num --- int
     * next --- Node
     */
    public static class Node {
        public int num;
        public Node next;
        public Node(int num) {
            this.num = num;
        }
    }

    private static NodeList nodeList;
    private List<Node> list = new LinkedList<>();
    private NodeListIterator iterator;
    public static NodeList getInstance() {
        if (null == nodeList) {
            synchronized (NodeList.class) {
                if (null == nodeList) {
                    nodeList = new NodeList();
                }
            }
        }
        return nodeList;
    }
    /**
     * 构造器设置成 私有，不让其创建对象
     */
    private NodeList(){
        /**
         * 创建遍历器
         */
        if (null == iterator) {
            iterator = new NodeListIterator(list);
        }
    }
    /**
     * add添加
     */
    public Node add(Node node) {
        list.add(node);
        return node;
    }
    /**
     * delete删除
     * 删除第n+1个元素
     */
    public Node delete(int n) {
        /**
         * 遍历list列表，找到第n+1个元素
         */
        if (n > list.size() - 1) {
            /**
             * 如果n的下标，大于list的长度，则返回null
             */
            return null;
        }
        Node node = null;
        for (int i=0;i<list.size();i++) {
            if (i == n) {
                node = list.get(i);
            }
        }
        /**
         * 重新创建next的Node对象
         */
        if (n > 0 && n < list.size() - 1) {
            list.get(n-1).next = list.get(n+1);
        } else if (n == 0) {
            list.get(0).next = null;
        } else if (n == list.size() - 1) {
            list.get(list.size()-1).next = null;
        }
        //删除，并返回Node对象
        list.remove(node);
        return node;
    }
    /**
     * 删除倒数第n个元素
     */
    public Node deleteEnd(int n) {
        /**
         * 遍历list列表，找到第n+1个元素
         */
        if (n < 0) {
            /**
             * 如果n的下标，小于0，则返回null
             */
            return null;
        }
        Node node = null;
        for (int i=0;i<list.size();i++) {
            if (i == list.size() - n) {
                node = list.get(i);
            }
        }
        /**
         * 重新创建next的Node对象
         */
        if (n > 0 && n < list.size() - 1) {
            list.get(n-1).next = list.get(n+1);
        } else if (n == 0) {
            list.get(list.size() - 1).next = null;
        } else if (n == list.size() - 1) {
            list.get(0).next = null;
        }
        //删除，并返回Node对象
        list.remove(node);
        return node;
    }
    /**
     * deleteAll删除所有list中的元素
     */
    public void deleteAll() {
        list.clear();
    }
    /**
     * addAll将数组元素依次添加到list中
     */
    public void addAll(Node[] arr) {
        for (int i=0;i<arr.length;i++) {
            /**
             * 如果是最后一个元素，则不指定next
             */
            if (i == arr.length - 1) {
                list.add(arr[i]);
                continue;
            }
            arr[i].next = arr[i+1];
            /**
             * 添加到list中
             */
            list.add(arr[i]);
        }
    }
    /**
     * find方法，参数：num --- int
     */
    public int find(int num) {
        NodeListIterator iterator1 = iterator();
        while (iterator1.hasNext()) {
            Node next = iterator1.next();
            /**
             * 第一次匹配到的元素
             */
            if (next.num == num) {
                return list.indexOf(next);
            }
        }
        return -1;
    }
    /**
     * 遍历器对象
     */
    public NodeListIterator iterator() {
        iterator.setPosition(0);
        return this.iterator;
    }
    /**
     * 遍历器类NodeListIterator
     */
    public static class NodeListIterator {

        private List<Node> nodeList = new LinkedList<>();
        private Node node;

        /**
         * 下一个节点nextNode
         */
        private Node nextNode;

        /**
         * 当前的位置 position --- int
         */
        private int position;

        /**
         * 构造器
         */
        public NodeListIterator(List<Node> list) {
            this.nodeList = list;
        }
        public void setPosition(int position) {
            this.position = position;
        }
        /**
         * 设置第二个节点
         */
        public void setSecond(Node node) {
            this.nextNode = node;
        }
        /**
         * 当前Node节点是否包含下一个Node
         * @return
         */
        public boolean hasNext() {
            if (position > nodeList.size() - 1) return false;
            return (this.nextNode = this.nodeList.get(position)) != null;
        }
        /**
         * next取下一个节点Node
         */
        public Node next() {
            position++;
            return this.nextNode;
        }
    }
}