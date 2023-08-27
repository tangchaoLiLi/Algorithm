package test;

import interfaces.IDemo;

public class IDemoImp implements IDemo {
    @Override
    public void show() {
        System.out.println("结果：" + TAG);
        System.out.println("结果：" + Ok);
        System.out.println("结果：" + toString());
    }

    @Override
    public String toString() {
        return ("结果：" + "TAG = " + TAG + ", Ok = " + Ok);
    }

    public static void main(String[] args) {
        IDemo demo = new IDemoImp();
        demo.show();
    }
}
