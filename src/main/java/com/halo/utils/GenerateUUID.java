package com.halo.utils;

import java.util.UUID;


public class GenerateUUID {
	
	
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 生成指定类型的UUID，便于分类管理
	 * @return
	 */
	public static String getTypeUUID(String type){
		String uuid = UUID.randomUUID().toString();
		return type+uuid;
	}

}
