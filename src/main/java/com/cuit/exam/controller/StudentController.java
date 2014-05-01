package com.cuit.exam.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
* @ClassName: StudentController 
* @Description: 学生Controller
* @author 夏 茂轩  
* @date 2014年2月24日 下午9:36:41 
*
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	protected static Logger logger = Logger.getLogger("StudentController");


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getCommonPage() {
		logger.debug("Received request to show common page");
		return "student_home";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@ResponseBody
	public String getAadminPage() {
		logger.debug("Received request to show admin page");
		return "adminpage";
	}

}