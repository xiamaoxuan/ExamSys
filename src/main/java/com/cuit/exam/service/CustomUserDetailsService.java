package com.cuit.exam.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cuit.exam.dao.TUserDAO;
import com.cuit.exam.entity.TUser;
import com.cuit.exam.utils.LoginUserUtil;

/**
 * 
* @ClassName: CustomUserDetailsService 
* @Description: 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
* @author 夏 茂轩  
* @date 2014年2月24日 下午9:37:45 
*
 */
public class CustomUserDetailsService implements UserDetailsService {

	protected static Logger logger = Logger
			.getLogger("CustomUserDetailsService");

	@Autowired
	private TUserDAO userDAO;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserDetails user = null;
		try {
			List<TUser> users = userDAO.findByUserNo(username);
			if (users.size() > 0) {
				TUser loginUser = users.get(0);
				user = new User(username,
						loginUser.getPassword().toLowerCase(), true, true,
						true, true,
						getAuthorities(loginUser.getTRole().getId()));
						LoginUserUtil.setLoginUser(loginUser);
			}
			else {
				
			}
		} catch (Exception e) {
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return user;
	}

	/**
	 * 获得访问角色权限
	 * 
	 * @param access
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		logger.debug("Grant ROLE_STUDENT to this user");
		authList.add(new GrantedAuthorityImpl("ROLE_STUDENT"));

		if (access.compareTo(2) == 0) {
			logger.debug("Grant ROLE_TEACHER to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_TEACHER"));
		}
		if (access.compareTo(3) == 0) {
			logger.debug("Grant ROLE_ADMIN to this user");

            authList.add(new GrantedAuthorityImpl("ROLE_TEACHER"));

			authList.add(new GrantedAuthorityImpl("ROLE_ANDMIN"));
		}
		return authList;
	}
}