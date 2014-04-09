package com.cuit.exam.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.cuit.exam.entity.TUser;
import com.cuit.exam.utils.CommonUtil;
import com.cuit.exam.utils.ImageCodeUtil;
import com.cuit.exam.utils.LoginUserUtil;

import freemarker.log.Logger;
/**
 * 
* @ClassName: LoginController 
* @Description: 登录Controller
* @author 夏 茂轩  
* @date 2014年2月24日 下午9:36:08 
*
 */
@Controller
@RequestMapping("login")
public class LoginController {
	protected static Logger logger = Logger.getLogger("LoginController");
	
	@Autowired
	private WebApplicationContext context;

	/**
	 * 指向登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(HttpServletResponse response) {
		UserDetails userDetails=null;
		try {
			 userDetails = (UserDetails) SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
		} catch (Exception e) {
			return "login";
		}
		if(null==LoginUserUtil.getLoginUser()||userDetails==null)
		return "login";
		else {
			try {
				response.sendRedirect(CommonUtil.getBasePath()+"login/redirect");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 指定无访问额权限页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public String loginOut() throws Exception {
		LoginUserUtil.removeLoginUser();
		return "login";
	}

	/**
	 * 验证码的获取
	 * 
	 * @param reqeust
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/imageCode", method = RequestMethod.GET)
	public void getCde(HttpServletRequest reqeust, HttpServletResponse response)
			throws IOException {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		ImageCodeUtil instance = new ImageCodeUtil();
		instance.write(response.getOutputStream());
	}

	/**
	 * 重定位逻辑
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public void loginRedirect(HttpServletResponse response) throws IOException {
		TUser loginUser = LoginUserUtil.getLoginUser();
		if (loginUser == null) {
			response.sendRedirect(CommonUtil.getBasePath()+"login/login");
		} else {
			if (loginUser.getTRole().getId().equals(1)) {
				response.sendRedirect(CommonUtil.getBasePath()+"student/home");
			}
			if (loginUser.getTRole().getId().equals(2)) {
				response.sendRedirect(CommonUtil.getBasePath()+"teacher/home");
			}
			if (loginUser.getTRole().getId().equals(3)) {
			}
		}
	}

	@RequestMapping(value = "/codeCheck", method = RequestMethod.GET)
	@ResponseBody
	public String codeCheck(
			@RequestParam(value = "j_code", required = false) String code,
			HttpServletRequest request) throws IOException {
		if (code != null && !code.isEmpty()) {
			if (code.equalsIgnoreCase(ImageCodeUtil.getCode())) {
				return "success";
			}
		}
		return "fail";
	}

	@RequestMapping(value = "/errorCath", method = RequestMethod.GET)
	public void errorRedirect(HttpServletResponse response,HttpServletRequest request)
			throws IOException {
		response.sendRedirect(CommonUtil.getBasePath()+"login/error");
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(HttpServletResponse response,HttpServletRequest request)
			throws IOException {
		return "error404";
	}

	@RequestMapping(value = "/login/**", method = RequestMethod.GET)
	public void loginInterceptor(HttpServletResponse response) {

		try {
			response.sendRedirect(CommonUtil.getBasePath()+"login/redirect");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public void loginInterceptor2(HttpServletResponse response) {

		try {
			response.sendRedirect(CommonUtil.getBasePath()+"login/redirect");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
