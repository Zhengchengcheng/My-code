package com.itbaizhan.Singleton;

import com.itbaizhan.dao.DB;
import com.itbaizhan.proxy.DbInvocationHandler;
import com.itbaizhan.proxy.DuSuper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: lcp
 * @Date: 2019/12/2 13:08
 */
public class DbSingleton {
    private static DuSuper mydb=new DB();
    static {
        InvocationHandler invocationHandler= new DbInvocationHandler(mydb);
         mydb= (DuSuper) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), new Class<?>[]{ DuSuper.class },invocationHandler);
        //生成jdk代理
    }
    private static class SingletonHolder {
        private static final DbSingleton INSTANCE = new DbSingleton();
    }
    private DbSingleton(){}
    public static final DbSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public DuSuper getDB(){
        return mydb;
    }
}
