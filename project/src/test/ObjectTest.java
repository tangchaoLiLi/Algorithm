package test;

/**
 * 测试
 */
import java.util.*;
public class ObjectTest {
    /**
     * 创建一个类，Person
     * 属性有：name、age
     */
    static class Person {
        public String name;
        public int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public boolean equals(Object p) {
            if (p instanceof Person) {
                return ((Person) p).name.equals(this.name);
            }
            return super.equals(p);
        }
    }
    public static void main(String[] args) {
        List<Person> list = new LinkedList<>(){
            {
                add(new Person("tangchao", 29));
                add(new Person("lili", 28));
                add(new Person("gege", 22));
                add(new Person("meimei", 21));
                add(new Person("tangchao", 30));
            }
        };
        if (list.get(0).equals("tag")) {
            System.out.println("haha");
        } else {
            System.out.println("kuku");
        }
    }
}
