package test;

import utils.NodeList;
import utils.NodeList.Node;

import java.util.stream.*;

/**
 * 自定义链表
 * 创建Node类，包含属性：next --- Node n
 */
public class LinkedListTest {

    /**
     * 链表类Node的操作类NodeUtil
     * 构造器方法，参数：Node数组
     *
     */
    static class NodeUtil {
        public static NodeList createNodesQueue(Node[] arr) {
            NodeList nodeList = NodeList.getInstance();
//            NodeList nodeList = new NodeList();

            nodeList.addAll(arr);

            return nodeList;
        }
    }


    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        Node[] arr = new Node[]{n1, n2, n3, n4, n5};
        NodeList nodesQueue = NodeUtil.createNodesQueue(arr);
        /**
         * 遍历list元素
         */
        NodeList.NodeListIterator iterator = nodesQueue.iterator();
        while(iterator.hasNext()) {
            Node next = iterator.next();
            System.out.println("当前元素的值：" + next.num);
//            System.out.println("下一个元素的值：" + next.next.num);
        }

        Node node = n1;
        while (node != null) {
            System.out.println("元素获取的结果：" + node.num);
            node = node.next;
        }

        /**
         * 删除某项元素，
         * 位置：n
         */
        Node node1 = nodesQueue.deleteEnd(2);
        iterator = nodesQueue.iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
            System.out.println("删除后的元素：" + next.num);
        }
        System.out.println("删除的元素：" + node1.num);
        System.out.println("2的位置：" + nodesQueue.find(2));
        System.out.println("4的位置：" + nodesQueue.find(4));
    }
}
