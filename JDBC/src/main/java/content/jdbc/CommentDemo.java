package ne.packet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.jdbc.PoolUtils;

public class CommentDemo {

	public static void main(String[] args) {
		
		Connection conn=null;
		try {
			conn=PoolUtils.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into r_keywords(id,word) "
					+ "values (k_seq.nextval,?)";
			String[] cols={"id"};
			PreparedStatement ps=conn.prepareStatement(sql, cols);
			ps.setString(1, "雾霾");
			int n=ps.executeUpdate();
			if(n!=1){
				throw new Exception ("话题添加失败");
			}
			//获取自动生成的ID
			ResultSet rs=ps.getGeneratedKeys();
			int id=-1;
			while(rs.next()){
				id=rs.getInt(1);
			}
			ps.close();
			String sql2="insert into r_post "
					+ "(id,content,k_id) values "
					+ "(p_seq.nextval,?,?)";
			ps=conn.prepareStatement(sql2);
			ps.setString(1, "今天天气不好");
			ps.setInt(2, id);
			n=ps.executeUpdate();
			if(n!=1){
				throw new Exception("天气好");
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			PoolUtils.close(conn);
		}

	}

}
