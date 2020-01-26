package com.colin.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC������
 * @author colin.chen
 * @since 2018-01-16
 */
public class JDBCHelper {

	private String driver;
	private String url;
	private String dbUser;
	private String dbPwd;

	public JDBCHelper(String fileName){
		Properties props = new Properties();
		try {
			/**
			 * getResourceAsStream()���ص��ǵ�ǰ���Ŀ¼
			 * ���������Ǿ���·�������·��
			 */
			props.load(this.getClass().getResourceAsStream(fileName));
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			dbUser = props.getProperty("dbUser");
			dbPwd = props.getProperty("dbPwd");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���� 
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbUser, dbPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر����ݿ�ռ����Դ�� 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void closeResource(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ѯ�������õ������
	 * @param con
	 * @param sql
	 * @return
	 */
	public ResultSet query(Connection conn, String sql) {
		ResultSet rs = null;
		try {
			if (conn == null) {
				throw new Exception("database connection can't use!");
			}
			if (sql == null)
				throw new Exception("check your parameter: 'sql'! don't input null!");
			// �������
			Statement stmt = conn.createStatement();
			// ִ�в�ѯ
			rs = stmt.executeQuery(sql);
			// ResultSetMetaData rMeta = rs.getMetaData();
			// ��������ֶθ���
			// int numColumns = rMeta.getColumnCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * �Զ�ִ�и���ɾ���Ĳ���
	 * @param con
	 * @param sql
	 * @return
	 */
	public int executeAuto(Connection conn, String sql) {
		try {
			if (conn == null)
				return -1;
			Statement stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * �ֶ��ύ����ɾ���Ĳ���
	 * @param conn
	 * @param sql
	 */
	public void executeManu(Connection conn, String sql){
		try {
			if (conn == null)
				return;
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ô洢����
	 * �������ƣ�
	 * @param conn
	 */
	public void execute(Connection conn, String procName, Object[] params) {
		CallableStatement callableStatement = null;
		try {
			conn.setAutoCommit(false);
			// ���ô洢����
			callableStatement = conn.prepareCall("{call " + procName + "(?)}");
			// ���ݲ������洢����
			callableStatement.setInt(1, 6);
			// ִ�д洢����
			callableStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡԪ����
	 * @param conn
	 */
	public void getTableMeta(Connection conn, String tableName){
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			//��ȡ������
		    String dataName = dbmd.getDriverName();
		    String dataURL = dbmd.getURL();
		    //��ȡ���ݿ����֧���ֽ���
		    int dataMaxSize = dbmd.getMaxRowSize();
		    //��ȡ���ݿ����Ϣ
		    String[] types = new String[1];
		    types[0] = "TABLE"; 
		    ResultSet tableResult = dbmd.getTables(null, null, "%", types);
		    //��ȡ��������Ϣ
		    ResultSet pkResult = dbmd.getPrimaryKeys(null, null, tableName);
		    //��ȡ�������Ϣ
		    ResultSet fkResult  = dbmd.getImportedKeys(null, null, tableName);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ�����Ԫ����
	 * @param conn
	 * @param tableName
	 */
	public void getResultMeta(ResultSet rs) {
		try {
			ResultSetMetaData rsInfo = rs.getMetaData();
			// ��ȡ��������
			int columnCount = rsInfo.getColumnCount();
			// ��ȡ����������
			for (int i = 1; i < columnCount + 1; i++) {
				String columeName = rsInfo.getColumnName(i);
				String columeType = rsInfo.getColumnTypeName(i);
				boolean autocol = rsInfo.isAutoIncrement(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
