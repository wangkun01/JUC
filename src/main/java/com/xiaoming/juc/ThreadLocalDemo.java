package com.xiaoming.juc;

/**
 * @ClassName ThreadLocalDemo
 * @Description: TODO
 * @Author xiaoming
 * @Date 2020/3/3010:50 下午
 * @Version 1.0.0
 **/
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
         protected  Integer initialValue(){
            return 0 ; // 重写initialValue方法，设置num初始值
        }
    };
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                int result = num.get().intValue() + 5;
                System.out.println(Thread.currentThread().getName() + "->"+ result);
            },"Thread" + i).start();
        }

    }
}
