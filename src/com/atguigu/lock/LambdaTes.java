package com.atguigu.lock;

/**
 * 我是你爹
 */
@FunctionalInterface
interface Foo{
    public int test1(int x,int y);

    default int test2(int x, int y) {
        return x+y;
    }
}
public class LambdaTes {

    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public int test1(int x, int y) {
//                return x+y;
//            }
//        };

        Foo foo1 = (x,y) ->{return x+y;};
        System.out.println(foo1.test1(6,5));
        System.out.println(foo1.test2(6,4));


    }
}
