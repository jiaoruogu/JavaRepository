package ne.packet;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import test.jdbc.PoolUtils;

public class MutilPro {
	/**
	 * 执行一批DDL
	 * 不支持事务
	 * @param args
	 */
	public static void main(String[] args) {
		String sql1="create table log_01 "
				+ "(id number(8), "
				+ "msg varchar2(100))";
		String sql2="create table log_02 "
				+ "(id number(8), "
				+ "msg varchar2(100))";
		String sql3="create table log_03 "
				+ "(id number(8), "
				+ "msg varchar2(100))";
		//执行一批sql
		Connection conn=null;
		try {
			conn=PoolUtils.getConnection();
			Statement st=conn.createStatement();
			//sql1添加到Statement的缓存区中
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.addBatch(sql3);
			//批量执行
			int[] arr=st.executeBatch();
			System.out.println(Arrays.toString(arr));
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			PoolUtils.close(conn);
		}
	}

}
