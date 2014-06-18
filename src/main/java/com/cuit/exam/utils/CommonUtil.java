package com.cuit.exam.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 
 * @ClassName: CommonUtil
 * @Description: 公用方法的工具类
 * @author 夏 茂轩
 * @date 2014年2月24日 下午9:35:24
 * 
 */
public class CommonUtil {
	
	private static String[] qtnType={"单选","填空","简答","解释","判断","多选"};
	
	private static String[] difficulty={"容易","中等","难","压轴"};

	/**
	 * 字符串类型转换
	 * 
	 * @param obj
	 * @return String
	 */
	public static String toString(Object obj) {
		String objStr = "";
		if (obj != null) {
			objStr = obj.toString();
		}
		return objStr;
	}

	/**
	 * 布尔类型转换
	 * 
	 * @param strFlg
	 * @return Boolean
	 */
	public static Boolean toBoolean(String strFlg) {
		Boolean reslutFlg = false;
		if (strFlg != null) {
			if (strFlg.equals("1")) {
				reslutFlg = true;
			}

			if (strFlg.equals("true")) {
				reslutFlg = true;
			}
		}
		return reslutFlg;
	}

	public static String getBasePath() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) ra)
				.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		return basePath;
	}
	/**
	 * 
	* @Title: objectToJson 
	* @Description: 对象转Json
	* @param @param object
	* @param @return    json字符串
	* @return String    返回类型 
	* @throws
	 */
	public static String objectToJson(Object object) {
		JSONArray jsonArray=JSONArray.fromObject(object);
		return jsonArray.toString();
	}
	/**
	 * 
	* @Title: listTOJson 
	* @Description: List转JSON
	* @param @param list
	* @param @return    JSON字符串
	* @return String    返回类型 
	* @throws
	 */
	public static String listTOJson(List<?> list){
		JSONArray jsonArray=JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	/**
	 * 
	* @Title: mapTOJson 
	* @Description: map转换成JSON
	* @param @param map
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String mapTOJson(Map<String, Object> map){
		JSONArray jsonArray=JSONArray.fromObject(map);
		return jsonArray.toString();
	}
	/**
	 * 
	* @Title: qtnTypeText 
	* @Description: 返回难度的Text 
	* @param @param num
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getQtnTypeText(int num){
		return qtnType[num];
	}
	
	/**
	 * 
	* @Title: getDifficultyText 
	* @Description: 返回难度的Text 
	* @param @param num
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getDifficultyText(int num){
		return difficulty[num];
	}
}
