package com.halo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/**
	 * 32位小写
	 * @param str
	 * @return
	 */
	public static String to32LowerMD5(String str){
		String s = null;
		try{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] bytes = md5.digest(str.getBytes());
		StringBuffer stringBuffer = new StringBuffer();
		for(byte b : bytes ){
			int bt = b&0xff;
			if(bt < 16){
				stringBuffer.append(0);
			}
			stringBuffer.append(Integer.toHexString(bt));
		}
		s = stringBuffer.toString();
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 16位小写
	 * @param str
	 * @return
	 */
	public static String to16LowerMD5(String str){  
        String reStr = to32LowerMD5(str);  
        if (reStr != null){  
            reStr = reStr.toUpperCase().substring(8, 24);  
        }  
        return reStr;  
    }  
	
	
	

}
