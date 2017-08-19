package content.jdbc;

import java.sql.Connection;

public class MultiThreadConnection {

	public static void main(String[] args) {
		Thread t1=new TaskConn(5000);
		Thread t2=new TaskConn(5000);
		Thread t3=new TaskConn(5000);
		t1.start();
		t2.start();
		t3.start();

	}
	

}
class TaskConn extends Thread{
	private int wait;
	TaskConn(int wait){
		this.wait=wait;
	}
	public void run(){
		Connection conn=null;
		try {
			conn=PoolUtils.getConnection();
			System.out.println("连接成功"+conn);
			Thread.sleep(wait);
			System.out.println("wait阻塞结束");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			PoolUtils.close(conn);
		}
	}
}