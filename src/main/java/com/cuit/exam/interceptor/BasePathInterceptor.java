package com.cuit.exam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cuit.exam.entity.TUser;
import com.cuit.exam.utils.CommonUtil;
import com.cuit.exam.utils.LoginUserUtil;

import freemarker.log.Logger;
/**
 * 
* @ClassName: BasePathInterceptor 
* @Description: 添加bathPath用来获取系统资源
* @author 夏 茂轩  
* @date 2014年2月25日 下午1:03:21 
*
 */
public class BasePathInterceptor extends  HandlerInterceptorAdapter {
	
	private Logger log = Logger.getLogger("BasePathInterceptor");
	
	public BasePathInterceptor() {
	}

	private String mappingURL;//利用正则映射到需要拦截的路径  
        public void setMappingURL(String mappingURL) {  
               this.mappingURL = mappingURL;  
       } 

	/**
	 * 在业务处理器处理请求之前被调用
	 * 如果返回false
	 *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true
	 *    执行下一个拦截器,直到所有的拦截器都执行完毕
	 *    再执行被拦截的Controller
	 *    然后进入拦截器链,
	 *    从最后一个拦截器往回执行所有的postHandle()
	 *    接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("base_path", CommonUtil.getBasePath());
		TUser loginUser=LoginUserUtil.getLoginUser();
		if(loginUser!=null){
			request.setAttribute("login_user", loginUser);
		}
		return true;
	}

	//在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用 
	 * 
	 *   当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
