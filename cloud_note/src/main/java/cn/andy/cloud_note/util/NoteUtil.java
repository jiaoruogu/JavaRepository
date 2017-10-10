package cn.andy.cloud_note.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	public static String md5(String msg)  {
		//利用MD5加密
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] input=msg.getBytes();
			byte[] output=md.digest(input);
			//将md5处理的output结果转成字符串
			String result=Base64.encodeBase64String(output);
			return result;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	/*
	 * 利用UUID算法生成主键
	 */
	public static String createId(){
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		
		return id.replace("-", "");
	}
	
}
