package com.mybao123.util;

import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

/**
 * Json 工具类。提供返回前台Json对象封装。
 * 
 */
public class JsonUtils
{
	public static String getJsonObject(String data, boolean isSucceed,
			String message) throws Exception
	{
		JSONObject object = new JSONObject();
		object.accumulate("data", data);
		object.accumulate("isSuceed", isSucceed);
		object.accumulate("message", message);
		String retStr = JSONObject.fromObject(object).toString();
		return retStr;
	}
	public static String getJsonObject(int totalCount,String data,boolean isSucceed,String message) throws Exception
	{
		JSONObject dataObj = new JSONObject();
		JSONObject object = new JSONObject();
		dataObj.accumulate("total", totalCount);
		dataObj.accumulate("rows", data);
		object.accumulate("data", dataObj);
		object.accumulate("isSuceed", isSucceed);
		object.accumulate("message", message);
		String retStr = JSONObject.fromObject(object).toString();
		return retStr;
	}
	public static Date getCreateDate() throws Exception
	{
		Date now= new Date();
		DateFormat d =DateFormat.getDateTimeInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date createDate = sdf.parse(d.format(now));
		return createDate;
	}
	
}