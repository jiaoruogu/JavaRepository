package ne.packet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import test.jdbc.PoolUtils;

/**
 * 批量参数处理
 * @author bokun_sx1
 *
 */
public class MultiParam {

	public static void main(String[] args) {
		String sql="insert into robin_user "
				+ "(id,name,pwd)"
				+ "values  (?,?,?)";
		Connection conn=null;
		try {
			conn=PoolUtils.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			
			for(int i=0;i<100;i++){
				//替换参数
				ps.setInt(1, i);
				ps.setString(2, "name"+i);
				ps.setString(3, "123");
				//将参数添加到缓冲区
				ps.addBatch();
				//避免内存溢出
				if((i+1%8)==1){
					
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			//批量执行
			int[] arr=ps.executeBatch();
			System.out.println(Arrays.toString(arr));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			PoolUtils.close(conn);
		}

	}

}
