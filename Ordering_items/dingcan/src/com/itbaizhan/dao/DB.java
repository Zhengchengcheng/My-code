package com.itbaizhan.dao;

import com.itbaizhan.adapter.DBAdapter;
import com.itbaizhan.adapter.JdbcDriver;
import com.itbaizhan.adapter.MysqlDriver;
import com.itbaizhan.proxy.DuSuper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB implements DuSuper
{
	private Connection con;

	private PreparedStatement pstm;//PreparedStatement����pstm 

	private String user = "root";

	private String password = "*zcc44176788";

	//private String className = "com.mysql.cj.jdbc.Driver";//�����������

	private String url = "jdbc:mysql://localhost:3306/db_dingcan?useUnicode=true&serverTimezone=UTC";

	public DB()
	{
		try
		{
			JdbcDriver mysqlDriver = new MysqlDriver();
			JdbcDriver dbAdapter = new DBAdapter(mysqlDriver);
			Class.forName(dbAdapter.getDriver());//JDBC
		} catch (ClassNotFoundException e)
		{
			System.out.println("乱码1");
			e.printStackTrace();
		}
	}

	
	public Connection getCon()
	{
		try
		{
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e)
		{
			System.out.println("乱码2");
			con = null;
			e.printStackTrace();
		}
		return con;
	}
	
	public void doPstm(String sql, Object[] params)//params
	{
		if (sql != null && !sql.equals(""))//sql
		{
			if (params == null)//
				params = new Object[0];//params

			getCon();//getCon()
			if (con != null)
			{
				try
				{
					System.out.println(sql); //SQL
					pstm = con.prepareStatement(sql,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					for (int i = 0; i < params.length; i++)
					{
						pstm.setObject(i + 1, params[i]);
					}
					pstm.execute(); 
				} catch (SQLException e)
				{
					System.out.println("doPstm()乱码");
					e.printStackTrace();
				}
			}
		}
	}
	
	public ResultSet getRs() throws SQLException
	{
		return pstm.getResultSet();
	}
	public int getCount() throws SQLException
	{
		return pstm.getUpdateCount();
	}
	public void closed()
	{
		try
		{
			if (pstm != null)
				pstm.close();
		} catch (SQLException e)
		{
			System.out.println("乱码3");
			e.printStackTrace();
		}
		try
		{
			if (con != null)
			{
				con.close();
			}
		} catch (SQLException e)
		{
			System.out.println("乱码4");
			e.printStackTrace();
		}
	}
}
