package com.cuit.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.exam.utils.CommonUtil;
import com.cuit.exam.utils.ImageCodeUtil;
/**
 * 
* @ClassName: CodeFilter 
* @Description: 验证码检验Filter
* @author 夏 茂轩  
* @date 2014年2月24日 下午9:37:11 
*
 */
public class CodeFilter extends HttpServlet implements Filter {
	/**
	 * 判断用户输入的验证码是否正确
	 */
	private static final long serialVersionUID = -5838154525730151323L;

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String code = request.getParameter("j_code");
		if (code != null && !code.isEmpty()) {
			if (code.equalsIgnoreCase(ImageCodeUtil.getCode())) {
				filterChain.doFilter(request, response);
			}
			else {
				response.sendRedirect("login/login");
			}
		} else {
			response.sendRedirect("login/login");
		}
	}
}
