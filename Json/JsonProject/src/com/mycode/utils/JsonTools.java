package com.mycode.utils;

import net.sf.json.JSONObject;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param key
	 * @param value
	 * @return Json������ַ�����ʾ
	 */
	public static String createJsonString(String key, Object value){
		JSONObject jsonobject = new JSONObject(); 
		jsonobject.put(key, value);
		return jsonobject.toString();
	}
	
}
