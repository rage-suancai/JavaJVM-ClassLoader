package com.test4;

public class Main {

    public static class Test {

        static  {
            System.out.println("我被初始化了...");
        }

        //public static String str = "都看到这里了 不给个三连加关注?";
        public final static String str = "都看到这里了 不给个三连加关注?";

    }

    public static void main(String[] args) {

        System.out.println(Test.str);

    }

}
