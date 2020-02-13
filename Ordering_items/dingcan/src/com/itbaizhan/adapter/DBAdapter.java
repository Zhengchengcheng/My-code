package com.itbaizhan.adapter;

/**
 * @Author: lcp
 * @Date: 2019/12/2 18:08
 */
public class DBAdapter implements JdbcDriver {
    private JdbcDriver jdbcDriver;

    public DBAdapter(JdbcDriver jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getDriver() {
        return jdbcDriver.getDriver();
    }
}
