package com.xh.bbs.utils;

import java.security.MessageDigest;
public class MD5 {
	public static String generateCode(String str) throws Exception{
		MessageDigest md5=MessageDigest.getInstance("MD5");
		byte[] srcBytes=str.getBytes();
		md5.update(srcBytes);
		byte[] resultBytes=md5.digest();
		String result=new String(resultBytes);
		return result;
	}
}
