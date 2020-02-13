package com.itbaizhan.proxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: lcp
 * @Date: 2019/12/2 13:53
 */
public interface DuSuper {
    public Connection getCon();
    public void doPstm(String sql, Object[] params);
    public ResultSet getRs() throws SQLException;
    public int getCount() throws SQLException;
    public void closed();

}
