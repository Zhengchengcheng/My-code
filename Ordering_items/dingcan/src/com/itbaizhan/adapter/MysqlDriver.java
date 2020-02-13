package com.itbaizhan.adapter;

/**
 * @Author: lcp
 * @Date: 2019/12/2 18:07
 */
public class MysqlDriver implements JdbcDriver {
    public String getDriver() {
        return "com.mysql.cj.jdbc.Driver";
    }
}
