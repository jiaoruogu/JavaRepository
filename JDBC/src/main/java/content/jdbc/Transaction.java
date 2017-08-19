

package content.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transaction {

public static void main(String[] args) {
        
        pay(10.0,2,3);
    }
    public static void pay(Double money,int from,int to){
        String sql1="update demo set salary=salary+? where  id=? ";
        String sql2="select salary from demo where id=?";
        Connection conn=null;
        try {
            conn=PoolUtils.getConnection();
            //关闭事物自动提交
            conn.setAutoCommit(false);
            PreparedStatement ps=conn.prepareStatement(sql1);
            //减钱
            ps.setDouble(1, -money);
            ps.setInt(2, from);
            int n=ps.executeUpdate();
            if(n!=1){
                throw new Exception("扣错了");
            }
            //增加
            ps.setDouble(1, money);
            ps.setInt(2, to);
            n=ps.executeUpdate();
            if(n!=1){
                throw new Exception("加错了");
            }
            ps.close();
            //检查
            ps=conn.prepareStatement(sql2);
            ps.setInt(1, from);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getDouble("balance")<0){
                    throw new Exception ("余额不足");
                }
            }
            conn.commit();
            System.out.println("操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            //假若过程中抛异常，则执行
            PoolUtils.rollback(conn);
        }finally{
            PoolUtils.close(conn);
        }
    }

}
