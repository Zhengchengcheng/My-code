package com.itbaizhan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: lcp
 * @Date: 2019/12/2 13:50
 */
public class DbInvocationHandler implements InvocationHandler {
    private DuSuper targer;

    public DbInvocationHandler(DuSuper targer) {
        this.targer = targer;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("开始数据操作");
        Object object = method.invoke(targer, objects);
        System.out.println("数据操作结束");
        return object;
    }
}
