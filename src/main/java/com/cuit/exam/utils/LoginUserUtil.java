package com.cuit.exam.utils;

import com.cuit.exam.entity.TUser;
/**
 * 
* @ClassName: LoginUserUtil 
* @Description: 登录用户辅助类用来获取系统登录用户
* @author 夏 茂轩  
* @date 2014年2月24日 下午9:40:28 
*
 */
public class LoginUserUtil {
	
	private static TUser loginUser=null;
	
	public static TUser getLoginUser(){
		if(loginUser!=null)
		return loginUser;
		else {
			return null;
		}
	}
	
	public static void setLoginUser(TUser loginUser){
		LoginUserUtil.loginUser=loginUser;
	}
	
	public static void removeLoginUser(){
		LoginUserUtil.loginUser=null;
	}
}
